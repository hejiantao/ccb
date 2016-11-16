package com.ccb.framework.ui;
import android.graphics.Color;

public class CcbGeneralIconSuffix
{
    private int color;
    private String path;
    private String suffix;

    static
    {
        COLORFUL = new CcbGeneralIconSuffix("COLORFUL", 2, 0, "", "_colorful");
        CcbGeneralIconSuffix[] arrayOfCcbGeneralIconSuffix = new CcbGeneralIconSuffix[3];
        arrayOfCcbGeneralIconSuffix[0] = BLUE;
        arrayOfCcbGeneralIconSuffix[1] = LIGHT_BLUE;
        arrayOfCcbGeneralIconSuffix[2] = COLORFUL;
        $VALUES = arrayOfCcbGeneralIconSuffix;
    }

    private CcbGeneralIconSuffix(int paramInt, String paramString1, String paramString2)
    {
        this.color = paramInt;
        this.path = paramString1;
        this.suffix = paramString2;
    }

    public static CcbGeneralIconSuffix getCurrentSuffix()
    {
        return getDrawableSuffix(CcbSkinColorTool.getInstance().getSkinColor());
    }

    public static CcbGeneralIconSuffix getDrawableSuffix(int paramInt)
    {
        Object localObject = COLORFUL;
        CcbGeneralIconSuffix[] arrayOfCcbGeneralIconSuffix = values();
        int i = arrayOfCcbGeneralIconSuffix.length;
        int j = 0;
        while (j < i)
        {
            CcbGeneralIconSuffix localCcbGeneralIconSuffix = arrayOfCcbGeneralIconSuffix[j];
            if (paramInt != localCcbGeneralIconSuffix.getColor()) {
                j++;
            } else {
                localObject = localCcbGeneralIconSuffix;
            }
        }
        return localObject;
    }

    public int getColor()
    {
        return this.color;
    }

    public String getPath()
    {
        return this.path;
    }

    public String getSuffix()
    {
        return this.suffix;
    }
}