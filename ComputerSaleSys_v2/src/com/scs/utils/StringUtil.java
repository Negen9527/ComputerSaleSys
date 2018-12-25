package com.scs.utils;

public class StringUtil {
	 
    public static  Boolean isEmpty(Object type){
        if(type != null && !"".equals(type)){
            return false;
        }
        return true;
    }
}