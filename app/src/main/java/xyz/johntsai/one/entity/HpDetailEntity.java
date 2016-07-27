package xyz.johntsai.one.entity;

/**
 * Created by JohnTsai(mailto:johntsai.work@gmail.com) on 16/7/21.
 */
public class HpDetailEntity {
    /**
     * res : 0
     * data : {"hpcontent_id":"1405","hp_title":"VOL.1375","author_id":"-1","hp_img_url":"http://image.wufazhuce.com/FkzUgi2_LoJ-GTH5o0N0Vj5MNFYO","hp_img_original_url":"http://image.wufazhuce.com/FkzUgi2_LoJ-GTH5o0N0Vj5MNFYO","hp_author":"无题&棱小宇 作品","ipad_url":"http://image.wufazhuce.com/FvwUUbsVb8aCLauauGZvEsd40XwV","hp_content":"岁月为百代之过客，逝去之年亦为旅人也。于舟楫上过生涯，或执马鞭而终其一生之人，日日生活皆为旅行。 by 松尾芭蕉","hp_makettime":"2016-07-12 23:00:00","last_update_date":"2016-07-08 16:42:40","web_url":"http://m.wufazhuce.com/one/1405","wb_img_url":"","praisenum":24858,"sharenum":2708,"commentnum":412}
     */

    private int res;
    /**
     * hpcontent_id : 1405
     * hp_title : VOL.1375
     * author_id : -1
     * hp_img_url : http://image.wufazhuce.com/FkzUgi2_LoJ-GTH5o0N0Vj5MNFYO
     * hp_img_original_url : http://image.wufazhuce.com/FkzUgi2_LoJ-GTH5o0N0Vj5MNFYO
     * hp_author : 无题&棱小宇 作品
     * ipad_url : http://image.wufazhuce.com/FvwUUbsVb8aCLauauGZvEsd40XwV
     * hp_content : 岁月为百代之过客，逝去之年亦为旅人也。于舟楫上过生涯，或执马鞭而终其一生之人，日日生活皆为旅行。 by 松尾芭蕉
     * hp_makettime : 2016-07-12 23:00:00
     * last_update_date : 2016-07-08 16:42:40
     * web_url : http://m.wufazhuce.com/one/1405
     * wb_img_url :
     * praisenum : 24858
     * sharenum : 2708
     * commentnum : 412
     */

    private DataEntity data;

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public static class DataEntity {
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
    }

    @Override
    public String toString() {
        return "HpDetailEntity{" +
                "res=" + res +
                ", data=" + data +
                '}';
    }
}
