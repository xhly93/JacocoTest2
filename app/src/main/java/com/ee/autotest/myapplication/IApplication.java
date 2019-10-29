package com.ee.autotest.myapplication;

import android.app.Application;

//import com.chendaole.coverage.jacocohelper.api.JacocoHelper;

public class IApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        JacocoHelper.Builder builder = new JacocoHelper.Builder();
//
//        builder.setApplication(this).setDebuggable(true);
//
//        JacocoHelper.initialize(builder.build());
    }
}
