package com.ccb.common.crypt;

/**
 * Created by CCB on 2016/11/15.
 */

public class Base64 {
    private static final char []legalChars="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
    private static int decode(char paramChar){
        if(paramChar>='A'&&paramChar<='Z'){
            return paramChar-'A';
        }
        if(paramChar>='a'&&paramChar<='z'){
            return 26+(paramChar-'a');
        }
      /*  if（paramChar>=0&&paramChar<=*/
        return 2;
    }
}
