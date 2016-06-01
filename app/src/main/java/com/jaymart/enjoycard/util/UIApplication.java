package com.jaymart.enjoycard.util;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import android.preference.PreferenceManager;




import java.util.Locale;

public class UIApplication extends Application {
    public static class Config {
        public static final boolean DEVELOPER_MODE = false;
    }


    @Override
    public void onCreate() {
        super.onCreate();

        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);

        Configuration config = getBaseContext().getResources().getConfiguration();

        String lang = settings.getString("language_preference", "");
        if (lang.equals("")) {
            SharedPreferences.Editor editor = settings.edit();
            editor.putString("language_preference", "Thai");
            editor.commit();

            config.locale = new Locale("th");
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        }
    }

}
