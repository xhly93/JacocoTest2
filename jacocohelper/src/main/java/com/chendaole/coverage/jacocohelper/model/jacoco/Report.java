package com.chendaole.coverage.jacocohelper.model.jacoco;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Report {
    public static void generate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        Date date = new Date(System.currentTimeMillis());
        Reflect.generateEcFile("jacoco_" + simpleDateFormat.format(date) + ".ec", true);
    }
}
