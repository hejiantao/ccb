package com.ccb.framework.app;

import android.app.Fragment;

import java.util.HashMap;
import java.util.List;

/**
 * Created by CCB on 2016/11/22.
 */

public class CcbFragment extends Fragment {
    private HashMap<String,Object>hashMap;
    private boolean isShowAssistant;
    private boolean isShowBackButton;
    private boolean isShowSearch;
    private Object pageTag;
    private String title;

    protected void closeLoading(){
        //TODO
        //CcbLoadingDialog.getInstance().dismissLoadingDialog();
    }

    protected void finish(Object paramObject){
        List localList=CcbActivityManager.getInstance().getAllActivities();
        if(localList.size()<2){
            getActivity().finish();
            return;
        }
        CcbActivity loaclCcbActivity= (CcbActivity) localList.get(localList.size()-2);
        if(loaclCcbActivity==null){
            getActivity().finish();
            return;
        }
        getActivity().finish();
        //TODO
        //loaclCcbActivity.onResult(paramObject);

    }

    public HashMap<String,Object>getHashMap(){
        return this.hashMap;
    }
    public Object getPageTag(){
        return this.pageTag;
    }
    public String getTitle(){
        return this.title;
    }
    protected void initTitleBar(String title,boolean isShowBackButton,boolean isShowSearch,boolean isShowAssistant){
        this.title=title;
        this.isShowBackButton=isShowBackButton;
        this.isShowSearch=isShowSearch;
        this.isShowAssistant=isShowAssistant;
    }
    public boolean isShowAssistant()
    {
        return this.isShowAssistant;
    }

    public boolean isShowBackButton()
    {
        return this.isShowBackButton;
    }

    public boolean isShowSearch()
    {
        return this.isShowSearch;
    }
    public boolean onBackPressFragment(){
        return false;
    }
    public void onResult(Object paramObject){

    }
    protected void resetTitleBar(HashMap<String, Object> paramHashMap, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt1, int paramInt2)
    {
        CcbActivity localCcbActivity = (CcbActivity)getActivity();
        if (localCcbActivity != null) {
            localCcbActivity.useCcbTitle(paramHashMap, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramInt1, paramInt2);
        }
    }

}
