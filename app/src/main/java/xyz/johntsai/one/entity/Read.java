package xyz.johntsai.one.entity;

import java.io.Serializable;

/**
 * Created by JohnTsai(mailto:johntsai.work@gmail.com) on 16/8/15.
 * 阅读
 */
public class Read implements Serializable {
    private static final long serialVersionUID = 518878702603191026L;
    private String id;
    private String title;
    private String type;
    private int number;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    @Override
    public String toString() {
        return "ReadData{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", number=" + number +
                '}';
    }
}
