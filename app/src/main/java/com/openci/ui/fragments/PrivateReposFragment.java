package com.openci.ui.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.openci.R;
import com.openci.apicommunicator.callbacks.IAPICallBack;
import com.openci.apicommunicator.models.BuildResponse;
import com.openci.apicommunicator.models.OrgResponse;
import com.openci.apicommunicator.models.ReposResponse;
import com.openci.apicommunicator.models.UserResponse;
import com.openci.apicommunicator.models.submodels.ReposDefaultBranch;
import com.openci.apicommunicator.models.submodels.ReposOwner;
import com.openci.apicommunicator.models.submodels.Pagination;
import com.openci.apicommunicator.models.RepoResponse;
import com.openci.apicommunicator.restservices.OrgsService;
import com.openci.apicommunicator.restservices.UserService;
import com.openci.ui.views.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;
import static com.openci.apicommunicator.restservices.ReposService.getRepos;
import static com.openci.common.views.BaseFragment.hideProgressBar;
import static com.openci.common.views.BaseFragment.showProgressBar;
import static com.openci.common.Constants.PREFS_NAME;
import static com.openci.utils.DateUtils.getDate;
import static com.openci.utils.DateUtils.rfc3339ToMills;

/**
 * Created by Vicky on 10-01-2018.
 */

public class PrivateReposFragment extends Fragment {

    RecyclerView mPrivateReposRV;
    private ProgressBar progressBar;
    private static String private_travis_token = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_repos,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        private_travis_token = sharedPreferences.getString("private_travis_token", null);

        mPrivateReposRV = view.findViewById(R.id.repos_recycler_view);
        mPrivateReposRV.setHasFixedSize(true);
        mPrivateReposRV.setItemViewCacheSize(20);
        mPrivateReposRV.setDrawingCacheEnabled(true);
        mPrivateReposRV.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        mPrivateReposRV.setLayoutManager(new LinearLayoutManager(getActivity()));

        progressBar = view.findViewById(R.id.pgb_repos);
        showProgressBar(progressBar);
        mPrivateReposRV.setVisibility(View.GONE);

        getRepos(null, private_travis_token, new IAPICallBack() {
            @Override
            public void onSuccess(@NonNull Object value) {
                hideProgressBar(progressBar);
                mPrivateReposRV.setVisibility(View.VISIBLE);
                if(value instanceof ReposResponse){
                    ReposResponse reposResponse = (ReposResponse) value;
                    Pagination reposPagination = reposResponse.getPagination();
                    if(reposPagination.getCount() != 0){
                        ContentAdapter adapter = new ContentAdapter(getActivity(),reposResponse.getRepositories());
                        mPrivateReposRV.setAdapter(adapter);
                    }
                    else {
                        // display on the screen
                        Toast.makeText(getActivity(), "No private repos",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onError(@NonNull String errorMessage) {
                // handle error response
            }
        });
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView avatar;
        public TextView slug;
        public TextView last_run_time;
        public TextView branch;
        public LottieAnimationView last_build_status;
        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_repos, parent, false));
            avatar = (ImageView) itemView.findViewById(R.id.list_avatar);
            slug = (TextView) itemView.findViewById(R.id.list_title);
            last_run_time = (TextView) itemView.findViewById(R.id.list_last_run_time);
            branch = (TextView) itemView.findViewById(R.id.list_branch);
            last_build_status = (LottieAnimationView) itemView.findViewById(R.id.list_last_build_status);
        }
    };

    public static class ContentAdapter extends RecyclerView.Adapter<PrivateReposFragment.ViewHolder> {
        // Set numbers of List in RecyclerView.
        private ArrayList<RepoResponse> repos;
        private Context mContext;

        public ContentAdapter(Context context, ArrayList<RepoResponse> privateRepos) {
            mContext = context;
            repos = privateRepos;
        }

        @Override
        public PrivateReposFragment.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new PrivateReposFragment.ViewHolder(LayoutInflater.from(mContext), parent);
        }

        @Override
        public void onBindViewHolder(final PrivateReposFragment.ViewHolder holder, int position) {

            RepoResponse repo = repos.get(position);
            holder.slug.setText(repo.getSlug());

            BuildResponse buildResponse = repo.getBuildResponse();
            if(buildResponse == null) {
                holder.last_run_time.setText("No build found!");
            }
            else {
                Long dateTime = rfc3339ToMills(buildResponse.getFinishedAt());
                String date = getDate(dateTime);
                if (date.toLowerCase().contains("AM".toLowerCase()) || date.toLowerCase().contains("PM".toLowerCase())) {
                    holder.last_run_time.setText(mContext.getString(R.string.last_build_time_1, date));
                } else {
                    holder.last_run_time.setText(mContext.getString(R.string.last_build_time, date));
                }
                if(buildResponse.getState() == null) {

                } else {
                    switch (buildResponse.getState()) {
                        //case "created": holder.last_build_status.setImageResource();
                        //case "received": holder.last_build_status.setImageResource();
                        case "started": holder.last_build_status.setAnimation(R.raw.loading_3_dots_animation);
                                        break;
                        case "passed": holder.last_build_status.setImageResource(R.drawable.check);
                                        break;
                        case "failed": holder.last_build_status.setImageResource(R.drawable.close);
                                        break;
                        case "errored": holder.last_build_status.setImageResource(R.drawable.ic_bang);
                                        break;
                        case "canceled": holder.last_build_status.setImageResource(R.drawable.cancel);
                        // TODO: set default case
                    }
                }
            }
            /*
            if(repo.getDescription() == null || repo.getDescription().length() == 0 || repo.getDescription().equals("")) {
                holder.description.setVisibility(View.GONE);
            }
            else {
                holder.description.setText(repo.getDescription());
            }
            */

            ReposDefaultBranch reposDefaultBranch = repo.getReposDefualtBranch();
            holder.branch.setText(reposDefaultBranch.getName());

            ReposOwner reposOwner = repo.getRepoOwner();

            if(reposOwner.getType().equals("user")){
                UserService.getIndividualUser(null, private_travis_token,reposOwner.getId(), new IAPICallBack() {
                    @Override
                    public void onSuccess(@NonNull Object value) {
                        if(value instanceof UserResponse){
                                UserResponse userResponse = (UserResponse) value;
                                String url = userResponse.getAvatarURL();
                                Picasso.with(mContext).load(url).placeholder(R.drawable.avatar_placeholder).fit().transform(new CircleTransform()).into(holder.avatar);
                        }
                    }

                    @Override
                    public void onError(@NonNull String errorMessage) {
                        // handle error response
                    }
                });
            }
            // else it will be an organization
            else {
                OrgsService.getIndividualOrg(null, private_travis_token,reposOwner.getId(), new IAPICallBack() {
                    @Override
                    public void onSuccess(@NonNull Object value) {
                        if(value instanceof OrgResponse){
                                OrgResponse orgResponse = (OrgResponse) value;
                                String url = orgResponse.getAvatarURL();
                                Picasso.with(mContext).load(url).placeholder(R.drawable.avatar_placeholder).fit().transform(new CircleTransform()).into(holder.avatar);
                        }
                    }

                    @Override
                    public void onError(@NonNull String errorMessage) {
                        // handle error response
                    }
                });
            }
        }

        @Override
        public int getItemCount() {
            return repos.size();
        }
    }
}
