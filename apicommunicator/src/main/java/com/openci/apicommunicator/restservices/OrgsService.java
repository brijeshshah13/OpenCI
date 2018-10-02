package com.openci.apicommunicator.restservices;

import androidx.annotation.Nullable;

import com.openci.apicommunicator.R;
import com.openci.apicommunicator.callbacks.IAPICallBack;
import com.openci.apicommunicator.interfaces.IOrgs;
import com.openci.apicommunicator.models.LibApp;
import com.openci.apicommunicator.models.OrgResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.openci.apicommunicator.restservices.APIClient.getPrivateClient;
import static com.openci.apicommunicator.restservices.APIClient.getPublicClient;

/**
 * Created by Vicky on 05-02-2018.
 */

public class OrgsService {

    public static void getIndividualOrg(String public_travis_token,  String private_travis_token,int id, @Nullable final IAPICallBack callback){
        String public_authorization_token;
        String private_authorization_token;
        Retrofit retrofit;
        Call<OrgResponse> orgsResponseCall;

        if(public_travis_token != null){
            public_authorization_token = "token " + public_travis_token;
            retrofit = getPublicClient();
            IOrgs orgs = retrofit.create(IOrgs.class);
            orgsResponseCall = orgs.getIndividualOrg(
                id,
                public_authorization_token
            );
        }
        else{
            private_authorization_token = "token " + private_travis_token;
            retrofit = getPrivateClient();
            IOrgs orgs = retrofit.create(IOrgs.class);
            orgsResponseCall = orgs.getIndividualOrg(
                id,
                private_authorization_token
            );
        }
        // Yet to deal if both tokens are null
        orgsResponseCall.enqueue(new Callback<OrgResponse>() {
            @Override
            public void onResponse(Call<OrgResponse> call, Response<OrgResponse> response) {
                if(response != null){
                    callback.onSuccess(response.body());
                }
                else{
                    callback.onError(LibApp.getContext().getString(R.string.null_general_response));
                }
            }

            @Override
            public void onFailure(Call<OrgResponse> call, Throwable t) {
                if(t != null && t.getMessage() != null){
                    callback.onError(t.getMessage());
                }
                else{
                    callback.onError(LibApp.getContext().getString(R.string.null_failure_response));
                }
            }
        });
    }
}
