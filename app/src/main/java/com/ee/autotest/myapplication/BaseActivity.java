package com.ee.autotest.myapplication;

import android.app.Activity;
import android.os.Environment;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;


public class BaseActivity extends AppCompatActivity {


    private static final String TAG = "BaseActivity";

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        generateCoverageFile();
        Log.i("baseactivity", "lifecycle---" + " onDestroy");

    }

    /**
     * 1.跳转 返回
     * 23 跳转 23返回
     * 生成executionData
     */
    public void generateCoverageFile() {
        //生成报告的所在SDcard目录
        String DEFAULT_COVERAGE_FILE_PATH = Environment.getExternalStorageDirectory() + "/";
        OutputStream out = null;

        try {
            out = new FileOutputStream(DEFAULT_COVERAGE_FILE_PATH + "/initmvp_coverage.ec", false); //在SDcard根目录下生产检测报告，文件名自定义
            Object agent = Class.forName("org.jacoco.agent.rt.RT").getMethod("getAgent").invoke(null);
            // 这里之下就统计不到了
            out.write((byte[]) agent.getClass().getMethod("getExecutionData", boolean.class).invoke(agent, false));

            Log.i(TAG, "MainActivity generateCoverageFile write success");
        } catch (Exception e) {
            Log.i(TAG, "MainActivity generateCoverageFile Exception:" + e.toString());

        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    Log.e(TAG, "generateCoverageFile: e = " + e.getMessage());
                }
            }
        }

    }

    public void reset() {

        File file = new File(Environment.getExternalStorageDirectory() + "/initmvp_coverage.ec");
        if (file.exists()) {
            file.delete();
        }

//        Class<?> RT = null;
//        try {
//            RT = Class.forName("org.jacoco.agent.rt.RT");
//            Method methodGetAgent = RT.getMethod("getAgent");
//            Object objAgent = methodGetAgent.invoke(null);
////Get Agent Class
//
//            Object agent = Class.forName("org.jacoco.agent.rt.RT").getMethod("getAgent").invoke(null);
//
////            Class classAgent = Class.forName("org.jacoco.agent.rt.internal_b0d6a23.Agent");
////reset
//            Method methodDump = agent.getClass().getMethod("reset");
//            methodDump.invoke(objAgent, null);
//        } catch (Exception e) {
//            Log.e(TAG, "reset: e = " + e.getMessage());
//        }

    }
}

