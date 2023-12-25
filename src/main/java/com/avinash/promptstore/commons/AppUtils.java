package com.avinash.promptstore.commons;

import java.sql.Timestamp;

public class AppUtils {
    public static String getCurrentTime() {
        return new Timestamp(new java.util.Date().getTime()).toString();
    }
}
