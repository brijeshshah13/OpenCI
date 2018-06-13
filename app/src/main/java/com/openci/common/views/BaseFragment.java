package com.openci.common.views;

import android.app.Fragment;
import android.view.View;
import android.widget.ProgressBar;

public class BaseFragment extends Fragment {

    public static void showProgressBar(ProgressBar progressBar) {
        if(progressBar != null && progressBar.getVisibility() != View.VISIBLE) {
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    public static void hideProgressBar(ProgressBar progressBar) {
        if(progressBar != null && progressBar.getVisibility() == View.VISIBLE) {
            progressBar.setVisibility(View.GONE);
        }
    }

}
