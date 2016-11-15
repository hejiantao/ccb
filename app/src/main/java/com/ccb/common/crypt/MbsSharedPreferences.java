package com.ccb.common.crypt;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by CCB on 2016/11/15.
 */

public class MbsSharedPreferences {
    protected SharedPreferences mySP;
    public MbsSharedPreferences(Context paramContext,String paramString,int paramInt){
        this.mySP=paramContext.getSharedPreferences(paramString,paramInt);
    }

    //是否存有该字段
    public boolean contains(String paramString){
        if(mySP==null){
            return false;
        }
        return this.mySP.contains(paramString);
    }
}
