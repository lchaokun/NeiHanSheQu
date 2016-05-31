package com.example.chaokun.neihanduanzi.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wcb1 on 2016/5/31.
 */
public class Picture implements Serializable{

    public static final String URL_BORING_PICTURE = "http://jandan.net/?oxwlxojflwblxbsapi=jandan.get_pic_comments&page=";
    public static final String URL_SISTER = "http://jandan.net/?oxwlxojflwblxbsapi=jandan.get_ooxx_comments&page=";

    public enum PictureType {
        BoringPicture, Sister
    }

    public static String getRequestUrl(PictureType type, int page) {

        switch (type) {
            case BoringPicture:
                return URL_BORING_PICTURE + page;
            case Sister:
                return URL_SISTER + page;
            default:
                return "";
        }
    }
    /**
     * status : ok
     * current_page : 1
     * total_comments : 230066
     * page_count : 9203
     * count : 25
     * comments : [{"comment_ID":"3155918","comment_post_ID":"26402","comment_author":"mm","comment_author_email":"miaoxingchao@163.com","comment_author_url":"","comment_author_IP":"112.229.109.183","comment_date":"2016-05-31 10:09:17","comment_date_gmt":"2016-05-31 02:09:17","comment_content":"&lt;img src=\"http://ww2.sinaimg.cn/mw600/604e48d0gw1f425qkmahwj20b44l1470.jpg\" /&gt;","comment_karma":"0","comment_approved":"1","comment_agent":"Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.154 Safari/537.36 LBBROWSER","comment_type":"","comment_parent":"0","user_id":"0","comment_subscribe":"N","comment_reply_ID":"0","vote_positive":"23","vote_negative":"41","vote_ip_pool":"","text_content":"","pics":["http://ww2.sinaimg.cn/mw600/604e48d0gw1f425qkmahwj20b44l1470.jpg"],"videos":[]},{"comment_ID":"3155917","comment_post_ID":"26402","comment_author":"mm","comment_author_email":"miaoxingchao@163.com","comment_author_url":"","comment_author_IP":"112.229.109.183","comment_date":"2016-05-31 10:09:01","comment_date_gmt":"2016-05-31 02:09:01","comment_content":"&lt;img src=\"http://ww1.sinaimg.cn/mw600/604e48d0gw1f425qjeywdj20b46nuwsn.jpg\" /&gt;","comment_karma":"0","comment_approved":"1","comment_agent":"Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.154 Safari/537.36 LBBROWSER","comment_type":"","comment_parent":"0","user_id":"0","comment_subscribe":"N","comment_reply_ID":"0","vote_positive":"8","vote_negative":"41","vote_ip_pool":"","text_content":"","pics":["http://ww1.sinaimg.cn/mw600/604e48d0gw1f425qjeywdj20b46nuwsn.jpg"],"videos":[]},{"comment_ID":"3155916","comment_post_ID":"26402","comment_author":"mm","comment_author_email":"miaoxingchao@163.com","comment_author_url":"","comment_author_IP":"112.229.109.183","comment_date":"2016-05-31 10:08:44","comment_date_gmt":"2016-05-31 02:08:44","comment_content":"&lt;img src=\"http://ww3.sinaimg.cn/mw600/604e48d0gw1f425qhngvhj20b47wvwuz.jpg\" /&gt;","comment_karma":"0","comment_approved":"1","comment_agent":"Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.154 Safari/537.36 LBBROWSER","comment_type":"","comment_parent":"0","user_id":"0","comment_subscribe":"N","comment_reply_ID":"0","vote_positive":"6","vote_negative":"44","vote_ip_pool":"","text_content":"","pics":["http://ww3.sinaimg.cn/mw600/604e48d0gw1f425qhngvhj20b47wvwuz.jpg"],"videos":[]},{"comment_ID":"3155915","comment_post_ID":"26402","comment_author":"mm","comment_author_email":"miaoxingchao@163.com","comment_author_url":"","comment_author_IP":"112.229.109.183","comment_date":"2016-05-31 10:08:27","comment_date_gmt":"2016-05-31 02:08:27","comment_content":"&lt;img src=\"http://ww4.sinaimg.cn/mw600/604e48d0gw1f425qge3c3j20b47qs4eb.jpg\" /&gt;","comment_karma":"0","comment_approved":"1","comment_agent":"Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.154 Safari/537.36 LBBROWSER","comment_type":"","comment_parent":"0","user_id":"0","comment_subscribe":"N","comment_reply_ID":"0","vote_positive":"4","vote_negative":"47","vote_ip_pool":"","text_content":"","pics":["http://ww4.sinaimg.cn/mw600/604e48d0gw1f425qge3c3j20b47qs4eb.jpg"],"videos":[]},{"comment_ID":"3155914","comment_post_ID":"26402","comment_author":"mm","comment_author_email":"miaoxingchao@163.com","comment_author_url":"","comment_author_IP":"112.229.109.183","comment_date":"2016-05-31 10:08:08","comment_date_gmt":"2016-05-31 02:08:08","comment_content":"&lt;img src=\"http://ww1.sinaimg.cn/mw600/604e48d0gw1f425qe8qp6j20b485otqy.jpg\" /&gt;","comment_karma":"0","comment_approved":"1","comment_agent":"Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.154 Safari/537.36 LBBROWSER","comment_type":"","comment_parent":"0","user_id":"0","comment_subscribe":"N","comment_reply_ID":"0","vote_positive":"5","vote_negative":"47","vote_ip_pool":"","text_content":"","pics":["http://ww1.sinaimg.cn/mw600/604e48d0gw1f425qe8qp6j20b485otqy.jpg"],"videos":[]},{"comment_ID":"3155913","comment_post_ID":"26402","comment_author":"mm","comment_author_email":"miaoxingchao@163.com","comment_author_url":"","comment_author_IP":"112.229.109.183","comment_date":"2016-05-31 10:07:49","comment_date_gmt":"2016-05-31 02:07:49","comment_content":"&lt;img src=\"http://ww2.sinaimg.cn/mw600/604e48d0gw1f425qcsncnj20b45iun93.jpg\" /&gt;","comment_karma":"0","comment_approved":"1","comment_agent":"Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.154 Safari/537.36 LBBROWSER","comment_type":"","comment_parent":"0","user_id":"0","comment_subscribe":"N","comment_reply_ID":"0","vote_positive":"2","vote_negative":"49","vote_ip_pool":"","text_content":"","pics":["http://ww2.sinaimg.cn/mw600/604e48d0gw1f425qcsncnj20b45iun93.jpg"],"videos":[]},{"comment_ID":"3155912","comment_post_ID":"26402","comment_author":"mm","comment_author_email":"miaoxingchao@163.com","comment_author_url":"","comment_author_IP":"112.229.109.183","comment_date":"2016-05-31 10:07:31","comment_date_gmt":"2016-05-31 02:07:31","comment_content":"&lt;img src=\"http://ww4.sinaimg.cn/mw600/604e48d0gw1f425q9qy0tj20b45unakt.jpg\" /&gt;","comment_karma":"0","comment_approved":"1","comment_agent":"Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.154 Safari/537.36 LBBROWSER","comment_type":"","comment_parent":"0","user_id":"0","comment_subscribe":"N","comment_reply_ID":"0","vote_positive":"8","vote_negative":"48","vote_ip_pool":"","text_content":"","pics":["http://ww4.sinaimg.cn/mw600/604e48d0gw1f425q9qy0tj20b45unakt.jpg"],"videos":[]},{"comment_ID":"3155911","comment_post_ID":"26402","comment_author":"mm","comment_author_email":"miaoxingchao@163.com","comment_author_url":"","comment_author_IP":"112.229.109.183","comment_date":"2016-05-31 10:07:12","comment_date_gmt":"2016-05-31 02:07:12","comment_content":"&lt;img src=\"http://ww3.sinaimg.cn/mw600/604e48d0gw1f425q8kkyfj20b48i67nq.jpg\" /&gt;","comment_karma":"0","comment_approved":"1","comment_agent":"Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.154 Safari/537.36 LBBROWSER","comment_type":"","comment_parent":"0","user_id":"0","comment_subscribe":"N","comment_reply_ID":"0","vote_positive":"7","vote_negative":"50","vote_ip_pool":"","text_content":"","pics":["http://ww3.sinaimg.cn/mw600/604e48d0gw1f425q8kkyfj20b48i67nq.jpg"],"videos":[]},{"comment_ID":"3155910","comment_post_ID":"26402","comment_author":"mm","comment_author_email":"miaoxingchao@163.com","comment_author_url":"","comment_author_IP":"112.229.109.183","comment_date":"2016-05-31 10:06:53","comment_date_gmt":"2016-05-31 02:06:53","comment_content":"&lt;img src=\"http://ww4.sinaimg.cn/mw600/604e48d0gw1f425q6ek4ij20b47ozh43.jpg\" /&gt;","comment_karma":"0","comment_approved":"1","comment_agent":"Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.154 Safari/537.36 LBBROWSER","comment_type":"","comment_parent":"0","user_id":"0","comment_subscribe":"N","comment_reply_ID":"0","vote_positive":"4","vote_negative":"63","vote_ip_pool":"","text_content":"","pics":["http://ww4.sinaimg.cn/mw600/604e48d0gw1f425q6ek4ij20b47ozh43.jpg"],"videos":[]},{"comment_ID":"3155909","comment_post_ID":"26402","comment_author":"mm","comment_author_email":"miaoxingchao@163.com","comment_author_url":"","comment_author_IP":"112.229.109.183","comment_date":"2016-05-31 10:06:28","comment_date_gmt":"2016-05-31 02:06:28","comment_content":"&lt;img src=\"http://ww2.sinaimg.cn/mw1024/604e48d0gw1f427tsnpfhg208w08wx6p.gif\" /&gt;","comment_karma":"0","comment_approved":"1","comment_agent":"Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.154 Safari/537.36 LBBROWSER","comment_type":"","comment_parent":"0","user_id":"0","comment_subscribe":"N","comment_reply_ID":"0","vote_positive":"4","vote_negative":"16","vote_ip_pool":"","text_content":"","pics":["http://ww2.sinaimg.cn/mw1024/604e48d0gw1f427tsnpfhg208w08wx6p.gif"],"videos":[]},{"comment_ID":"3155907","comment_post_ID":"26402","comment_author":"mm","comment_author_email":"miaoxingchao@163.com","comment_author_url":"","comment_author_IP":"112.229.109.183","comment_date":"2016-05-31 10:05:34","comment_date_gmt":"2016-05-31 02:05:34","comment_content":"&lt;img src=\"http://ww2.sinaimg.cn/mw600/604e48d0gw1f43b5cawo2j20j60dzjwa.jpg\" /&gt;","comment_karma":"0","comment_approved":"1","comment_agent":"Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.154 Safari/537.36 LBBROWSER","comment_type":"","comment_parent":"0","user_id":"0","comment_subscribe":"N","comment_reply_ID":"0","vote_positive":"20","vote_negative":"9","vote_ip_pool":"","text_content":"","pics":["http://ww2.sinaimg.cn/mw600/604e48d0gw1f43b5cawo2j20j60dzjwa.jpg"],"videos":[]},{"comment_ID":"3155905","comment_post_ID":"26402","comment_author":"mm","comment_author_email":"miaoxingchao@163.com","comment_author_url":"","comment_author_IP":"112.229.109.183","comment_date":"2016-05-31 10:03:25","comment_date_gmt":"2016-05-31 02:03:25","comment_content":"&lt;img src=\"http://ww1.sinaimg.cn/mw1024/604e48d0gw1f45oqogoz7g208c045e81.gif\" /&gt;","comment_karma":"0","comment_approved":"1","comment_agent":"Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.154 Safari/537.36 LBBROWSER","comment_type":"","comment_parent":"0","user_id":"0","comment_subscribe":"N","comment_reply_ID":"0","vote_positive":"4","vote_negative":"17","vote_ip_pool":"","text_content":"","pics":["http://ww1.sinaimg.cn/mw1024/604e48d0gw1f45oqogoz7g208c045e81.gif"],"videos":[]},{"comment_ID":"3155904","comment_post_ID":"26402","comment_author":"mm","comment_author_email":"miaoxingchao@163.com","comment_author_url":"","comment_author_IP":"112.229.109.183","comment_date":"2016-05-31 10:02:35","comment_date_gmt":"2016-05-31 02:02:35","comment_content":"&lt;img src=\"http://ww3.sinaimg.cn/mw1024/604e48d0jw1f45pvew4mfg205k05je86.gif\" /&gt;","comment_karma":"0","comment_approved":"1","comment_agent":"Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.154 Safari/537.36 LBBROWSER","comment_type":"","comment_parent":"0","user_id":"0","comment_subscribe":"N","comment_reply_ID":"0","vote_positive":"22","vote_negative":"5","vote_ip_pool":"","text_content":"","pics":["http://ww3.sinaimg.cn/mw1024/604e48d0jw1f45pvew4mfg205k05je86.gif"],"videos":[]},{"comment_ID":"3155903","comment_post_ID":"26402","comment_author":"mm","comment_author_email":"miaoxingchao@163.com","comment_author_url":"","comment_author_IP":"112.229.109.183","comment_date":"2016-05-31 10:00:17","comment_date_gmt":"2016-05-31 02:00:17","comment_content":"&lt;img src=\"http://ww1.sinaimg.cn/mw690/604e48d0gw1f0npnmg01fg208009jx6p.gif\" /&gt;","comment_karma":"0","comment_approved":"1","comment_agent":"Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.154 Safari/537.36 LBBROWSER","comment_type":"","comment_parent":"0","user_id":"0","comment_subscribe":"N","comment_reply_ID":"0","vote_positive":"13","vote_negative":"2","vote_ip_pool":"","text_content":"","pics":["http://ww1.sinaimg.cn/mw690/604e48d0gw1f0npnmg01fg208009jx6p.gif"],"videos":[]},{"comment_ID":"3155896","comment_post_ID":"26402","comment_author":"哎呦呵","comment_author_email":"2640544075@qq.com","comment_author_url":"","comment_author_IP":"120.36.249.81","comment_date":"2016-05-31 09:55:15","comment_date_gmt":"2016-05-31 01:55:15","comment_content":"摄像小哥的内心是崩溃的\r\n&lt;img src=\"http://ww4.sinaimg.cn/mw600/bba92d9agw1f4eb5pcph7j20ky0icmz4.jpg\" /&gt;\r\n&lt;img src=\"http://ww2.sinaimg.cn/mw600/bba92d9agw1f4eb5pyza1j20km0k640y.jpg\" /&gt;\r\n&lt;img src=\"http://ww3.sinaimg.cn/mw600/bba92d9agw1f4eb5rjutzj20np0irwhj.jpg\" /&gt;","comment_karma":"0","comment_approved":"1","comment_agent":"Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36","comment_type":"","comment_parent":"0","user_id":"0","comment_subscribe":"N","comment_reply_ID":"0","vote_positive":"6","vote_negative":"2","vote_ip_pool":"","text_content":"摄像小哥的内心是崩溃的\r\n\r\n\r\n","pics":["http://ww4.sinaimg.cn/mw600/bba92d9agw1f4eb5pcph7j20ky0icmz4.jpg","http://ww2.sinaimg.cn/mw600/bba92d9agw1f4eb5pyza1j20km0k640y.jpg","http://ww3.sinaimg.cn/mw600/bba92d9agw1f4eb5rjutzj20np0irwhj.jpg"],"videos":[]},{"comment_ID":"3155894","comment_post_ID":"26402","comment_author":"kidd","comment_author_email":"halle@foxmail.com","comment_author_url":"","comment_author_IP":"106.37.187.135","comment_date":"2016-05-31 09:54:54","comment_date_gmt":"2016-05-31 01:54:54","comment_content":"&lt;img src=\"http://ww2.sinaimg.cn/mw690/444d7111jw1f4ebyuln6sg20b406sx72.gif\" /&gt;","comment_karma":"0","comment_approved":"1","comment_agent":"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36","comment_type":"","comment_parent":"0","user_id":"0","comment_subscribe":"N","comment_reply_ID":"0","vote_positive":"9","vote_negative":"0","vote_ip_pool":"","text_content":"","pics":["http://ww2.sinaimg.cn/mw690/444d7111jw1f4ebyuln6sg20b406sx72.gif"],"videos":[]},{"comment_ID":"3155891","comment_post_ID":"26402","comment_author":"流浪炼金术师","comment_author_email":"123456@qq.com","comment_author_url":"","comment_author_IP":"112.95.109.128","comment_date":"2016-05-31 09:52:47","comment_date_gmt":"2016-05-31 01:52:47","comment_content":"&lt;img src=\"http://ww3.sinaimg.cn/mw690/844527a1jw1f4e76nx43bg20dw07s7ws.gif\" /&gt;","comment_karma":"0","comment_approved":"1","comment_agent":"Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Maxthon/4.4.6.2000 Chrome/30.0.1599.101 Safari/537.36","comment_type":"","comment_parent":"0","user_id":"0","comment_subscribe":"N","comment_reply_ID":"0","vote_positive":"17","vote_negative":"5","vote_ip_pool":"","text_content":"","pics":["http://ww3.sinaimg.cn/mw690/844527a1jw1f4e76nx43bg20dw07s7ws.gif"],"videos":[]},{"comment_ID":"3155890","comment_post_ID":"26402","comment_author":"膝盖中箭","comment_author_email":"263948481@qq.com","comment_author_url":"","comment_author_IP":"218.66.232.134","comment_date":"2016-05-31 09:52:39","comment_date_gmt":"2016-05-31 01:52:39","comment_content":"&lt;img src=\"http://ww3.sinaimg.cn/mw690/c1a3c815gw1f4ea7pqfd5g208s04y7wi.gif\" /&gt;","comment_karma":"0","comment_approved":"1","comment_agent":"Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36 TheWorld 6","comment_type":"","comment_parent":"0","user_id":"0","comment_subscribe":"N","comment_reply_ID":"0","vote_positive":"16","vote_negative":"1","vote_ip_pool":"","text_content":"","pics":["http://ww3.sinaimg.cn/mw690/c1a3c815gw1f4ea7pqfd5g208s04y7wi.gif"],"videos":[]},{"comment_ID":"3155885","comment_post_ID":"26402","comment_author":"mercurypluto","comment_author_email":"mercurypluto@163.com","comment_author_url":"","comment_author_IP":"221.207.222.36","comment_date":"2016-05-31 09:49:05","comment_date_gmt":"2016-05-31 01:49:05","comment_content":"&lt;img src=\"http://ww2.sinaimg.cn/mw690/a2c9d1e5jw1f4eb9chw4pg20dw0dwx6p.gif\" /&gt;","comment_karma":"0","comment_approved":"1","comment_agent":"Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko","comment_type":"","comment_parent":"0","user_id":"0","comment_subscribe":"N","comment_reply_ID":"0","vote_positive":"13","vote_negative":"0","vote_ip_pool":"","text_content":"","pics":["http://ww2.sinaimg.cn/mw690/a2c9d1e5jw1f4eb9chw4pg20dw0dwx6p.gif"],"videos":[]},{"comment_ID":"3155883","comment_post_ID":"26402","comment_author":"mercurypluto","comment_author_email":"mercurypluto@163.com","comment_author_url":"","comment_author_IP":"221.207.222.36","comment_date":"2016-05-31 09:48:38","comment_date_gmt":"2016-05-31 01:48:38","comment_content":"&lt;img src=\"http://ww2.sinaimg.cn/mw690/a2c9d1e5jw1f4eb9dfqlng205k069u0x.gif\" /&gt;","comment_karma":"0","comment_approved":"1","comment_agent":"Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko","comment_type":"","comment_parent":"0","user_id":"0","comment_subscribe":"N","comment_reply_ID":"0","vote_positive":"6","vote_negative":"0","vote_ip_pool":"","text_content":"","pics":["http://ww2.sinaimg.cn/mw690/a2c9d1e5jw1f4eb9dfqlng205k069u0x.gif"],"videos":[]},{"comment_ID":"3155882","comment_post_ID":"26402","comment_author":"意外动情","comment_author_email":"wananyuxi@foxmail.com","comment_author_url":"","comment_author_IP":"27.225.250.27","comment_date":"2016-05-31 09:48:38","comment_date_gmt":"2016-05-31 01:48:38","comment_content":"&lt;img src=\"http://ww3.sinaimg.cn/mw600/7e948b4djw1f4dsbv0px6j20sg0qgtc7.jpg\" /&gt;","comment_karma":"0","comment_approved":"1","comment_agent":"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; .NET4.0C; SE 2.X MetaSr 1.0)","comment_type":"","comment_parent":"0","user_id":"0","comment_subscribe":"N","comment_reply_ID":"0","vote_positive":"36","vote_negative":"3","vote_ip_pool":"","text_content":"","pics":["http://ww3.sinaimg.cn/mw600/7e948b4djw1f4dsbv0px6j20sg0qgtc7.jpg"],"videos":[]},{"comment_ID":"3155881","comment_post_ID":"26402","comment_author":"Cat73","comment_author_email":"1901803382@qq.com","comment_author_url":"","comment_author_IP":"112.233.96.20","comment_date":"2016-05-31 09:48:29","comment_date_gmt":"2016-05-31 01:48:29","comment_content":"&lt;img src=\"http://ww4.sinaimg.cn/mw600/9103a520jw1f4ebszvip0j20n30e9my6.jpg\" /&gt;","comment_karma":"0","comment_approved":"1","comment_agent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.63 Safari/537.36","comment_type":"","comment_parent":"0","user_id":"0","comment_subscribe":"N","comment_reply_ID":"0","vote_positive":"3","vote_negative":"4","vote_ip_pool":"","text_content":"","pics":["http://ww4.sinaimg.cn/mw600/9103a520jw1f4ebszvip0j20n30e9my6.jpg"],"videos":[]},{"comment_ID":"3155880","comment_post_ID":"26402","comment_author":"rebecca","comment_author_email":"rebecca0001@163.com","comment_author_url":"","comment_author_IP":"223.72.199.166","comment_date":"2016-05-31 09:48:16","comment_date_gmt":"2016-05-31 01:48:16","comment_content":"&lt;img src=\"http://ww3.sinaimg.cn/mw1024/68f6e545gw1f4eboa7jetg20b40691lc.gif\" /&gt;","comment_karma":"0","comment_approved":"1","comment_agent":"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36","comment_type":"","comment_parent":"0","user_id":"0","comment_subscribe":"N","comment_reply_ID":"0","vote_positive":"12","vote_negative":"0","vote_ip_pool":"","text_content":"","pics":["http://ww3.sinaimg.cn/mw1024/68f6e545gw1f4eboa7jetg20b40691lc.gif"],"videos":[]},{"comment_ID":"3155879","comment_post_ID":"26402","comment_author":"mercurypluto","comment_author_email":"mercurypluto@163.com","comment_author_url":"","comment_author_IP":"221.207.222.36","comment_date":"2016-05-31 09:48:05","comment_date_gmt":"2016-05-31 01:48:05","comment_content":"&lt;img src=\"http://ww2.sinaimg.cn/mw690/a2c9d1e5jw1f4eb9b43y8g20dw08ox6p.gif\" /&gt;","comment_karma":"0","comment_approved":"1","comment_agent":"Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko","comment_type":"","comment_parent":"0","user_id":"0","comment_subscribe":"N","comment_reply_ID":"0","vote_positive":"6","vote_negative":"10","vote_ip_pool":"","text_content":"","pics":["http://ww2.sinaimg.cn/mw690/a2c9d1e5jw1f4eb9b43y8g20dw08ox6p.gif"],"videos":[]},{"comment_ID":"3155878","comment_post_ID":"26402","comment_author":"rebecca","comment_author_email":"rebecca0001@163.com","comment_author_url":"","comment_author_IP":"223.72.199.166","comment_date":"2016-05-31 09:47:53","comment_date_gmt":"2016-05-31 01:47:53","comment_content":"&lt;img src=\"http://ww1.sinaimg.cn/mw1024/68f6e545gw1f4ebp7nvzdg208c08c7ww.gif\" /&gt;","comment_karma":"0","comment_approved":"1","comment_agent":"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36","comment_type":"","comment_parent":"0","user_id":"0","comment_subscribe":"N","comment_reply_ID":"0","vote_positive":"8","vote_negative":"2","vote_ip_pool":"","text_content":"","pics":["http://ww1.sinaimg.cn/mw1024/68f6e545gw1f4ebp7nvzdg208c08c7ww.gif"],"videos":[]}]
     */

    private String status;
    private int current_page;
    private int total_comments;
    private int page_count;
    private int count;
    /**
     * comment_ID : 3155918
     * comment_post_ID : 26402
     * comment_author : mm
     * comment_author_email : miaoxingchao@163.com
     * comment_author_url :
     * comment_author_IP : 112.229.109.183
     * comment_date : 2016-05-31 10:09:17
     * comment_date_gmt : 2016-05-31 02:09:17
     * comment_content : &lt;img src="http://ww2.sinaimg.cn/mw600/604e48d0gw1f425qkmahwj20b44l1470.jpg" /&gt;
     * comment_karma : 0
     * comment_approved : 1
     * comment_agent : Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.154 Safari/537.36 LBBROWSER
     * comment_type :
     * comment_parent : 0
     * user_id : 0
     * comment_subscribe : N
     * comment_reply_ID : 0
     * vote_positive : 23
     * vote_negative : 41
     * vote_ip_pool :
     * text_content :
     * pics : ["http://ww2.sinaimg.cn/mw600/604e48d0gw1f425qkmahwj20b44l1470.jpg"]
     * videos : []
     */

    private List<CommentsBean> comments;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }

    public int getTotal_comments() {
        return total_comments;
    }

    public void setTotal_comments(int total_comments) {
        this.total_comments = total_comments;
    }

    public int getPage_count() {
        return page_count;
    }

    public void setPage_count(int page_count) {
        this.page_count = page_count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<CommentsBean> getComments() {
        return comments;
    }

    public void setComments(List<CommentsBean> comments) {
        this.comments = comments;
    }

    public static class CommentsBean {
        private String comment_ID;
        private String comment_post_ID;
        private String comment_author;
        private String comment_author_email;
        private String comment_author_url;
        private String comment_author_IP;
        private String comment_date;
        private String comment_date_gmt;
        private String comment_content;
        private String comment_karma;
        private String comment_approved;
        private String comment_agent;
        private String comment_type;
        private String comment_parent;
        private String user_id;
        private String comment_subscribe;
        private String comment_reply_ID;
        private String vote_positive;
        private String vote_negative;
        private String vote_ip_pool;
        private String text_content;
        private List<String> pics;
        private List<?> videos;

        public String getComment_ID() {
            return comment_ID;
        }

        public void setComment_ID(String comment_ID) {
            this.comment_ID = comment_ID;
        }

        public String getComment_post_ID() {
            return comment_post_ID;
        }

        public void setComment_post_ID(String comment_post_ID) {
            this.comment_post_ID = comment_post_ID;
        }

        public String getComment_author() {
            return comment_author;
        }

        public void setComment_author(String comment_author) {
            this.comment_author = comment_author;
        }

        public String getComment_author_email() {
            return comment_author_email;
        }

        public void setComment_author_email(String comment_author_email) {
            this.comment_author_email = comment_author_email;
        }

        public String getComment_author_url() {
            return comment_author_url;
        }

        public void setComment_author_url(String comment_author_url) {
            this.comment_author_url = comment_author_url;
        }

        public String getComment_author_IP() {
            return comment_author_IP;
        }

        public void setComment_author_IP(String comment_author_IP) {
            this.comment_author_IP = comment_author_IP;
        }

        public String getComment_date() {
            return comment_date;
        }

        public void setComment_date(String comment_date) {
            this.comment_date = comment_date;
        }

        public String getComment_date_gmt() {
            return comment_date_gmt;
        }

        public void setComment_date_gmt(String comment_date_gmt) {
            this.comment_date_gmt = comment_date_gmt;
        }

        public String getComment_content() {
            return comment_content;
        }

        public void setComment_content(String comment_content) {
            this.comment_content = comment_content;
        }

        public String getComment_karma() {
            return comment_karma;
        }

        public void setComment_karma(String comment_karma) {
            this.comment_karma = comment_karma;
        }

        public String getComment_approved() {
            return comment_approved;
        }

        public void setComment_approved(String comment_approved) {
            this.comment_approved = comment_approved;
        }

        public String getComment_agent() {
            return comment_agent;
        }

        public void setComment_agent(String comment_agent) {
            this.comment_agent = comment_agent;
        }

        public String getComment_type() {
            return comment_type;
        }

        public void setComment_type(String comment_type) {
            this.comment_type = comment_type;
        }

        public String getComment_parent() {
            return comment_parent;
        }

        public void setComment_parent(String comment_parent) {
            this.comment_parent = comment_parent;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getComment_subscribe() {
            return comment_subscribe;
        }

        public void setComment_subscribe(String comment_subscribe) {
            this.comment_subscribe = comment_subscribe;
        }

        public String getComment_reply_ID() {
            return comment_reply_ID;
        }

        public void setComment_reply_ID(String comment_reply_ID) {
            this.comment_reply_ID = comment_reply_ID;
        }

        public String getVote_positive() {
            return vote_positive;
        }

        public void setVote_positive(String vote_positive) {
            this.vote_positive = vote_positive;
        }

        public String getVote_negative() {
            return vote_negative;
        }

        public void setVote_negative(String vote_negative) {
            this.vote_negative = vote_negative;
        }

        public String getVote_ip_pool() {
            return vote_ip_pool;
        }

        public void setVote_ip_pool(String vote_ip_pool) {
            this.vote_ip_pool = vote_ip_pool;
        }

        public String getText_content() {
            return text_content;
        }

        public void setText_content(String text_content) {
            this.text_content = text_content;
        }

        public List<String> getPics() {
            return pics;
        }

        public void setPics(List<String> pics) {
            this.pics = pics;
        }

        public List<?> getVideos() {
            return videos;
        }

        public void setVideos(List<?> videos) {
            this.videos = videos;
        }
    }
}
