package xyz.johntsai.one.entity;

import java.io.Serializable;

/**
 * Created by JohnTsai(mailto:johntsai.work@gmail.com) on 16/8/15.
 * 音乐
 */
public class Music implements Serializable{
    private static final long serialVersionUID = -8607691078790619728L;
        private String id;
        private String title;
        private String cover;
        private String platform;
        private String music_id;
        /**
         * user_id : 7116173
         * user_name : Eminem
         * web_url : http://image.wufazhuce.com/FsyYD8A4gOBzLfDNJGs6KknN7Y8h
         * desc : 美国说唱歌手
         */

        private AuthorEntity author;

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

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public String getMusic_id() {
            return music_id;
        }

        public void setMusic_id(String music_id) {
            this.music_id = music_id;
        }

        public AuthorEntity getAuthor() {
            return author;
        }

        public void setAuthor(AuthorEntity author) {
            this.author = author;
        }

        public static class AuthorEntity implements Serializable{
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

            @Override
            public String toString() {
                return "AuthorEntity{" +
                        "user_id='" + user_id + '\'' +
                        ", user_name='" + user_name + '\'' +
                        ", web_url='" + web_url + '\'' +
                        ", desc='" + desc + '\'' +
                        '}';
            }
        }

    @Override
    public String toString() {
        return "Music{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", cover='" + cover + '\'' +
                ", platform='" + platform + '\'' +
                ", music_id='" + music_id + '\'' +
                ", author=" + author +
                '}';
    }
}
