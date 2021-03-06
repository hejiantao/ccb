package com.ccb.framework.app;

import android.app.Activity;
import android.os.Bundle;

import com.ccb.common.log.MbsLogManager;
import com.ccb.framework.ui.widget.CcbButton;
import com.ccb.framework.ui.widget.CcbRelativeLayout;

/**
 * Created by CCB on 2016/11/11.
 */

public abstract class CcbActivity extends Activity {
    private final String TAG=CcbActivity.class.getSimpleName();
    /**
     * 标题栏
     * */
    private CcbRelativeLayout ccb_title;

    private CcbButton ccb_title_lefe_btn;
    /**
    * 主题颜色是否改变
     * */
    private boolean isSkinChanged=false;
    /**
     * 主题肤色
     * */
    private int skinColor;
    private Object pageTag;

    public void setPageTag(Object paramObject){
        this.pageTag=paramObject;
    }
    public Object getPageTag(){
        return this.pageTag;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MbsLogManager.logD(getClass().getSimpleName()+"onCreate()..");
        super.onCreate(savedInstanceState);
        CcbActivityManager.getInstance().addActivity(this);

    }
}
