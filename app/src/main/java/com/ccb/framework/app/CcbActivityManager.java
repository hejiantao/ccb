package com.ccb.framework.app;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CCB on 2016/11/11.
 */

public class CcbActivityManager {
    private String TAG=CcbActivityManager.class.getSimpleName();
    public static final String FRAGMENT_KEY = "fragment";
    private static CcbActivityManager instance=null;
    private List<CcbActivity>activities=new ArrayList<CcbActivity>();
    private List<WeakReference<CcbActivity>>activityCache=new ArrayList<WeakReference<CcbActivity>>();
    private List<CcbActivity>tempActivities=new ArrayList<CcbActivity>();

    public static CcbActivityManager getInstance() {
        if (instance==null){
            synchronized (CcbActivityManager.class){
                if (instance==null){
                    instance=new CcbActivityManager();
                }
            }
        }
        return instance;
    }

    private void backTo(int paramInt){
        if(this.activities==null){
            String str=this.TAG;
            Object []arrayOfObject=new Object[1];
            arrayOfObject[0]=Integer.valueOf(paramInt);
            return;
        }
    }

    public void addActivity(CcbActivity paramActivity){
        if(paramActivity==null){
            return;
        }
        synchronized (this.activityCache){
            activities.add(paramActivity);
        }

    }
    public void addTempActivity(CcbActivity paramActivity){
        if(paramActivity==null){
            return;
        }
        tempActivities.add(paramActivity);
    }

    public void removeActivity(CcbActivity paramActivity){
        if(activities==null||paramActivity==null){
            return;
        }
        activities.remove(paramActivity);

    }

    public void removeAllActivities(){
        synchronized (this.activities){
            while (!(activities.isEmpty())){
                CcbActivity localCcbActivity = (CcbActivity) activities.remove(0);
                if(localCcbActivity!=null&&!localCcbActivity.isFinishing()) {
                    localCcbActivity.finish();
                }
            }
        }
    }

    public void removeAllTempActivities(){
        synchronized (this.activities){
            while (!(tempActivities.isEmpty())){
                CcbActivity localCcbActivity=(CcbActivity) tempActivities.remove(0);
                if(localCcbActivity!=null&&!localCcbActivity.isFinishing()){
                    localCcbActivity.finish();
                }
            }
        }
        if(tempActivities.size()<=activities.size()){
            activities.removeAll(tempActivities);
        }
    }

    public List<CcbActivity>getAllActivities(){
        return this.activities;
    }
}
