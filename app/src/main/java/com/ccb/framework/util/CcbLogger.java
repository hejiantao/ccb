package com.ccb.framework.util;

/**
 * Created by CCB on 2016/11/11.
 */

public class CcbLogger{
    private static final boolean IS_WRITE=false;
    private static final CcbLogger.Level LEVEL=CcbLogger.Level.DEBUG;
    private static final String LOG_FILE_NAME="ccb.log";
    private static final String LOG_TAG=CcbLogger.class.getSimpleName();
    private static final String LOG_TIP="Log failed";
    enum Level{
        DEBUG,RELEASE;
    }
}
