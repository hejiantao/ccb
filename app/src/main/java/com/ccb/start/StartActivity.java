package com.ccb.start;

import android.os.Bundle;

import com.ccb.common.param.LogUtil;
import com.ccb.framework.app.CcbActivity;
import com.ccb.mobilebank.R;

public class StartActivity extends CcbActivity{
    private String TAG=StartActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LogUtil.i(this.TAG,"onCreate(Bundle savedInstanceState)");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        setPageTag("startActivity");
    }
}
