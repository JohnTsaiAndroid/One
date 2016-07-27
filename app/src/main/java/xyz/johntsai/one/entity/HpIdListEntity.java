package xyz.johntsai.one.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by JohnTsai(mailto:johntsai.work@gmail.com) on 16/7/13.
 */
public class HpIdListEntity {
    /**
     * res : 0
     * data : ["1405","1400","1402","1399","1393","1397","1396","1395","1398","1394"]
     */

    @SerializedName("res")
    private int res;
    @SerializedName("data")
    private List<String> data;

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HpIdListEntity{" +
                "res=" + res +
                ", data=" + data +
                '}';
    }
}
