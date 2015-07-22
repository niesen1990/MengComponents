package com.cmbb.smartkids.menglist.tools.logger;

public interface LogNode {

    public void println(int priority, String tag, String msg, Throwable tr);

}
