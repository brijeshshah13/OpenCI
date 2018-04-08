package com.openci.ui.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.openci.R;
import com.openci.apicommunicator.callbacks.IAPICallBack;
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

/**
 * Created by Vicky on 10-01-2018.
 */

public class PrivateReposFragment extends Fragment {

    RecyclerView mPrivateReposRV;
    private static String private_travis_token = null;
    private static String PREFS_NAME = "SHARED_PREFS";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mPrivateReposRV = (RecyclerView) inflater.inflate(R.layout.repos_recycler_view, container, false);
        mPrivateReposRV.setHasFixedSize(true);
        mPrivateReposRV.setItemViewCacheSize(20);
        mPrivateReposRV.setDrawingCacheEnabled(true);
        mPrivateReposRV.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        mPrivateReposRV.setLayoutManager(new LinearLayoutManager(getActivity()));
        return mPrivateReposRV;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        private_travis_token = sharedPreferences.getString("private_travis_token", null);

        getRepos(null, private_travis_token, new IAPICallBack() {
            @Override
            public void onSuccess(@NonNull Object value) {
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
        public TextView description;
        public TextView branch;
        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_repos, parent, false));
            avatar = (ImageView) itemView.findViewById(R.id.list_avatar);
            slug = (TextView) itemView.findViewById(R.id.list_title);
            description = (TextView) itemView.findViewById(R.id.list_desc);
            branch = (TextView) itemView.findViewById(R.id.list_branch);
        }
    }

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

            if(repo.getDescription() == null || repo.getDescription().length() == 0 || repo.getDescription().equals("")) {
                holder.description.setVisibility(View.GONE);
            }
            else {
                holder.description.setText(repo.getDescription());
            }

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
