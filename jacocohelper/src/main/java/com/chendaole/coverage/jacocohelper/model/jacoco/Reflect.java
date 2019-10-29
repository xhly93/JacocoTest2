package com.chendaole.coverage.jacocohelper.model.jacoco;

import android.os.Environment;

import com.chendaole.coverage.jacocohelper.support.AlContext;
import com.chendaole.coverage.jacocohelper.support.AlLog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Reflect {
    //ec文件的路径
    private static String DEFAULT_COVERAGE_DIR = Environment.getExternalStorageDirectory()
            .getPath();

    public static void generateEcFile(String filename, boolean isNew) {
        if (!AlContext.getDebuggable())return;
        OutputStream out = null;
        File mCoverageFilePath = new File(DEFAULT_COVERAGE_DIR + "/" + filename);
        try {
            if (isNew && mCoverageFilePath.exists()) {
                AlLog.d("JacocoHelper_generateEcFile: 清除旧的ec文件");
                mCoverageFilePath.delete();
            }
            if (!mCoverageFilePath.exists()) {
                mCoverageFilePath.createNewFile();
            }
            out = new FileOutputStream(mCoverageFilePath.getPath(), true);
            Object agent = Class.forName("org.jacoco.agent.rt.RT")
                    .getMethod("getAgent")
                    .invoke(null);
            out.write((byte[]) agent.getClass().getMethod("getExecutionData", boolean.class)
                    .invoke(agent, false));
        } catch (Exception e) {
            AlLog.d("JacocoHelper_generateEcFile: " + e.getMessage());
        } finally {
            if (out == null)
                return;
            try {
                out.close();
                AlLog.d("JacocoHelper_generateEcFile: "+mCoverageFilePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        AlLog.d("created ec file");
    }
}
