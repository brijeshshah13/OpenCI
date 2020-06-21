package com.openci.common

object Constants {
    // URLs
    const val PUBLIC_BASE_URL = "https://api.travis-ci.org/"
    const val PRIVATE_BASE_URL = "https://api.travis-ci.com/"
    const val GITHUB_BASE_URL = "https://github.com/"


    // Github Auth
    const val OAUTH_URL = "https://github.com/login/oauth/authorize"
    const val CALLBACK_URL = "openci://callback";


    // SharedPreferences
    const val PREFS_NAME = "SHARED_PREFS";

    const val CALLBACK_CODE = "callback_code"
    const val GITHUB_ACCESS_TOKEN = "github_access_token"
    const val PUBLIC_TRAVIS_ACCESS_TOKEN = "public_travis_access_token"
    const val PRIVATE_TRAVIS_ACCESS_TOKEN = "private_travis_access_token"
}