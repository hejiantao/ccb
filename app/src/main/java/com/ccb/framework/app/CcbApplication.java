package com.ccb.framework.app;

import android.app.Application;

/**
 * Created by CCB on 2016/11/11.
 */

public class CcbApplication  extends Application{
    private static CcbApplication instance;
    public CcbApplication getInstance(){
        if(instance==null){
            throw new RuntimeException("IlleagelStateExp : instance is null, application error");
        }
        return this.instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
    }

    public void quitApp(){

    }
}
