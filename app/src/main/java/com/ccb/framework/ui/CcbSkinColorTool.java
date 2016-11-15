package com.ccb.framework.ui;

import android.graphics.Color;

/**
 * Created by CCB on 2016/11/14.
 */

public class CcbSkinColorTool {
    private static final int COLOR_NULL=0;
    public static final float DARK_OFFSET=0.611073F;
    private static final String GENERAL_SKIN_COLOR_KEY="general_skin_color";
    private static final String GENERAL_SKIN_COLOR_PROGRESS_KEY="general_skin_progress";
    private static final String GENERAL_SKIN_COLOR_SUB_PROGRESS_KEY="general_skin_sub_progress";
    public static final String GENERAL_SKIN_KEY="general_skin";
    public static final float LIGHT_OFFSET=0.372328F;
    private static CcbSkinColorTool instance=null;

    private int mSkinColor= Color.parseColor("#0066B3");
    private int mSubProgress=-1;
    private int mainProgress=-1;

    public CcbSkinColorTool getInstance(){
        if (instance==null){
            synchronized (CcbSkinColorTool.class){
                if(instance==null){
                    instance=new CcbSkinColorTool();
                }
            }
        }
        return instance;
    }

}
