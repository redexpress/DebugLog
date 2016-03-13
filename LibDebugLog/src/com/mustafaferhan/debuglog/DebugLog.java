/***
 * This is free and unencumbered software released into the public domain.
 * <p/>
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 * <p/>
 * For more information, please refer to <http://unlicense.org/>
 */

package com.mustafaferhan.debuglog;

import android.util.Log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;


/**
 * @date 21.06.2012
 * @author Mustafa Ferhan Akman
 *
 * Create a simple and more understandable Android logs. 
 * */

public class DebugLog {

    static String className;
    static String methodName;
    static int lineNumber;

    private DebugLog() {
    }

    public static boolean isDebuggable() {
        return false;
    }

    private static String createLog(String log) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("[");
        buffer.append(methodName);
        buffer.append(":");
        buffer.append(lineNumber);
        buffer.append("]");
        buffer.append(log);

        return buffer.toString();
    }

    private static void getMethodNames(StackTraceElement[] sElements) {
        className = sElements[1].getFileName();
        methodName = sElements[1].getMethodName();
        lineNumber = sElements[1].getLineNumber();
    }

    public static int v(String tag, String msg) {
        if (!isDebuggable())
            return 0;
        getMethodNames(new Throwable().getStackTrace());
        return Log.v(tag, createLog(msg));
    }

    public static int v(String tag, String msg, Throwable tr) {
        if (!isDebuggable())
            return 0;
        getMethodNames(new Throwable().getStackTrace());
        return Log.v(tag, createLog(msg), tr);
    }

    public static int d(String tag, String msg) {
        if (!isDebuggable())
            return 0;
        getMethodNames(new Throwable().getStackTrace());
        return Log.d(tag, createLog(msg));
    }

    public static int d(String tag, String msg, Throwable tr) {
        if (!isDebuggable())
            return 0;
        getMethodNames(new Throwable().getStackTrace());
        return Log.d(tag, createLog(msg));
    }

    public static int i(String tag, String msg) {
        if (!isDebuggable())
            return 0;
        getMethodNames(new Throwable().getStackTrace());
        return Log.i(tag, createLog(msg));
    }

    public static int i(String tag, String msg, Throwable tr) {
        if (!isDebuggable())
            return 0;
        getMethodNames(new Throwable().getStackTrace());
        return Log.i(tag, createLog(msg), tr);
    }

    public static int w(String tag, String msg) {
        if (!isDebuggable())
            return 0;
        getMethodNames(new Throwable().getStackTrace());
        return Log.w(tag, createLog(msg));
    }

    public static int w(String tag, String msg, Throwable tr) {
        if (!isDebuggable())
            return 0;
        getMethodNames(new Throwable().getStackTrace());
        return Log.w(tag, createLog(msg), tr);
    }

    public static int w(String tag, Throwable tr) {
        if (!isDebuggable())
            return 0;
        getMethodNames(new Throwable().getStackTrace());
        return Log.w(tag, createLog(tr.getMessage()), tr);
    }

    public static int e(String tag, String msg) {
        if (!isDebuggable())
            return 0;
        getMethodNames(new Throwable().getStackTrace());
        return Log.e(tag, createLog(msg));
    }

    public static int e(String tag, String msg, Throwable tr) {
        if (!isDebuggable())
            return 0;
        getMethodNames(new Throwable().getStackTrace());
        return Log.e(tag, createLog(msg), tr);
    }

    public static int e(String message) {
        if (!isDebuggable())
            return 0;

        // Throwable instance must be created before any methods
        getMethodNames(new Throwable().getStackTrace());
        return Log.e(className, createLog(message));
    }

    public static int e(Throwable tr) {
        if (!isDebuggable())
            return 0;
        getMethodNames(new Throwable().getStackTrace());
        return Log.e(className, createLog(tr.getMessage()), tr);
    }

    public static int i(String message) {
        if (!isDebuggable())
            return 0;

        getMethodNames(new Throwable().getStackTrace());
        return Log.i(className, createLog(message));
    }

    public static int d(String message) {
        if (!isDebuggable())
            return 0;

        getMethodNames(new Throwable().getStackTrace());
        return Log.d(className, createLog(message));
    }

    public static int v(String message) {
        if (!isDebuggable())
            return 0;

        getMethodNames(new Throwable().getStackTrace());
        return Log.v(className, createLog(message));
    }

    public static int w(String message) {
        if (!isDebuggable())
            return 0;

        getMethodNames(new Throwable().getStackTrace());
        return Log.w(className, createLog(message));
    }

    public static int w(Throwable tr) {
        if (!isDebuggable())
            return 0;
        getMethodNames(new Throwable().getStackTrace());
        return Log.w(className, createLog(tr.getMessage()), tr);
    }

    public static void wtf(String message) {
        if (!isDebuggable())
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.wtf(className, createLog(message));
    }

}
