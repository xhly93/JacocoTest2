package com.ee.autotest.myapplication;

import android.util.Log;

public class TwoUtils {

    private static final String TAG = "TwoUtils";

    public static void do003() {
        Log.i(TAG, "do003: ");
    }

    public static void do002() {
        Log.i(TAG, "do002: ");
    }

    public static void do004() {
        Log.i(TAG, "do004: ");
        MainUtil.do004();
    }


    public static void do001() {
        Log.i(TAG, "do001: ");
    }
}
