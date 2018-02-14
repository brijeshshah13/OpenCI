package com.openci.apicommunicator.restservices;

import android.support.annotation.Nullable;

import com.openci.apicommunicator.R;
import com.openci.apicommunicator.callbacks.IAPICallBack;
import com.openci.apicommunicator.interfaces.IGitHubClient;
import com.openci.apicommunicator.interfaces.ITravisClient;
import com.openci.apicommunicator.models.GitHubAccessToken;
import com.openci.apicommunicator.models.LibApp;
import com.openci.apicommunicator.models.TravisAccessToken;
import com.openci.apicommunicator.models.TravisTokenRequest;
import com.openci.apicommunicator.models.TravisTokens;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.openci.apicommunicator.models.GitHubConfigHelper.getClientID;
import static com.openci.apicommunicator.models.GitHubConfigHelper.getSecret;
import static com.openci.apicommunicator.restservices.APIClient.getPrivateClient;
import static com.openci.apicommunicator.restservices.APIClient.getPublicClient;

/**
 * Created by Vicky on 24-12-2017.
 */

public class LoginService {

    private static String CLIENT_ID = getClientID();
    private static String CLIENT_SECRET = getSecret();

    /**
     * First we obtain the GitHub access_token in getTravisToken() and
     * upon success, we proceed to exchange it for Public Travis access_token
     * and Private Travis access_token in getPublicToken() & getPrivateToken() respectively
     * @param code
     * @param callback
     */
    public static void getTravisToken(String code, @Nullable final IAPICallBack callback){
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://github.com/")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        IGitHubClient githubClient = retrofit.create(IGitHubClient.class);
        Call<GitHubAccessToken> accessTokenCall = githubClient.getAccessToken(
                CLIENT_ID,
                CLIENT_SECRET,
                code
        );
        accessTokenCall.enqueue(new Callback<GitHubAccessToken>() {
            @Override
            public void onResponse(Call<GitHubAccessToken> call, Response<GitHubAccessToken> response) {
                if(response != null){
                    String github_token = response.body().getGitHubAccessToken();
                    getPublicToken(github_token, callback);
                }
                else{
                    callback.onError(LibApp.getContext().getString(R.string.null_github_response));
                }
            }

            @Override
            public void onFailure(Call<GitHubAccessToken> call, Throwable t) {
                if(t != null && t.getMessage() != null){
                    callback.onError(t.getMessage());
                }
                else{
                    callback.onError(LibApp.getContext().getString(R.string.null_failure_response));
                }
            }
        });
    }

    static void getPublicToken(final String github_token, @Nullable final IAPICallBack callback){
        Retrofit retrofit = getPublicClient();
        ITravisClient travisClient =   retrofit.create(ITravisClient.class);
        TravisTokenRequest travisTokenRequest= new TravisTokenRequest();
        travisTokenRequest.setGitHubToken(github_token);
        Call<TravisAccessToken> accessTokenCall = travisClient.getAccessToken(
                travisTokenRequest
        );
        accessTokenCall.enqueue(new Callback<TravisAccessToken>() {
            @Override
            public void onResponse(Call<TravisAccessToken> call, Response<TravisAccessToken> response) {
                if(response != null){
                    String public_travis_token = response.body().getTravisAccessToken();
                    getPrivateToken(github_token, public_travis_token, callback);
                }
                else{
                    callback.onError(LibApp.getContext().getString(R.string.null_travis_response));
                }
            }

            @Override
            public void onFailure(Call<TravisAccessToken> call, Throwable t) {
                if(t != null && t.getMessage() != null){
                    callback.onError(t.getMessage());
                }
                else{
                    callback.onError(LibApp.getContext().getString(R.string.null_failure_response));
                }
            }
        });
    }

    static void getPrivateToken(String github_token, final String public_travis_token, @Nullable final IAPICallBack callback){
        Retrofit retrofit = getPrivateClient();
        ITravisClient travisClient = retrofit.create(ITravisClient.class);
        TravisTokenRequest travisTokenRequest= new TravisTokenRequest();
        travisTokenRequest.setGitHubToken(github_token);
        Call<TravisAccessToken> accessTokenCall = travisClient.getAccessToken(
                travisTokenRequest
        );
        accessTokenCall.enqueue(new Callback<TravisAccessToken>() {
            @Override
            public void onResponse(Call<TravisAccessToken> call, Response<TravisAccessToken> response) {
                if(response != null){
                    String private_travis_token = response.body().getTravisAccessToken();
                    TravisTokens token = new TravisTokens(public_travis_token,private_travis_token);
                    callback.onSuccess(token);
                }
                else{
                    callback.onError(LibApp.getContext().getString(R.string.null_travis_response));
                }
            }

            @Override
            public void onFailure(Call<TravisAccessToken> call, Throwable t) {
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
