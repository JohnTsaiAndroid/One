package xyz.johntsai.one.entity;

import java.io.Serializable;

/**
 * Created by JohnTsai(mailto:johntsai.work@gmail.com) on 16/8/15.
 */
public class BaseDataEntity <T> implements Serializable {
    private static final long serialVersionUID = 538218652309052934L;
    private int res;
    private T data;

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseDataEntity{" +
                "res=" + res +
                ", data=" + data +
                '}';
    }
}
