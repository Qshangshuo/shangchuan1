package com.qf.utils;

import java.util.HashMap;

public class R extends HashMap
{
    private int code;//状态 成功：0 失败1
    private String msg;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public R(int code)
    {
        super.put("code",code);
    }
    public  R(int code,String msg)
    {
        super.put("code",code);
        super.put("msg",msg);
    }
    public static R ok()
    {
        return new R(0);
    }
    public static R ok(String msg)
    {
        return new R(0,msg);
    }
    public static R error()
    {
        return new R(1);
    }
    public static R error(String msg)
    {
        return new R(1,msg);
    }
    public R put (String k,Object v)
    {
        super.put(k,v);
        return this;
    }






}
