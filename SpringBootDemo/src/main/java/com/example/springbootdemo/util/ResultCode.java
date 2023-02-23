package com.example.springbootdemo.util;

public enum ResultCode {
    /**
     * 成功响应
     */
    Succeed(0),

    /**
     * 失败响应
     */
    Failure(-1);

    private final int code;

    private ResultCode(int code){
        this.code = code;
    }

    public int value(){
        return this.code;
    }


}
