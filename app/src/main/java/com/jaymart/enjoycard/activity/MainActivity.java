package com.jaymart.enjoycard.activity;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.badoo.mobile.util.WeakHandler;
import com.jaymart.enjoycard.R;
import com.jaymart.enjoycard.fragment.HomeFragment;

import java.util.Locale;

import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

/**
 * Created by kongmono on 6/30/15.
 */
public class MainActivity extends MaterialNavigationDrawer {
    private WeakHandler mHandler = new WeakHandler();
    boolean doubleBackToExitPressedOnce;

    @Override
    public void init(Bundle bundle) {

        setLanguage();

        setDrawerHeaderImage(R.drawable.header_menu);

        allowArrowAnimation();
        enableToolbarElevation();
        // create sections
        addSection(newSectionWithRealColor(getResources().getString(R.string.sb1), R.drawable.menu_ico_home, new HomeFragment()));
        addSection(newSectionWithRealColor(getResources().getString(R.string.sb2), R.drawable.menu_ico_home, new HomeFragment()));
        addSection(newSectionWithRealColor(getResources().getString(R.string.sb3), R.drawable.menu_ico_home, new HomeFragment()));
        addSection(newSectionWithRealColor(getResources().getString(R.string.sb4), R.drawable.menu_ico_home, new HomeFragment()));
        addSection(newSectionWithRealColor(getResources().getString(R.string.sb5), R.drawable.menu_ico_home, new HomeFragment()));
        addSection(newSectionWithRealColor(getResources().getString(R.string.sb6), R.drawable.menu_ico_home, new HomeFragment()));
//        addDivisor();


        // add pattern
        setBackPattern(MaterialNavigationDrawer.BACKPATTERN_BACK_TO_FIRST);
        disableLearningPattern();
        setDefaultSectionLoaded(0);
    }


    private void setLanguage() {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        String lang = settings.getString("language_preference", "");
        Configuration config = getBaseContext().getResources().getConfiguration();
        if (lang.equals("Thai")) {
            config.locale = new Locale("th");
            Locale.setDefault(config.locale);
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

        } else {
            config.locale = new Locale("en");
            Locale.setDefault(config.locale);
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        }
    }

    @Override
    public void onBackPressed() {
        if (!isCurrentFragmentChild && getCurrentSection() == getSectionList().get(0)) {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

            mHandler.postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        } else {
            super.onBackPressed();
        }
    }
}
