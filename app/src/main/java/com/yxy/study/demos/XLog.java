package com.yxy.study.demos;

import android.text.TextUtils;
import android.util.Log;

public final class XLog {

    public static String customTagPrefix = "X_log";
    private static boolean isDebug = true;

    private XLog() {
    }

    public static void isDebug(boolean b) {
        isDebug = b;
    }

    private static String generateTag() {
        StackTraceElement caller = new Throwable().getStackTrace()[2];
        String tag = "%s.%s(L:%d)";
        String callerClazzName = caller.getClassName();
        callerClazzName = callerClazzName.substring(callerClazzName.lastIndexOf(".") + 1);
        tag = String.format(tag, callerClazzName, caller.getMethodName(), caller.getLineNumber());
        tag = TextUtils.isEmpty(customTagPrefix) ? tag : customTagPrefix + ":" + tag;
        return tag;
    }

    public static void d(String content) {
        if (!isDebug) return;
        Log.d(generateTag(), content);
    }

    public static void d(String content, Throwable tr) {
        if (!isDebug) return;
        Log.d(generateTag(), content, tr);
    }

    public static void e(String content) {
        if (!isDebug) return;
        Log.e(generateTag(), content);
    }

    public static void e(String content, Throwable tr) {
        if (!isDebug) return;
        Log.e(generateTag(), content, tr);
    }

    public static void i(String content) {
        if (!isDebug) return;
        Log.i(generateTag(), content);
    }

    public static void i(String content, Throwable tr) {
        if (!isDebug) return;
        Log.i(generateTag(), content, tr);
    }

    public static void v(String content) {
        if (!isDebug) return;
        Log.v(generateTag(), content);
    }

    public static void v(String content, Throwable tr) {
        if (!isDebug) return;
        Log.v(generateTag(), content, tr);
    }

    public static void w(String content) {
        if (!isDebug) return;
        Log.w(generateTag(), content);
    }

    public static void w(String content, Throwable tr) {
        if (!isDebug) return;
        Log.w(generateTag(), content, tr);
    }

    public static void w(Throwable tr) {
        if (!isDebug) return;
        Log.w(generateTag(), tr);
    }

    public static void wtf(String content) {
        if (!isDebug) return;
        Log.wtf(generateTag(), content);
    }

    public static void wtf(String content, Throwable tr) {
        if (!isDebug) return;
        Log.wtf(generateTag(), content, tr);
    }

    public static void wtf(Throwable tr) {
        if (!isDebug) return;
        Log.wtf(generateTag(), tr);
    }

}