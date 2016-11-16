package com.ccb.framework.ui;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.View;
import android.view.ViewGroup;

import com.ccb.common.crypt.MbsSharedPreferences;
import com.ccb.common.log.MbsLogManager;
import com.ccb.framework.app.CcbApplication;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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
    private static MbsSharedPreferences sp;
    private List<ICcbGeneralSkin>iCcbSkins= Collections.synchronizedList(new LinkedList<ICcbGeneralSkin>());

    private int mSkinColor= Color.parseColor("#0066B3");
    private int mSubProgress=-1;
    private int mainProgress=-1;

    private void findSkinView(View paramView){
        if(paramView instanceof ICcbGeneralSkin ){
            this.iCcbSkins.add((ICcbGeneralSkin) paramView);
        }
        if(paramView instanceof ViewGroup){
            ViewGroup localViewGroup= (ViewGroup) paramView;
            int i=0;
            int j=localViewGroup.getChildCount();
            while (i<j){
                findSkinView(localViewGroup.getChildAt(i));
                i++;
            }
        }
    }

    public static CcbSkinColorTool getInstance(){
        if (instance==null){
            synchronized (CcbSkinColorTool.class){
                if(instance==null){
                    instance=new CcbSkinColorTool();
                    sp=new MbsSharedPreferences(CcbApplication.getInstance(),GENERAL_SKIN_KEY,COLOR_NULL);
                }

            }
        }
        return instance;
    }
    private void setMainProgress(int paramInt){
        this.mainProgress=paramInt;
    }
    private void setSubProgress(int ParamInt){
        this.mSubProgress=ParamInt;
    }
    public Drawable changeDrawableColor(Drawable paramDrawable){
        return changeDrawableColor(paramDrawable,0);
    }
//Todo
    public Drawable changeDrawableColor(Drawable paramDrawable, int paramInt) {
        if(paramDrawable==null){
            return null;
        }
        if(paramInt==0){
        }
        for(int i = this.mSkinColor; Build.VERSION.SDK_INT>21;i=paramInt){
            DrawableCompat.setTint(paramDrawable,i);
        }
        Drawable localDrawable;
        if ((paramDrawable instanceof ColorDrawable))
        {
            localDrawable = paramDrawable.mutate();
            ((ColorDrawable)localDrawable).setColor(paramInt);
        }
        for (;;)
        {
            localDrawable = DrawableCompat.wrap(paramDrawable);
            DrawableCompat.setTint(localDrawable, paramInt);
            return localDrawable;
        }

    }
    public void changeSkin(Activity paramActivity){
        changeSkin(paramActivity.getWindow().getDecorView());
    }
    public  void changeSkin(View paramView){
        this.iCcbSkins.clear();
        findSkinView(paramView);
        Iterator localIterator=this.iCcbSkins.iterator();
        while (localIterator.hasNext()){
            ((ICcbGeneralSkin)localIterator.next()).onSkinChange();
        }

    }
    public int getBackgroundResourceId(View paramView){
        try{
            Field localField=View.class.getField("mBackgroundResource");
            localField.setAccessible(true);
            int i =((Integer) localField.get(paramView)).intValue();
            return i;
        }catch (Exception e){
            MbsLogManager.logE(e.toString());
        }
        return 0;

    }
    //// TODO: 2016/11/16
    public ColorStateList getCustomSelectorColor(int paramInt1,int paramInt2){
        return new ColorStateList();
    }

}
