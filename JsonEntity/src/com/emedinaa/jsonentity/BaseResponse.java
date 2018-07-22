package com.emedinaa.jsonentity;

/**
 * @author : Eduardo Medina
 * @see : https://developer.android.com/index.html
 * @since : 7/14/18
 */
public class BaseResponse {

    protected String msg;
    protected int status;


    protected boolean isSuccessful(){
        return (status==200)?true:false;
    }
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
