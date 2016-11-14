package com.ccb.common.log;

import android.util.Log;

/**
 * Created by CCB on 2016/11/14.
 */

public class MbsLogManager {
    public static final boolean CLOSE_VERIFY_CERTIFICATE=true;
    public static final boolean IS_CONN=true;
    public static final boolean IS_DEBUG=true;
    public static final boolean IS_RELEASE_VERSION=false;
    public static final boolean IS_SAFE_OPEN=false;
    public static final boolean IS_SET_QUESTION_OPEN=false;
    public static final boolean IsClientTypeTest=true;
    private static final int LOG_LENGTH=3000;
    public static final String TAG="CCB_NEW_CLIENT";
    public static final boolean enableMenuSim=false;
    public static final boolean isOpenMenuUpdate=true;

    public static void logD(String paramString){
        if (paramString.length()<LOG_LENGTH){
            Log.d(TAG,paramString);
            return;
        }
        Log.d(TAG,paramString.substring(0,LOG_LENGTH));
        logD(paramString.substring(LOG_LENGTH));
    }
    public static void logE(String paramString){
        if (paramString.length()<LOG_LENGTH){
           String str="error at"+java.lang.Thread.currentThread().getStackTrace()[2].getMethodName()
                   +"called by"+java.lang.Thread.currentThread().getStackTrace()[3].getClassName()
                   +"::"+java.lang.Thread.currentThread().getStackTrace()[3].getMethodName();
            Log.e(TAG,paramString);
            Log.e(TAG,str);
            return;
        }
        Log.e(TAG,paramString.substring(0,LOG_LENGTH));
        logE(paramString.substring(LOG_LENGTH));
    }

    public static void logI(String paramString){
        if (paramString.length()<LOG_LENGTH){
            Log.i(TAG,paramString);
            return;
        }
        Log.i(TAG,paramString.substring(0,LOG_LENGTH));
        logI(paramString.substring(LOG_LENGTH));
    }

    public static void logV(String paramString){
        if (paramString.length()<LOG_LENGTH){
            Log.v(TAG,paramString);
            return;
        }
        Log.v(TAG,paramString.substring(0,LOG_LENGTH));
        logV(paramString.substring(LOG_LENGTH));
    }
    public static void logW(String paramString){
        if (paramString.length()<LOG_LENGTH){
            Log.w(TAG,paramString);
            return;
        }
        Log.w(TAG,paramString.substring(0,LOG_LENGTH));
        logW(paramString.substring(LOG_LENGTH));
    }

    public static void printProcess(String paramString){
        String str= java.lang.Thread.currentThread().getStackTrace()[3].getClassName()
                   + "::" + java.lang.Thread.currentThread().getStackTrace()[3].getMethodName();
            if (paramString!=null){
                str=str+" "+paramString;
            }
         logI(str);
    }

}
