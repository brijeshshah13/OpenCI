package com.openci.core;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.view.MenuItem;

import com.openci.R;
import com.openci.ui.activities.LoginActivity;

import static android.content.Context.MODE_PRIVATE;

public class DrawerNavigator {

    private final Context context;
    private final FragmentNavigator fragmentNavigator;
    private AlertDialog logoutDialog;

    private static String PREFS_NAME = "SHARED_PREFS";
    public static boolean changeTitle = true;

    public DrawerNavigator(Context context, FragmentNavigator fragmentNavigator) {
        this.context = context;
        this.fragmentNavigator = fragmentNavigator;
    }

    public void selectItem(MenuItem menuItem) {
        int id = menuItem.getItemId();

        switch(id) {
            case R.id.nav_issue:
                break;
            case R.id.nav_faq:
                break;
            case R.id.nav_settings:
                break;
            case R.id.nav_about:
                break;
            case R.id.nav_logout:
                changeTitle = false;
                showLogoutDialog();
                break;
            default:
                fragmentNavigator.loadFragment(id);
        }
    }

    private void showLogoutDialog() {
        if (logoutDialog == null)
            logoutDialog = new AlertDialog.Builder(context)
                    .setTitle(R.string.logout_confirmation)
                    .setMessage(R.string.logout_confirmation_message)
                    .setPositiveButton(R.string.ok, (dialog, which) -> logout())
                    .setNegativeButton(R.string.cancel, (dialog, which) -> dialog.dismiss())
                    .create();

        logoutDialog.show();
    }

    private void logout() {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        editor.clear();
        editor.commit();
        Intent intentToLoginActivity = new Intent(context, LoginActivity.class);
        context.startActivity(intentToLoginActivity);
    }
}
