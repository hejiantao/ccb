package com.ccb.common.param;

import android.util.Log;

/**
 * Created by CCB on 2016/11/14.
 */

public class LogUtil {
    private static final int LOG_LENGTH=3000;
    private static boolean LogOn=CommonParam.LogOn;

    public static void d(String paramString1,String paramString2 ){
        if(!LogOn){
            return;
        }
        if(paramString2.length()<LOG_LENGTH){
            Log.d(paramString1,paramString2);
            return;
        }
        Log.d(paramString1,paramString2.substring(0,LOG_LENGTH));
        d(paramString1,paramString2.substring(LOG_LENGTH));

    }
    public static void e(String paramString1,String paramString2 ){
        if(!LogOn){
            return;
        }
        if(paramString2.length()<LOG_LENGTH){
            Log.e(paramString1,paramString2);
            return;
        }
        Log.e(paramString1,paramString2.substring(0,LOG_LENGTH));
        e(paramString1,paramString2.substring(LOG_LENGTH));

    }
    public static void i(String paramString1,String paramString2 ){
        if(!LogOn){
            return;
        }
        if(paramString2.length()<LOG_LENGTH){
            Log.i(paramString1,paramString2);
            return;
        }
        Log.i(paramString1,paramString2.substring(0,LOG_LENGTH));
        i(paramString1,paramString2.substring(LOG_LENGTH));

    }
    public static void v(String paramString1,String paramString2 ){
        if(!LogOn){
            return;
        }
        if(paramString2.length()<LOG_LENGTH){
            Log.v(paramString1,paramString2);
            return;
        }
        Log.v(paramString1,paramString2.substring(0,LOG_LENGTH));
        v(paramString1,paramString2.substring(LOG_LENGTH));

    }
    public static void w(String paramString1,String paramString2 ){
        if(!LogOn){
            return;
        }
        if(paramString2.length()<LOG_LENGTH){
            Log.w(paramString1,paramString2);
            return;
        }
        Log.w(paramString1,paramString2.substring(0,LOG_LENGTH));
        w(paramString1,paramString2.substring(LOG_LENGTH));

    }
}
