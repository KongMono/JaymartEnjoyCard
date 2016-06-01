package com.jaymart.enjoycard.util;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;

public class Util extends FragmentActivity {

    public static boolean isTrueMoveOperator(Context context) {
        try {
            String simOperator = getSimOperator(context).toLowerCase();
            return simOperator.contains("true") || simOperator.contains("52000");
        } catch (Exception e) {
            return false;
        }
    }

    public static String isTrueOperator(Context ctx) {
        TelephonyManager TelephonyMgr = (TelephonyManager) ctx.getSystemService(Context.TELEPHONY_SERVICE);
        return TelephonyMgr.getNetworkOperatorName();
    }

    public static String getSimOperator(Context ctx) {
        TelephonyManager TelephonyMgr = (TelephonyManager) ctx.getSystemService(Context.TELEPHONY_SERVICE);

        String operator = TelephonyMgr.getSimOperatorName();
        if (String.valueOf(operator).equals("") || String.valueOf(operator).equalsIgnoreCase("null")) {
            operator = isTrueOperator(ctx);
        }

        if (String.valueOf(operator).equals("") || String.valueOf(operator).equalsIgnoreCase("null")) {
            operator = "unknow";
        }

        return operator;
    }

    public static float getsizescreen(Activity atx) {
        DisplayMetrics metrics = new DisplayMetrics();
        atx.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int widthPixels = metrics.widthPixels;
        int heightPixels = metrics.heightPixels;

        float scaleFactor = metrics.density;
        float widthDp = widthPixels / scaleFactor;
        float heightDp = heightPixels / scaleFactor;
        return Math.min(widthDp, heightDp);
    }

}
