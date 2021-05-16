package com.go.demo.common.enums;

import com.go.demo.common.response.BasicResult;

/**
 * 系统编码
 */
public enum SystemCodeEnums {
    success("0","success"),
    fail("9","fail");

    private String code;
    private String msg;

    SystemCodeEnums(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public void applyVal(BasicResult result){
        result.setCode(this.getCode());
        result.setMsg(this.getMsg());
    }

    public BasicResult applyVal(String msg){
        BasicResult result = new BasicResult();
        result.setCode(this.getCode());
        result.setMsg(msg);
        return result;
    }

    public BasicResult applyVal(){
        BasicResult result = new BasicResult();
        result.setCode(this.getCode());
        result.setMsg(this.getMsg());
        return result;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
