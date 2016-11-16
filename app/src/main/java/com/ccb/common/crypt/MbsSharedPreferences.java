package com.ccb.common.crypt;

import android.content.Context;
import android.content.SharedPreferences;

import com.ccb.common.log.MbsLogManager;

import java.util.Map;

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
    public MbsEditor editor(){
        if(this.mySP==null){
            return null;
        }
        return new MbsEditor(this.mySP);
    }
    public Map<String,?> getAll(){
        if (this.mySP==null){
            return null;
        }
        return this.mySP.getAll();
    }
    public boolean getBoolean(String paramString, boolean paramBoolean)
    {
        if (this.mySP == null) {
            paramBoolean = false;
        }
        String str;
        do
        {
            str = this.mySP.getString(paramString, String.valueOf(paramBoolean));
            if (str == null) {
                return false;
            }
        } while (str.equals(Boolean.valueOf(paramBoolean)));
        try
        {
            boolean bool = Boolean.parseBoolean(DESSecretTool.decrypt(str));
            return bool;
        }
        catch (Exception localException)
        {
            MbsLogManager.logE(localException.toString());
        }
        return paramBoolean;
    }
}
