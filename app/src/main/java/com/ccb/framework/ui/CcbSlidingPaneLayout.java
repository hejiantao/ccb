package com.ccb.framework.ui;

import android.content.Context;
import android.support.v4.widget.SlidingPaneLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/**
 * Created by CCB on 2016/11/14.
 */

public class CcbSlidingPaneLayout extends SlidingPaneLayout {
    private boolean mCanSlide=false;
    private float mEdgeSlop;
    private float mInitialMotionX;
    private float getmInitialMotionY;
    public CcbSlidingPaneLayout(Context paramContext) {
        super(paramContext,null);
    }

    public CcbSlidingPaneLayout(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet,0);
    }

    public CcbSlidingPaneLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        this.mEdgeSlop= ViewConfiguration.get(paramContext).getScaledEdgeSlop();
    }
    public boolean isSlideable(){
        return this.mCanSlide;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
        //TODO
     /*   switch (MotionEventCompat.getActionMasked(paramMotionEvent)){

        }*/
        return super.onInterceptTouchEvent(paramMotionEvent);
    }

    public void setCanSlide(boolean paramBoolean){
        this.mCanSlide=paramBoolean;
    }
}
