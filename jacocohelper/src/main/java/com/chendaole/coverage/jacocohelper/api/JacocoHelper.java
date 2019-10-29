package com.chendaole.coverage.jacocohelper.api;


import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;

import com.chendaole.coverage.jacocohelper.control.broadcast.VolumeBroadcastReceiver;
import com.chendaole.coverage.jacocohelper.support.AlContext;

public class JacocoHelper {
    private static final String VOLUME_CHANGED_ACTION = "android.media.VOLUME_CHANGED_ACTION";
    private static boolean sIsInitialize = false;

    public static void initialize(Options options) {
        if (!sIsInitialize) {
            AlContext.Options op = new AlContext.Options(options.application);
            op.setDebuggable(options.debuggable);
            AlContext.init(op);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(VOLUME_CHANGED_ACTION);
                AlContext.getAppContext().registerReceiver(new VolumeBroadcastReceiver(), intentFilter);
            }
            sIsInitialize = true;
        }
    }

    private static class Options {
        private Context application;
        private boolean debuggable;
    }

    public static class Builder  {
        private Application application;
        private boolean debuggable;

        public Builder setApplication(Application application) {
            this.application = application;
            return this;
        }

        public Builder setDebuggable(boolean debuggable) {
            this.debuggable = debuggable;
            return this;
        }

        public Options build() {
            Options options = new Options();
            options.application = application;
            options.debuggable = debuggable;
            return options;
        }
    }
}
