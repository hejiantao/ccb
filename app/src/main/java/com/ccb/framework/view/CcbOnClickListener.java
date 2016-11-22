package com.ccb.framework.view;

import android.view.View;

/**
 * Created by CCB on 2016/11/17.
 */

public abstract class CcbOnClickListener implements View.OnClickListener {
    public long MIN_CLICK_DELAY_TIME = 800L;
    private long lastClickTime = 0L;
    public CcbOnClickListener(){

    }
    public CcbOnClickListener(long paramLong){
        this.MIN_CLICK_DELAY_TIME=paramLong;
    }
    public abstract void ccbOnClick(View paramView);
    @Override
    public void onClick(View paramView) {
        long l=System.currentTimeMillis();
        if(l-this.lastClickTime>this.MIN_CLICK_DELAY_TIME){
            this.lastClickTime=l;
            ccbOnClick(paramView);
        }
    }
}
