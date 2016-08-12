package xyz.johntsai.one.entity;

import java.util.List;

/**
 * Created by JohnTsai(mailto:johntsai.work@gmail.com) on 16/8/11.
 */
public class HpDetailListEntity {
    /**
     * res : 0
     * data : [{"hpcontent_id":"1431","hp_title":"VOL.1403","author_id":"-1","hp_img_url":"http://image.wufazhuce.com/FlFBCbJOc1sASBec9Yp_zd5QLA33","hp_img_original_url":"http://image.wufazhuce.com/FlFBCbJOc1sASBec9Yp_zd5QLA33","hp_author":"Silence&Shelia Liu 作品","ipad_url":"http://image.wufazhuce.com/FuFZl8PSmDJcJA0GistiIRPZzVRL","hp_content":"我最擅长的事情，大概是独居。电话一天不响，周末无人邀约。孤单，是一个伙伴。这个伙伴，让我从不孤单。by 凉炘","hp_makettime":"2016-08-09 21:00:00","last_update_date":"2016-08-05 13:13:29","web_url":"http://m.wufazhuce.com/one/1431","wb_img_url":"","praisenum":30956,"sharenum":3247,"commentnum":166},{"hpcontent_id":"1425","hp_title":"VOL.1398","author_id":"-1","hp_img_url":"http://image.wufazhuce.com/Fhs6xN9OLpESTj8GgcIAPMBp7ITU","hp_img_original_url":"http://image.wufazhuce.com/Fhs6xN9OLpESTj8GgcIAPMBp7ITU","hp_author":"追逐&Dola Sun 作品","ipad_url":"http://image.wufazhuce.com/FuPRoi3g_xWgbx4TVK6Kl2Tyir9y","hp_content":"生命这么浅，我们涉水而过，湿了脚踝，丢了鞋子，到了对岸，如此而已。 by 七堇年","hp_makettime":"2016-08-04 21:00:00","last_update_date":"2016-07-29 13:38:03","web_url":"http://m.wufazhuce.com/one/1425","wb_img_url":"","praisenum":31986,"sharenum":3899,"commentnum":854}]
     */

    private int res;
    /**
     * hpcontent_id : 1431
     * hp_title : VOL.1403
     * author_id : -1
     * hp_img_url : http://image.wufazhuce.com/FlFBCbJOc1sASBec9Yp_zd5QLA33
     * hp_img_original_url : http://image.wufazhuce.com/FlFBCbJOc1sASBec9Yp_zd5QLA33
     * hp_author : Silence&Shelia Liu 作品
     * ipad_url : http://image.wufazhuce.com/FuFZl8PSmDJcJA0GistiIRPZzVRL
     * hp_content : 我最擅长的事情，大概是独居。电话一天不响，周末无人邀约。孤单，是一个伙伴。这个伙伴，让我从不孤单。by 凉炘
     * hp_makettime : 2016-08-09 21:00:00
     * last_update_date : 2016-08-05 13:13:29
     * web_url : http://m.wufazhuce.com/one/1431
     * wb_img_url :
     * praisenum : 30956
     * sharenum : 3247
     * commentnum : 166
     */

    private List<DataEntity> data;

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public static class DataEntity {
        private String hpcontent_id;
        private String hp_title;
        private String author_id;
        private String hp_img_url;
        private String hp_img_original_url;
        private String hp_author;
        private String ipad_url;
        private String hp_content;
        private String hp_makettime;
        private String last_update_date;
        private String web_url;
        private String wb_img_url;
        private int praisenum;
        private int sharenum;
        private int commentnum;

        public String getHpcontent_id() {
            return hpcontent_id;
        }

        public void setHpcontent_id(String hpcontent_id) {
            this.hpcontent_id = hpcontent_id;
        }

        public String getHp_title() {
            return hp_title;
        }

        public void setHp_title(String hp_title) {
            this.hp_title = hp_title;
        }

        public String getAuthor_id() {
            return author_id;
        }

        public void setAuthor_id(String author_id) {
            this.author_id = author_id;
        }

        public String getHp_img_url() {
            return hp_img_url;
        }

        public void setHp_img_url(String hp_img_url) {
            this.hp_img_url = hp_img_url;
        }

        public String getHp_img_original_url() {
            return hp_img_original_url;
        }

        public void setHp_img_original_url(String hp_img_original_url) {
            this.hp_img_original_url = hp_img_original_url;
        }

        public String getHp_author() {
            return hp_author;
        }

        public void setHp_author(String hp_author) {
            this.hp_author = hp_author;
        }

        public String getIpad_url() {
            return ipad_url;
        }

        public void setIpad_url(String ipad_url) {
            this.ipad_url = ipad_url;
        }

        public String getHp_content() {
            return hp_content;
        }

        public void setHp_content(String hp_content) {
            this.hp_content = hp_content;
        }

        public String getHp_makettime() {
            return hp_makettime;
        }

        public void setHp_makettime(String hp_makettime) {
            this.hp_makettime = hp_makettime;
        }

        public String getLast_update_date() {
            return last_update_date;
        }

        public void setLast_update_date(String last_update_date) {
            this.last_update_date = last_update_date;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }

        public String getWb_img_url() {
            return wb_img_url;
        }

        public void setWb_img_url(String wb_img_url) {
            this.wb_img_url = wb_img_url;
        }

        public int getPraisenum() {
            return praisenum;
        }

        public void setPraisenum(int praisenum) {
            this.praisenum = praisenum;
        }

        public int getSharenum() {
            return sharenum;
        }

        public void setSharenum(int sharenum) {
            this.sharenum = sharenum;
        }

        public int getCommentnum() {
            return commentnum;
        }

        public void setCommentnum(int commentnum) {
            this.commentnum = commentnum;
        }

        @Override
        public String toString() {
            return "DataEntity{" +
                    "hpcontent_id='" + hpcontent_id + '\'' +
                    ", hp_title='" + hp_title + '\'' +
                    ", author_id='" + author_id + '\'' +
                    ", hp_img_url='" + hp_img_url + '\'' +
                    ", hp_img_original_url='" + hp_img_original_url + '\'' +
                    ", hp_author='" + hp_author + '\'' +
                    ", ipad_url='" + ipad_url + '\'' +
                    ", hp_content='" + hp_content + '\'' +
                    ", hp_makettime='" + hp_makettime + '\'' +
                    ", last_update_date='" + last_update_date + '\'' +
                    ", web_url='" + web_url + '\'' +
                    ", wb_img_url='" + wb_img_url + '\'' +
                    ", praisenum=" + praisenum +
                    ", sharenum=" + sharenum +
                    ", commentnum=" + commentnum +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "HpDetailListEntity{" +
                "res=" + res +
                ", data=" + data +
                '}';
    }
}
