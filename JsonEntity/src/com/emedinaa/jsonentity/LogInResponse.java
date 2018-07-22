package com.emedinaa.jsonentity;

/**
 * @author : Eduardo Medina
 * @see : https://developer.android.com/index.html
 * @since : 7/14/18
 */
public class LogInResponse extends BaseResponse {

    //private String msg;
    //private int status;
    private User data;

    /*public String getMsg() {
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
    }*/

    /*
        if(isSuccessful()){ }
     */

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }
}
