package xyz.johntsai.one.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by JohnTsai(mailto:johntsai.work@gmail.com) on 16/7/13.
 */
public class BaseEntity {

    /**
     * res : 0
     * msg : success
     */

    @SerializedName("res")
    private int res;
    @SerializedName("msg")
    private String msg;

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "res=" + res +
                ", msg='" + msg + '\'' +
                '}';
    }
}
