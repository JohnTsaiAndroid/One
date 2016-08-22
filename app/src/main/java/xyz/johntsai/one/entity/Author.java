package xyz.johntsai.one.entity;

import java.io.Serializable;

/**
 * Created by JohnTsai(mailto:johntsai.work@gmail.com) on 16/8/16.
 *  作者/音乐人
 */
public class Author implements Serializable{
    private static final long serialVersionUID = -1696821278715398806L;

    /**
     * user_id : 5537277
     * user_name : Chicago
     * web_url : http://image.wufazhuce.com/FmKieEeHAiumc6mpu_DVFUQRj1p3
     * desc : 美国乐队
     */

    private String user_id;
    private String user_name;
    private String web_url;
    private String desc;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
