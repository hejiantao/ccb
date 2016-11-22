package com.ccb.framework.ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;

import com.ccb.common.log.MbsLogManager;
import com.ccb.framework.ui.CcbSkinColorTool;
import com.ccb.framework.ui.ICcbGeneralSkin;
import com.ccb.framework.view.CcbOnClickListener;
import com.ccb.mobilebank.R;

import java.lang.reflect.Field;

/**
 * Created by CCB on 2016/11/17.
 */


public class CcbButton extends AppCompatButton implements ICcbGeneralSkin
{
    /**
     * 是不是一般的主题肤色
     * */
    private boolean isGeneralSkin = false;
    private View.OnClickListener mOnClickListener;

    public CcbButton(Context paramContext)
    {
        this(paramContext, null);
    }

    public CcbButton(Context paramContext, AttributeSet paramAttributeSet)
    {
        this(paramContext, paramAttributeSet, R.attr.borderlessButtonStyle);
    }

    public CcbButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
        super(paramContext, paramAttributeSet, paramInt);
        initAttrs(paramContext, paramAttributeSet);
        onSkinChange();
    }
    private void initAttrs(Context paramContext, AttributeSet paramAttributeSet)
    {
        setGravity(Gravity.CENTER);
        if (paramAttributeSet == null) {
            return;
        }
        TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.Ccb_Custom);
        this.isGeneralSkin = localTypedArray.getBoolean(R.styleable.Ccb_Custom_generalSkin, false);
        localTypedArray.recycle();
    }
    private void clearSkinChange()
    {
        setSupportBackgroundTintToNull();
    }

    private void setSupportBackgroundTintToNull()
    {
        try
        {
            Field localField = AppCompatButton.class.getDeclaredField("mBackgroundTint");
            localField.setAccessible(true);
            localField.set(this, null);
            return;
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
            MbsLogManager.logE(localNoSuchFieldException.getMessage());
            return;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
            MbsLogManager.logE(localIllegalAccessException.getMessage());
        }
    }

    private CcbOnClickListener getDefaultCcbOnClickListener(long paramLong)
    {
        if (-1L == paramLong) {
            new CcbOnClickListener()
            {
                public void ccbOnClick(View paramAnonymousView)
                {
                    if (CcbButton.this.mOnClickListener == null) {
                        return;
                    }
                    CcbButton.this.mOnClickListener.onClick(paramAnonymousView);
                }
            };
        }
        new CcbOnClickListener(paramLong)
        {
            public void ccbOnClick(View paramAnonymousView)
            {
                if (CcbButton.this.mOnClickListener == null) {
                    return;
                }
                CcbButton.this.mOnClickListener.onClick(paramAnonymousView);
            }
        };
    }





    public boolean isGeneralSkin()
    {
        return this.isGeneralSkin;
    }

    public void onSkinChange()
    {
        if (isInEditMode()) {}
        while (!this.isGeneralSkin) {
            return;
        }
        ColorStateList localColorStateList = CcbSkinColorTool.getInstance().getDefaultColorStateList();
        setSupportBackgroundTintList(localColorStateList);
        setTextColor(localColorStateList);
    }

    public void setGeneralSkin(boolean paramBoolean)
    {
        if (this.isGeneralSkin == paramBoolean) {}
        do
        {
            return;
            if ((this.isGeneralSkin) && (!paramBoolean))
            {
                clearSkinChange();
                this.isGeneralSkin = paramBoolean;
                return;
            }
            this.isGeneralSkin = paramBoolean;
        } while (!this.isGeneralSkin);
        onSkinChange();
    }

    public void setOnClickListener(View.OnClickListener paramOnClickListener)
    {
        setOnClickListener(paramOnClickListener, -1L);
    }

    public void setOnClickListener(View.OnClickListener paramOnClickListener, long paramLong)
    {
        if ((paramOnClickListener instanceof CcbOnClickListener))
        {
            super.setOnClickListener(paramOnClickListener);
            return;
        }
        this.mOnClickListener = paramOnClickListener;
        super.setOnClickListener(getDefaultCcbOnClickListener(paramLong));
    }

    public void setTextColor(int paramInt)
    {
        if (!isGeneralSkin())
        {
            super.setTextColor(paramInt);
            return;
        }
        super.setTextColor(CcbSkinColorTool.getInstance().getDefaultColorStateList());
    }

    public void setTextColor(ColorStateList paramColorStateList)
    {
        if (!isGeneralSkin()) {
            super.setTextColor(paramColorStateList);
        }
        while (isInEditMode()) {
            return;
        }
        super.setTextColor(CcbSkinColorTool.getInstance().getDefaultColorStateList());
    }
}

