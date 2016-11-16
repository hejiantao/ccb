package com.ccb.common.crypt;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

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
        byte []arrayOfByte=Base64.decode(paramString);
        IvParameterSpec localIvParamterSpec=new IvParameterSpec(iv);
        SecretKeySpec localSecrtKeySpec=new SecretKeySpec(KEY.getBytes(),"DES");
        Cipher localCipher=Cipher.getInstance("DES/CBC/PKCS5Padding");
        localCipher.init(Cipher.DECRYPT_MODE,localSecrtKeySpec,localIvParamterSpec);
        return new String(localCipher.doFinal(arrayOfByte));
    }
    public static String encrypt(String paramString)throws Exception{
        if(paramString==null||"".equals(paramString)){
            return "";
        }
        IvParameterSpec localIvParamterSpec=new IvParameterSpec(iv);
        SecretKeySpec localSecrtKeySpec=new SecretKeySpec(KEY.getBytes(),"DES");
        Cipher localCipher=Cipher.getInstance("DES/CBC/PKCS5Padding");
        localCipher.init(Cipher.ENCRYPT_MODE,localSecrtKeySpec,localIvParamterSpec);
        return Base64.encode(localCipher.doFinal(paramString.getBytes()));
    }
}
