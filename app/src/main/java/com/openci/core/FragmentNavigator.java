package com.openci.core;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.openci.R;
import com.openci.ui.fragments.RepositoriesFragment;

public class FragmentNavigator {

    private final FragmentManager fragmentManager;

    public FragmentNavigator(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void loadFragment(int navItemId) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment;
        switch (navItemId) {
            case R.id.nav_repos:
                fragment = RepositoriesFragment.newInstance();
                break;
            case R.id.nav_home:
            default:
                fragment = RepositoriesFragment.newInstance();
        }

        // Insert the fragment by replacing any existing fragment
        fragmentManager.beginTransaction().add(R.id.fl_content, fragment).commit();
    }
}
