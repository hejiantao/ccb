package com.ccb.home;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;

import com.ccb.framework.app.CcbActivity;
import com.ccb.mobilebank.R;

public class HomeActivity extends CcbActivity {
    public static final String BACK_HOME_TAG_CURRENTINDEX="tag_current_index";
    private static final int TAB_COLOR_GRAY= Color.parseColor("#a2a1a6");
    private static final int TAB_COLOR_ORG=Color.parseColor("#09b6f2");
    private static final int TAB_COLOR_WHITE=-1;
    private int currentIndex;
    Fragment f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}
