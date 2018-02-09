package com.openci.ui.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.openci.R;

import static com.openci.models.GitHubConfigHelper.getClientID;

public class LoginActivity extends AppCompatActivity {

    public static String OAUTH_URL = "https://github.com/login/oauth/authorize";
    public static String CALLBACK_URL = "openci://callback";
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton = findViewById(R.id.btn_login);
        Log.d("value:", getClientID());
        final String url = OAUTH_URL + "?client_id=" + getClientID() + "&scope=repo&redirect_uri=" + CALLBACK_URL;
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptLogin(url);
            }
        });
    }

    private void attemptLogin(String url){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(i);
    }
}