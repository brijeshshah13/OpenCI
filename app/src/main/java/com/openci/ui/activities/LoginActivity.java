package com.openci.ui.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.openci.R;

import static com.openci.constants.Constants.CALLBACK_URL;
import static com.openci.constants.Constants.OAUTH_URL;
import static com.openci.constants.Constants.PREFS_NAME;
import static com.openci.models.GitHubConfigHelper.getClientID;

public class LoginActivity extends AppCompatActivity {

    private static String private_travis_token = null;
    private static String public_travis_token = null;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = this.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        public_travis_token = sharedPreferences.getString("public_travis_token", null);
        private_travis_token = sharedPreferences.getString("private_travis_token", null);

        if(public_travis_token != null && private_travis_token != null) {
            Intent intentToMainActivity = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intentToMainActivity);
        }

        setContentView(R.layout.activity_login);
        loginButton = findViewById(R.id.btn_login);
        Log.d("value:", getClientID());
        final String url = OAUTH_URL + "?client_id=" + getClientID() + "&scope=repo&redirect_uri=" + CALLBACK_URL;
        loginButton.setOnClickListener(v -> attemptLogin(url));
    }

    private void attemptLogin(String url){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(i);
    }
}