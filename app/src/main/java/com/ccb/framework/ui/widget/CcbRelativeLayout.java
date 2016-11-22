package com.ccb.framework.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.ccb.framework.ui.CcbSkinColorTool;
import com.ccb.framework.ui.ICcbGeneralSkin;
import com.ccb.mobilebank.R;

/**
 * Created by CCB on 2016/11/17.
 */

public class CcbRelativeLayout extends RelativeLayout implements ICcbGeneralSkin {
    private boolean isGeneralSkin = false;
    public CcbRelativeLayout(Context context) {
        super(context);
        initAttrs(context,null);
    }

    public CcbRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context,attrs);
        onSkinChange();
    }

    public CcbRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context,attrs);
        onSkinChange();
    }


    private void initAttrs(Context paramContext,AttributeSet paramAttributeSet){
        if(paramAttributeSet==null){
            return;
        }
        TypedArray typedArray=paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.Ccb_Custom);
        this.isGeneralSkin=typedArray.getBoolean(R.styleable.Ccb_Custom_generalSkin,false);
        typedArray.recycle();
    }

    @Override
    public boolean isGeneralSkin() {
        return this.isGeneralSkin;
    }

    @Override
    public void onSkinChange() {
        if(isInEditMode()){
            return;
        }
        Drawable localDrawable= CcbSkinColorTool.getInstance().changeDrawableColor(getBackground());
        if(localDrawable!=null){
            setBackgroundDrawable(null);
            setBackgroundDrawable(localDrawable);
        }

    }
    public void setEnabled(boolean paramBoolean){
        if(this.isGeneralSkin){

        }
    }

    public void setGeneralSkin(boolean paramBoolean){
        this.isGeneralSkin=paramBoolean;
        if(this.isGeneralSkin){
            onSkinChange();
        }
    }
}
