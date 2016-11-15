package com.ccb.common.crypt;

import android.util.Base64;

/**
 * Created by CCB on 2016/11/15.
 */

public class DESSecretTool {
    private static final String KEY="CCBKEYWD";
    private static byte[]iv={1,2,3,4,5,6,7,8};
    public static String decrypt(String paramString)throws Exception{
        if(paramString==null||"".equals(paramString)){
            return "";
        }
        byte []arrayOfByte= Base64.decode(paramString);

        return "";

    }
}
