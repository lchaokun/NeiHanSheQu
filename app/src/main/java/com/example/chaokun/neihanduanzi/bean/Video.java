package com.example.chaokun.neihanduanzi.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by linchaokun on 2016/6/9.
 */
public class Video implements Serializable{
    public static String url="http://ic.snssdk.com/neihan/stream/mix/v1/?mpic=1&essence=1&content_type=-104&message_cursor=-1&bd_longitude=113.369569&bd_latitude=23.149678&bd_city=%E5%B9%BF%E5%B7%9E%E5%B8%82&am_longitude=113.367863&am_latitude=23.149878&am_city=%E5%B9%BF%E5%B7%9E%E5%B8%82&am_loc_time=1465227022051&count=30&min_time=1465213698&screen_width=720&iid=4512422578&device_id=17215021497&ac=wifi&channel=NHSQH5AN&aid=7&app_name=joke_essay&version_code=431&device_platform=android&ssmix=a&device_type=6s+Plus&os_api=19&os_version=4.4.2&uuid=864394108025091&openudid=80FA5B208E050000&manifest_version_code=431";
    public static String coverurl="http://p2.pstatp.com/large/";
    public static String lckmp4url="http://i.snssdk.com/neihan/video/playback/?video_id=39bb5f9aaf88427d97fccbb824fc5a9d&amp;quality=480p&amp;line=0&amp;is_gif=0.mp4";
    public static String lckimg="http://a3.qpic.cn/psb?/V133b2Xt1twpwH/gS6yNBAsPLS1e5Tk0bz2ahImgz9GjWnZq4I.Kh1qHls!/b/dKQAAAAAAAAA&bo=1AT0AtQE9AIDACU!&rf=viewer_4";
    public static String coverImg=coverurl+"71a00139b5e614a294a";
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
            private String mp4_url;
            private String text;
            private String digg_count;
            private double duration;
            private Long create_time;
            private long id;
            private String favorite_count;
            private String go_detail_count;
            private String title;
            private String is_can_share;
            private String category_type;
            private String share_url;
            private String label;
            private String content;
            private String video_height;
            private String comment_count;
            private String cover_image_uri;
            private String id_str;
            private String media_type;
            private String share_count;
            private String type;
            private String status;
            private String has_comments;
            private String publish_time;
            private String user_bury;
            private String status_desc;
            private String neihan_hot_start_time;
            private String play_count;
            private String user_repin;
            private boolean quick_comment;
            /**
             * user_id : 6083945672
             * name : 迁就吧
             * followings : 0
             * ugc_count : 9
             * avatar_url : http://p2.pstatp.com/thumb/6cb000fd715811dfa3a
             * followers : 327
             * is_following : false
             * user_verified : false
             */

            private UserBean user;
            private String neihan_hot_end_time;
            private String user_digg;
            private String video_width;
            private String online_time;
            private String category_name;
            private String flash_url;
            private boolean category_visible;
            private String bury_count;
            private boolean is_anonymous;
            private String repin_count;
            private boolean is_neihan_hot;
            private String uri;
            private String is_public_url;
            private String has_hot_comments;
            private boolean allow_dislike;
            /**
             * width : 464
             * url_list : [{"url":"http://i.snssdk.com/neihan/video/playback/?video_id=f94a94bcff3a40c49d2524a91d9f42e7&amp;quality=origin&amp;line=0&amp;is_gif=0"},{"url":"http://i.snssdk.com/neihan/video/playback/?video_id=f94a94bcff3a40c49d2524a91d9f42e7&amp;quality=origin&amp;line=1&amp;is_gif=0"}]
             * uri : origin/f94a94bcff3a40c49d2524a91d9f42e7
             * height : 352
             */

            private OriginVideoBean origin_video;
            private String cover_image_url;
            private long group_id;
            private String is_video;
            private String category_id;
            /**
             * type : 1
             * id : 319
             * title : 恶搞
             */

            private List<DislikeReasonBean> dislike_reason;

            public String getMp4_url() {
                return mp4_url;
            }

            public void setMp4_url(String mp4_url) {
                this.mp4_url = mp4_url;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getDigg_count() {
                return digg_count;
            }

            public void setDigg_count(String digg_count) {
                this.digg_count = digg_count;
            }

            public double getDuration() {
                return duration;
            }

            public void setDuration(double duration) {
                this.duration = duration;
            }

            public Long getCreate_time() {
                return create_time;
            }

            public void setCreate_time(Long create_time) {
                this.create_time = create_time;
            }

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
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

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getIs_can_share() {
                return is_can_share;
            }

            public void setIs_can_share(String is_can_share) {
                this.is_can_share = is_can_share;
            }

            public String getCategory_type() {
                return category_type;
            }

            public void setCategory_type(String category_type) {
                this.category_type = category_type;
            }

            public String getShare_url() {
                return share_url;
            }

            public void setShare_url(String share_url) {
                this.share_url = share_url;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getVideo_height() {
                return video_height;
            }

            public void setVideo_height(String video_height) {
                this.video_height = video_height;
            }

            public String getComment_count() {
                return comment_count;
            }

            public void setComment_count(String comment_count) {
                this.comment_count = comment_count;
            }

            public String getCover_image_uri() {
                return cover_image_uri;
            }

            public void setCover_image_uri(String cover_image_uri) {
                this.cover_image_uri = cover_image_uri;
            }

            public String getId_str() {
                return id_str;
            }

            public void setId_str(String id_str) {
                this.id_str = id_str;
            }

            public String getMedia_type() {
                return media_type;
            }

            public void setMedia_type(String media_type) {
                this.media_type = media_type;
            }

            public String getShare_count() {
                return share_count;
            }

            public void setShare_count(String share_count) {
                this.share_count = share_count;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getHas_comments() {
                return has_comments;
            }

            public void setHas_comments(String has_comments) {
                this.has_comments = has_comments;
            }

            public String getPublish_time() {
                return publish_time;
            }

            public void setPublish_time(String publish_time) {
                this.publish_time = publish_time;
            }

            public String getUser_bury() {
                return user_bury;
            }

            public void setUser_bury(String user_bury) {
                this.user_bury = user_bury;
            }

            public String getStatus_desc() {
                return status_desc;
            }

            public void setStatus_desc(String status_desc) {
                this.status_desc = status_desc;
            }

            public String getNeihan_hot_start_time() {
                return neihan_hot_start_time;
            }

            public void setNeihan_hot_start_time(String neihan_hot_start_time) {
                this.neihan_hot_start_time = neihan_hot_start_time;
            }

            public String getPlay_count() {
                return play_count;
            }

            public void setPlay_count(String play_count) {
                this.play_count = play_count;
            }

            public String getUser_repin() {
                return user_repin;
            }

            public void setUser_repin(String user_repin) {
                this.user_repin = user_repin;
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

            public String getNeihan_hot_end_time() {
                return neihan_hot_end_time;
            }

            public void setNeihan_hot_end_time(String neihan_hot_end_time) {
                this.neihan_hot_end_time = neihan_hot_end_time;
            }

            public String getUser_digg() {
                return user_digg;
            }

            public void setUser_digg(String user_digg) {
                this.user_digg = user_digg;
            }

            public String getVideo_width() {
                return video_width;
            }

            public void setVideo_width(String video_width) {
                this.video_width = video_width;
            }

            public String getOnline_time() {
                return online_time;
            }

            public void setOnline_time(String online_time) {
                this.online_time = online_time;
            }

            public String getCategory_name() {
                return category_name;
            }

            public void setCategory_name(String category_name) {
                this.category_name = category_name;
            }

            public String getFlash_url() {
                return flash_url;
            }

            public void setFlash_url(String flash_url) {
                this.flash_url = flash_url;
            }

            public boolean isCategory_visible() {
                return category_visible;
            }

            public void setCategory_visible(boolean category_visible) {
                this.category_visible = category_visible;
            }

            public String getBury_count() {
                return bury_count;
            }

            public void setBury_count(String bury_count) {
                this.bury_count = bury_count;
            }

            public boolean isIs_anonymous() {
                return is_anonymous;
            }

            public void setIs_anonymous(boolean is_anonymous) {
                this.is_anonymous = is_anonymous;
            }

            public String getRepin_count() {
                return repin_count;
            }

            public void setRepin_count(String repin_count) {
                this.repin_count = repin_count;
            }

            public boolean isIs_neihan_hot() {
                return is_neihan_hot;
            }

            public void setIs_neihan_hot(boolean is_neihan_hot) {
                this.is_neihan_hot = is_neihan_hot;
            }

            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }

            public String getIs_public_url() {
                return is_public_url;
            }

            public void setIs_public_url(String is_public_url) {
                this.is_public_url = is_public_url;
            }

            public String getHas_hot_comments() {
                return has_hot_comments;
            }

            public void setHas_hot_comments(String has_hot_comments) {
                this.has_hot_comments = has_hot_comments;
            }

            public boolean isAllow_dislike() {
                return allow_dislike;
            }

            public void setAllow_dislike(boolean allow_dislike) {
                this.allow_dislike = allow_dislike;
            }

            public OriginVideoBean getOrigin_video() {
                return origin_video;
            }

            public void setOrigin_video(OriginVideoBean origin_video) {
                this.origin_video = origin_video;
            }

            public String getCover_image_url() {
                return cover_image_url;
            }

            public void setCover_image_url(String cover_image_url) {
                this.cover_image_url = cover_image_url;
            }

            public long getGroup_id() {
                return group_id;
            }

            public void setGroup_id(long group_id) {
                this.group_id = group_id;
            }

            public String getIs_video() {
                return is_video;
            }

            public void setIs_video(String is_video) {
                this.is_video = is_video;
            }

            public String getCategory_id() {
                return category_id;
            }

            public void setCategory_id(String category_id) {
                this.category_id = category_id;
            }

            public List<DislikeReasonBean> getDislike_reason() {
                return dislike_reason;
            }

            public void setDislike_reason(List<DislikeReasonBean> dislike_reason) {
                this.dislike_reason = dislike_reason;
            }

            public static class UserBean {
                private long user_id;
                private String name;
                private String followings;
                private String ugc_count;
                private String avatar_url;
                private String followers;
                private boolean is_following;
                private boolean user_verified;

                public long getUser_id() {
                    return user_id;
                }

                public void setUser_id(long user_id) {
                    this.user_id = user_id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getFollowings() {
                    return followings;
                }

                public void setFollowings(String followings) {
                    this.followings = followings;
                }

                public String getUgc_count() {
                    return ugc_count;
                }

                public void setUgc_count(String ugc_count) {
                    this.ugc_count = ugc_count;
                }

                public String getAvatar_url() {
                    return avatar_url;
                }

                public void setAvatar_url(String avatar_url) {
                    this.avatar_url = avatar_url;
                }

                public String getFollowers() {
                    return followers;
                }

                public void setFollowers(String followers) {
                    this.followers = followers;
                }

                public boolean isIs_following() {
                    return is_following;
                }

                public void setIs_following(boolean is_following) {
                    this.is_following = is_following;
                }

                public boolean isUser_verified() {
                    return user_verified;
                }

                public void setUser_verified(boolean user_verified) {
                    this.user_verified = user_verified;
                }
            }

            public static class OriginVideoBean {
                private String width;
                private String uri;
                private String height;
                /**
                 * url : http://i.snssdk.com/neihan/video/playback/?video_id=f94a94bcff3a40c49d2524a91d9f42e7&amp;quality=origin&amp;line=0&amp;is_gif=0
                 */

                private List<UrlListBean> url_list;

                public String getWidth() {
                    return width;
                }

                public void setWidth(String width) {
                    this.width = width;
                }

                public String getUri() {
                    return uri;
                }

                public void setUri(String uri) {
                    this.uri = uri;
                }

                public String getHeight() {
                    return height;
                }

                public void setHeight(String height) {
                    this.height = height;
                }

                public List<UrlListBean> getUrl_list() {
                    return url_list;
                }

                public void setUrl_list(List<UrlListBean> url_list) {
                    this.url_list = url_list;
                }

                public static class UrlListBean {
                    private String url;

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }
                }
            }

            public static class DislikeReasonBean {
                private String type;
                private String id;
                private String title;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

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
            }
        }
    }
}
