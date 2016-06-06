package com.example.chaokun.neihanduanzi.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by linchaokun on 2016/6/6.
 */
public class Joke implements Serializable {
    public static String url = "http://ic.snssdk.com/neihan/stream/mix/v1/?mpic=1&essence=1&content_type=-102&message_cursor=-1&bd_Stringitude=113.369569&bd_latitude=23.149678&bd_city=%E5%B9%BF%E5%B7%9E%E5%B8%82&am_Stringitude=113.367846&am_latitude=23.149878&am_city=%E5%B9%BF%E5%B7%9E%E5%B8%82&am_loc_time=1465213692154&count=30&min_time=1465213700&screen_width=720&iid=4512422578&device_id=17215021497&ac=wifi&channel=NHSQH5AN&aid=7&app_name=joke_essay&version_code=431&device_platform=android&ssmix=a&device_type=6s+Plus&os_api=19&os_version=4.4.2&uuid=864394108025091&openudid=80FA5B208E050000&manifest_version_code=431";


    private List<DataBean> data;


    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {


        private GroupBean group;


        public GroupBean getGroup() {
            return group;
        }

        public void setGroup(GroupBean group) {
            this.group = group;
        }


        public static class GroupBean {
            private String text;
            private Long create_time;
            private String favorite_count;
            private String go_detail_count;
            private String content;
            private String comment_count;
            private boolean quick_comment;


            private UserBean user;
            private String bury_count;
            private String repin_count;
            private String digg_count;
            /**
             * type : 1
             * id : 302
             * title : 糗人糗事
             */



            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }


            public Long getCreate_time() {
                return create_time;
            }

            public void setCreate_time(Long create_time) {
                this.create_time = create_time;
            }


            public String getFavorite_count() {
                return favorite_count;
            }

            public void setFavorite_count(String favorite_count) {
                this.favorite_count = favorite_count;
            }

            public String getGo_detail_count() {
                return go_detail_count;
            }

            public void setGo_detail_count(String go_detail_count) {
                this.go_detail_count = go_detail_count;
            }


            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getComment_count() {
                return comment_count;
            }

            public void setComment_count(String comment_count) {
                this.comment_count = comment_count;
            }


            public boolean isQuick_comment() {
                return quick_comment;
            }

            public void setQuick_comment(boolean quick_comment) {
                this.quick_comment = quick_comment;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }


            public String getBury_count() {
                return bury_count;
            }

            public void setBury_count(String bury_count) {
                this.bury_count = bury_count;
            }


            public String getRepin_count() {
                return repin_count;
            }

            public void setRepin_count(String repin_count) {
                this.repin_count = repin_count;
            }


            public String getDigg_count() {
                return digg_count;
            }

            public void setDigg_count(String digg_count) {
                this.digg_count = digg_count;
            }



            public static class ActivityBean {
            }

            public static class UserBean {
                private String name;



                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }


            }




        }


    }
}
