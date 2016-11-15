package com.ccb.common.crypt;

import android.content.SharedPreferences;

/**
 * Created by CCB on 2016/11/15.
 */

public class MbsEditor {
    SharedPreferences.Editor editor;
    SharedPreferences mySP;

    public MbsEditor(SharedPreferences paramSharedPreferences){
        this.mySP=paramSharedPreferences;
        this.editor=paramSharedPreferences.edit();
    }

    public SharedPreferences.Editor clear(){
        return editor.clear();
    }
    public boolean commit(){
        return  this.editor.commit();
    }
    public SharedPreferences.Editor putBoolean(String paramString,boolean paramBoolean){

    }
}
