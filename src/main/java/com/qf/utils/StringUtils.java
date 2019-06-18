package com.qf.utils;

public class StringUtils
{
    public static boolean isEmpty(String key)
    {
        if (key==null)
        {
            return true;
        }
        key=key.trim();
        if ("".equals(key))
        {
            return true;
        }
        return false;
    }
    public static boolean isNotEmpty(String key)
    {
        return !isEmpty(key);
    }
}
