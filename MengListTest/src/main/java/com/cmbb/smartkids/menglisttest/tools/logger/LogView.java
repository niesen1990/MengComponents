package com.cmbb.smartkids.menglist.tools.logger;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

public class LogView extends TextView implements LogNode {

    public LogView(Context context) {
        super(context);
    }

    public LogView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LogView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void println(int priority, String tag, String msg, Throwable tr) {

        String priorityStr = null;

        switch (priority) {
            case Log.VERBOSE:
                priorityStr = "VERBOSE";
                break;
            case Log.DEBUG:
                priorityStr = "DEBUG";
                break;
            case Log.INFO:
                priorityStr = "INFO";
                break;
            case Log.WARN:
                priorityStr = "WARN";
                break;
            case Log.ERROR:
                priorityStr = "ERROR";
                break;
            case Log.ASSERT:
                priorityStr = "ASSERT";
                break;
            default:
                break;
        }

        String exceptionStr = null;
        if (tr != null) {
            exceptionStr = Log.getStackTraceString(tr);
        }

        final StringBuilder outputBuilder = new StringBuilder();

        String delimiter = "\t";
        appendIfNotNull(outputBuilder, priorityStr, delimiter);
        appendIfNotNull(outputBuilder, tag, delimiter);
        appendIfNotNull(outputBuilder, msg, delimiter);
        appendIfNotNull(outputBuilder, exceptionStr, delimiter);

        ((Activity) getContext()).runOnUiThread((new Thread(new Runnable() {
            @Override
            public void run() {
                appendToLog(outputBuilder.toString());
            }
        })));

        if (mNext != null) {
            mNext.println(priority, tag, msg, tr);
        }
    }

    public LogNode getNext() {
        return mNext;
    }

    public void setNext(LogNode node) {
        mNext = node;
    }

    private StringBuilder appendIfNotNull(StringBuilder source, String addStr, String delimiter) {
        if (addStr != null) {
            if (addStr.length() == 0) {
                delimiter = "";
            }

            return source.append(addStr).append(delimiter);
        }
        return source;
    }

    LogNode mNext;

    public void appendToLog(String s) {
        append("\n" + s);
    }

}
