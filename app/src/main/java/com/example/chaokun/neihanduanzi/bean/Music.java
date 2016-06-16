package com.example.chaokun.neihanduanzi.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by linchaokun on 2016/6/14.
 */
public class Music implements Serializable{

    public static String url="http://route.showapi.com/255-1?type=31&showapi_appid=20569&showapi_sign=0707a6bfb3e842fb8c8aa450012d9756&page=";

    /**
     * ret_code : 0
     * pagebean : {"allPages":258,"contentlist":[{"text":"\n        深夜来一曲\n    ","hate":"55","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18914326.html/","profile_image":"http://qzapp.qlogo.cn/qzapp/100336987/3732B956EAAD56825960F55344A110EE/100","width":"0","voiceuri":"","type":"31","id":"18914326","love":"60","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0614/575f11934dd27.mp3","voicelength":"0","name":" 阿九-","create_time":"2016-06-14 07:34:39","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0614/575f119342544.jpg"},{"text":"\n        一个人走\n    ","hate":"19","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18903876.html/","profile_image":"http://qzapp.qlogo.cn/qzapp/100336987/417813C34B6C93CCBA6BFB70C1A1AD26/100","width":"0","voiceuri":"","type":"31","id":"18903876","love":"41","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0613/575e1dd00ba79.mp3","voicelength":"0","name":"远方V5V","create_time":"2016-06-13 11:16:54","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0613/575e1dd003c46.jpeg"},{"text":"\n        要好好的哦\n    ","hate":"18","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18903880.html/","profile_image":"http://mpic.spriteapp.cn/profile/large/2016/05/29/574af316db4a5_mini.jpg","width":"0","voiceuri":"","type":"31","id":"18903880","love":"34","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0613/575e1de5a3c5d.mp3","voicelength":"0","name":"白一序","create_time":"2016-06-13 11:16:43","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0613/575e1de593566.jpg"},{"text":"\n        最喜欢的粤语歌   随便唱几句\n    ","hate":"97","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18894453.html/","profile_image":"http://mpic.spriteapp.cn/profile/large/2016/04/11/570a7ae8b2420_mini.jpg","width":"0","voiceuri":"","type":"31","id":"18894453","love":"104","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0612/575d18c182f9c.mp3","voicelength":"0","name":"醒黛丫丫","create_time":"2016-06-12 17:10:09","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0612/575d18c17aead.jpg"},{"text":"\n        Big Bang - Fantastic Baby (All Studio  &amp;amp;amp; DjCupid Remix) 东方斯卡拉热播单曲\n    ","hate":"18","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18885955.html/","profile_image":"http://mpic.spriteapp.cn/profile/large/2016/03/23/56f228dde29db_mini.jpg","width":"0","voiceuri":"","type":"31","id":"18885955","love":"32","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0611/575c2498a3b3c.mp3","voicelength":"0","name":"DJ清风","create_time":"2016-06-12 08:51:00","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0611/575c2497d104f.jpg"},{"text":"\n        Dj Lucky S - Ldms (Original Mix)_DjMix 6 月夜店热播单曲\n    ","hate":"16","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18885968.html/","profile_image":"http://mpic.spriteapp.cn/profile/large/2016/03/23/56f228dde29db_mini.jpg","width":"0","voiceuri":"","type":"31","id":"18885968","love":"33","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0611/575c24dc80828.mp3","voicelength":"0","name":"DJ清风","create_time":"2016-06-12 08:50:16","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0611/575c24dbf3db6.jpg"},{"text":"\n        愿我们走过岁月 一直都牵着彼此的手 . （精神女唱）\r\n\r\n# Far East Movement - Lights Out (Go Crazy)\n    ","hate":"3","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18886271.html/","profile_image":"http://mpic.spriteapp.cn/profile/large/2016/03/05/56dac6b01ba23_mini.jpg","width":"0","voiceuri":"","type":"31","id":"18886271","love":"28","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0611/575c28fbcf4f6.mp3","voicelength":"0","name":"July鱼一","create_time":"2016-06-12 08:07:54","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0611/575c28fb9e80d.jpg"},{"text":"\n        这个游戏好污！ 昨天晚上玩了下被吓到了\n    ","hate":"38","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18888071.html/","profile_image":"http://qzapp.qlogo.cn/qzapp/100336987/21E2BAF28EC16884E14DBB74CF0BD00A/100","width":"0","voiceuri":"","type":"31","id":"18888071","love":"59","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0612/575c56b0705e5.mp3","voicelength":"0","name":"念她网络程晨","create_time":"2016-06-12 07:39:23","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0612/575c56b062a6f.jpg"},{"text":"\n        我不用刻意装作很厉害的样子，在你面前，做真正的自己不怕你笑话 .\r\n\r\n# Skrillex - Summit (feat. Ellie Goulding)\n    ","hate":"26","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18870333.html/","profile_image":"http://mpic.spriteapp.cn/profile/large/2016/03/05/56dac6b01ba23_mini.jpg","width":"0","voiceuri":"","type":"31","id":"18870333","love":"40","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0610/575aabd36d63f.mp3","voicelength":"0","name":"July鱼一","create_time":"2016-06-11 10:01:51","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0610/575aabd2b76fb.jpg"},{"text":"\n        Dj Ilton - Minions Bounce (Original Mix)\n    ","hate":"83","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18852033.html/","profile_image":"http://mpic.spriteapp.cn/profile/large/2016/03/23/56f228dde29db_mini.jpg","width":"0","voiceuri":"","type":"31","id":"18852033","love":"114","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0609/5758cea12bea0.mp3","voicelength":"0","name":"DJ清风","create_time":"2016-06-10 02:12:58","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0609/5758cea0d9478.jpg"},{"text":"\n        Rihanna - Umbrella (Trismiq Remix)\n    ","hate":"94","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18852319.html/","profile_image":"http://mpic.spriteapp.cn/profile/large/2016/03/23/56f228dde29db_mini.jpg","width":"0","voiceuri":"","type":"31","id":"18852319","love":"103","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0609/5758d4408f476.mp3","voicelength":"0","name":"DJ清风","create_time":"2016-06-09 17:48:49","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0609/5758d44011fb2.jpg"},{"text":"\n        我有一个很喜欢很喜欢的人\r\n可是我们没有在一起\r\n-Just Give Me A Reason\n    ","hate":"18","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18847331.html/","profile_image":"http://mpic.spriteapp.cn/profile/large/2016/05/25/5745c13179ea5_mini.jpg","width":"0","voiceuri":"","type":"31","id":"18847331","love":"34","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0608/57582b05375fb.mp3","voicelength":"0","name":"林诺ALin","create_time":"2016-06-09 00:38:03","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0608/57582b0502ce2.JPG"},{"text":"\n        幸福其实很简单 小含 有你就幸福 你的幸福只能由我给\n    ","hate":"38","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18848788.html/","profile_image":"http://mpic.spriteapp.cn/profile/large/2016/05/29/574af316db4a5_mini.jpg","width":"0","voiceuri":"","type":"31","id":"18848788","love":"35","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0609/5758421c8a1ef.mp3","voicelength":"0","name":"白一序","create_time":"2016-06-09 00:36:46","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0609/5758421c802aa.jpg"},{"text":"\n        生活不是一场赛跑\r\n而是一次旅行\r\n要懂得好好欣赏沿途的风景\r\n-Traveling Light\n    ","hate":"24","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18847606.html/","profile_image":"http://mpic.spriteapp.cn/profile/large/2016/05/25/5745c13179ea5_mini.jpg","width":"0","voiceuri":"","type":"31","id":"18847606","love":"40","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0608/57582f6abfb27.mp3","voicelength":"0","name":"林诺ALin","create_time":"2016-06-09 00:22:48","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0608/57582f6a9f7a3.JPG"},{"text":"\n        这世界上有一个人是永远等着你的\r\n不管是什么时候，不管你是在什么地方\r\n反正你知道，总有这样一个人\r\n-Melt The Snow\n    ","hate":"28","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18847699.html/","profile_image":"http://mpic.spriteapp.cn/profile/large/2016/05/25/5745c13179ea5_mini.jpg","width":"0","voiceuri":"","type":"31","id":"18847699","love":"33","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0608/575830e46fe46.mp3","voicelength":"0","name":"林诺ALin","create_time":"2016-06-09 00:16:12","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0608/575830e435d47.JPG"},{"text":"\n        Demi Lovato X Ger3to - Cool For The Summer (Lex Mashup)\n    ","hate":"15","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18836198.html/","profile_image":"http://mpic.spriteapp.cn/profile/large/2016/03/23/56f228dde29db_mini.jpg","width":"0","voiceuri":"","type":"31","id":"18836198","love":"34","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0608/5756fc157c19b.mp3","voicelength":"0","name":"DJ清风","create_time":"2016-06-08 15:18:06","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0608/5756fc15354e8.jpg"},{"text":"\n        两个相爱的人不需要天天在一起，只要彼此心里都想着，爱着就可以。\n    ","hate":"46","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18836976.html/","profile_image":"http://mpic.spriteapp.cn/profile/large/2015/09/09/55ef42e11ef80_mini.jpg","width":"0","voiceuri":"","type":"31","id":"18836976","love":"53","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0608/57571da4e5734.mp3","voicelength":"0","name":"时光流","create_time":"2016-06-08 07:58:13","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0608/57571da4dcc49.jpg"},{"text":"\n        有生之年，会有个人是为你而出现.\n    ","hate":"25","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18800656.html/","profile_image":"http://mpic.spriteapp.cn/profile/large/2016/06/04/5752799bbf97c_mini.jpg","width":"0","voiceuri":"","type":"31","id":"18800656","love":"20","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0605/5753be605fd23.mp3","voicelength":"0","name":"清欢十年温如水灬","create_time":"2016-06-07 14:01:23","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0605/5753be60124a3.jpg"},{"text":"\n        当你失去一切的时候,你才知道唯一想要的是什么.\n    ","hate":"31","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18800548.html/","profile_image":"http://mpic.spriteapp.cn/profile/large/2016/06/04/5752799bbf97c_mini.jpg","width":"0","voiceuri":"","type":"31","id":"18800548","love":"24","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0605/5753bb4babbfa.mp3","voicelength":"0","name":"清欢十年温如水灬","create_time":"2016-06-07 14:01:23","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0605/5753bb4b2ce41.jpeg"},{"text":"\n        啥哟，乱搞算不\n    ","hate":"93","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18825509.html/","profile_image":"http://mpic.spriteapp.cn/profile/large/2016/06/07/575636f3d04b4_mini.jpg","width":"0","voiceuri":"","type":"31","id":"18825509","love":"107","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0607/57563befc3ef7.mp3","voicelength":"0","name":"莘炚","create_time":"2016-06-07 13:17:43","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0607/57563bee15de1.jpeg"}],"currentPage":1,"allNum":5151,"maxResult":20}
     */

    private ShowapiResBodyBean showapi_res_body;

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean {
        private int ret_code;
        /**
         * allPages : 258
         * contentlist : [{"text":"\n        深夜来一曲\n    ","hate":"55","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18914326.html/","profile_image":"http://qzapp.qlogo.cn/qzapp/100336987/3732B956EAAD56825960F55344A110EE/100","width":"0","voiceuri":"","type":"31","id":"18914326","love":"60","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0614/575f11934dd27.mp3","voicelength":"0","name":" 阿九-","create_time":"2016-06-14 07:34:39","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0614/575f119342544.jpg"},{"text":"\n        一个人走\n    ","hate":"19","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18903876.html/","profile_image":"http://qzapp.qlogo.cn/qzapp/100336987/417813C34B6C93CCBA6BFB70C1A1AD26/100","width":"0","voiceuri":"","type":"31","id":"18903876","love":"41","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0613/575e1dd00ba79.mp3","voicelength":"0","name":"远方V5V","create_time":"2016-06-13 11:16:54","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0613/575e1dd003c46.jpeg"},{"text":"\n        要好好的哦\n    ","hate":"18","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18903880.html/","profile_image":"http://mpic.spriteapp.cn/profile/large/2016/05/29/574af316db4a5_mini.jpg","width":"0","voiceuri":"","type":"31","id":"18903880","love":"34","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0613/575e1de5a3c5d.mp3","voicelength":"0","name":"白一序","create_time":"2016-06-13 11:16:43","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0613/575e1de593566.jpg"},{"text":"\n        最喜欢的粤语歌   随便唱几句\n    ","hate":"97","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18894453.html/","profile_image":"http://mpic.spriteapp.cn/profile/large/2016/04/11/570a7ae8b2420_mini.jpg","width":"0","voiceuri":"","type":"31","id":"18894453","love":"104","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0612/575d18c182f9c.mp3","voicelength":"0","name":"醒黛丫丫","create_time":"2016-06-12 17:10:09","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0612/575d18c17aead.jpg"},{"text":"\n        Big Bang - Fantastic Baby (All Studio  &amp;amp;amp; DjCupid Remix) 东方斯卡拉热播单曲\n    ","hate":"18","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18885955.html/","profile_image":"http://mpic.spriteapp.cn/profile/large/2016/03/23/56f228dde29db_mini.jpg","width":"0","voiceuri":"","type":"31","id":"18885955","love":"32","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0611/575c2498a3b3c.mp3","voicelength":"0","name":"DJ清风","create_time":"2016-06-12 08:51:00","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0611/575c2497d104f.jpg"},{"text":"\n        Dj Lucky S - Ldms (Original Mix)_DjMix 6 月夜店热播单曲\n    ","hate":"16","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18885968.html/","profile_image":"http://mpic.spriteapp.cn/profile/large/2016/03/23/56f228dde29db_mini.jpg","width":"0","voiceuri":"","type":"31","id":"18885968","love":"33","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0611/575c24dc80828.mp3","voicelength":"0","name":"DJ清风","create_time":"2016-06-12 08:50:16","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0611/575c24dbf3db6.jpg"},{"text":"\n        愿我们走过岁月 一直都牵着彼此的手 . （精神女唱）\r\n\r\n# Far East Movement - Lights Out (Go Crazy)\n    ","hate":"3","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18886271.html/","profile_image":"http://mpic.spriteapp.cn/profile/large/2016/03/05/56dac6b01ba23_mini.jpg","width":"0","voiceuri":"","type":"31","id":"18886271","love":"28","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0611/575c28fbcf4f6.mp3","voicelength":"0","name":"July鱼一","create_time":"2016-06-12 08:07:54","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0611/575c28fb9e80d.jpg"},{"text":"\n        这个游戏好污！ 昨天晚上玩了下被吓到了\n    ","hate":"38","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18888071.html/","profile_image":"http://qzapp.qlogo.cn/qzapp/100336987/21E2BAF28EC16884E14DBB74CF0BD00A/100","width":"0","voiceuri":"","type":"31","id":"18888071","love":"59","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0612/575c56b0705e5.mp3","voicelength":"0","name":"念她网络程晨","create_time":"2016-06-12 07:39:23","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0612/575c56b062a6f.jpg"},{"text":"\n        我不用刻意装作很厉害的样子，在你面前，做真正的自己不怕你笑话 .\r\n\r\n# Skrillex - Summit (feat. Ellie Goulding)\n    ","hate":"26","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18870333.html/","profile_image":"http://mpic.spriteapp.cn/profile/large/2016/03/05/56dac6b01ba23_mini.jpg","width":"0","voiceuri":"","type":"31","id":"18870333","love":"40","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0610/575aabd36d63f.mp3","voicelength":"0","name":"July鱼一","create_time":"2016-06-11 10:01:51","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0610/575aabd2b76fb.jpg"},{"text":"\n        Dj Ilton - Minions Bounce (Original Mix)\n    ","hate":"83","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18852033.html/","profile_image":"http://mpic.spriteapp.cn/profile/large/2016/03/23/56f228dde29db_mini.jpg","width":"0","voiceuri":"","type":"31","id":"18852033","love":"114","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0609/5758cea12bea0.mp3","voicelength":"0","name":"DJ清风","create_time":"2016-06-10 02:12:58","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0609/5758cea0d9478.jpg"},{"text":"\n        Rihanna - Umbrella (Trismiq Remix)\n    ","hate":"94","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18852319.html/","profile_image":"http://mpic.spriteapp.cn/profile/large/2016/03/23/56f228dde29db_mini.jpg","width":"0","voiceuri":"","type":"31","id":"18852319","love":"103","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0609/5758d4408f476.mp3","voicelength":"0","name":"DJ清风","create_time":"2016-06-09 17:48:49","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0609/5758d44011fb2.jpg"},{"text":"\n        我有一个很喜欢很喜欢的人\r\n可是我们没有在一起\r\n-Just Give Me A Reason\n    ","hate":"18","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18847331.html/","profile_image":"http://mpic.spriteapp.cn/profile/large/2016/05/25/5745c13179ea5_mini.jpg","width":"0","voiceuri":"","type":"31","id":"18847331","love":"34","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0608/57582b05375fb.mp3","voicelength":"0","name":"林诺ALin","create_time":"2016-06-09 00:38:03","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0608/57582b0502ce2.JPG"},{"text":"\n        幸福其实很简单 小含 有你就幸福 你的幸福只能由我给\n    ","hate":"38","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18848788.html/","profile_image":"http://mpic.spriteapp.cn/profile/large/2016/05/29/574af316db4a5_mini.jpg","width":"0","voiceuri":"","type":"31","id":"18848788","love":"35","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0609/5758421c8a1ef.mp3","voicelength":"0","name":"白一序","create_time":"2016-06-09 00:36:46","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0609/5758421c802aa.jpg"},{"text":"\n        生活不是一场赛跑\r\n而是一次旅行\r\n要懂得好好欣赏沿途的风景\r\n-Traveling Light\n    ","hate":"24","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18847606.html/","profile_image":"http://mpic.spriteapp.cn/profile/large/2016/05/25/5745c13179ea5_mini.jpg","width":"0","voiceuri":"","type":"31","id":"18847606","love":"40","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0608/57582f6abfb27.mp3","voicelength":"0","name":"林诺ALin","create_time":"2016-06-09 00:22:48","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0608/57582f6a9f7a3.JPG"},{"text":"\n        这世界上有一个人是永远等着你的\r\n不管是什么时候，不管你是在什么地方\r\n反正你知道，总有这样一个人\r\n-Melt The Snow\n    ","hate":"28","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18847699.html/","profile_image":"http://mpic.spriteapp.cn/profile/large/2016/05/25/5745c13179ea5_mini.jpg","width":"0","voiceuri":"","type":"31","id":"18847699","love":"33","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0608/575830e46fe46.mp3","voicelength":"0","name":"林诺ALin","create_time":"2016-06-09 00:16:12","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0608/575830e435d47.JPG"},{"text":"\n        Demi Lovato X Ger3to - Cool For The Summer (Lex Mashup)\n    ","hate":"15","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18836198.html/","profile_image":"http://mpic.spriteapp.cn/profile/large/2016/03/23/56f228dde29db_mini.jpg","width":"0","voiceuri":"","type":"31","id":"18836198","love":"34","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0608/5756fc157c19b.mp3","voicelength":"0","name":"DJ清风","create_time":"2016-06-08 15:18:06","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0608/5756fc15354e8.jpg"},{"text":"\n        两个相爱的人不需要天天在一起，只要彼此心里都想着，爱着就可以。\n    ","hate":"46","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18836976.html/","profile_image":"http://mpic.spriteapp.cn/profile/large/2015/09/09/55ef42e11ef80_mini.jpg","width":"0","voiceuri":"","type":"31","id":"18836976","love":"53","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0608/57571da4e5734.mp3","voicelength":"0","name":"时光流","create_time":"2016-06-08 07:58:13","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0608/57571da4dcc49.jpg"},{"text":"\n        有生之年，会有个人是为你而出现.\n    ","hate":"25","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18800656.html/","profile_image":"http://mpic.spriteapp.cn/profile/large/2016/06/04/5752799bbf97c_mini.jpg","width":"0","voiceuri":"","type":"31","id":"18800656","love":"20","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0605/5753be605fd23.mp3","voicelength":"0","name":"清欢十年温如水灬","create_time":"2016-06-07 14:01:23","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0605/5753be60124a3.jpg"},{"text":"\n        当你失去一切的时候,你才知道唯一想要的是什么.\n    ","hate":"31","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18800548.html/","profile_image":"http://mpic.spriteapp.cn/profile/large/2016/06/04/5752799bbf97c_mini.jpg","width":"0","voiceuri":"","type":"31","id":"18800548","love":"24","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0605/5753bb4babbfa.mp3","voicelength":"0","name":"清欢十年温如水灬","create_time":"2016-06-07 14:01:23","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0605/5753bb4b2ce41.jpeg"},{"text":"\n        啥哟，乱搞算不\n    ","hate":"93","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-18825509.html/","profile_image":"http://mpic.spriteapp.cn/profile/large/2016/06/07/575636f3d04b4_mini.jpg","width":"0","voiceuri":"","type":"31","id":"18825509","love":"107","height":"0","voice_uri":"http://mvoice.spriteapp.cn/voice/2016/0607/57563befc3ef7.mp3","voicelength":"0","name":"莘炚","create_time":"2016-06-07 13:17:43","image3":"http://mpic.spriteapp.cn/crop/566x360/picture/2016/0607/57563bee15de1.jpeg"}]
         * currentPage : 1
         * allNum : 5151
         * maxResult : 20
         */

        private PagebeanBean pagebean;

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public PagebeanBean getPagebean() {
            return pagebean;
        }

        public void setPagebean(PagebeanBean pagebean) {
            this.pagebean = pagebean;
        }

        public static class PagebeanBean {
            private int allPages;
            private int currentPage;
            private int allNum;
            private int maxResult;
            /**
             * text :
             深夜来一曲

             * hate : 55
             * videotime : 0
             * voicetime : 0
             * weixin_url : http://m.budejie.com/detail-18914326.html/
             * profile_image : http://qzapp.qlogo.cn/qzapp/100336987/3732B956EAAD56825960F55344A110EE/100
             * width : 0
             * voiceuri :
             * type : 31
             * id : 18914326
             * love : 60
             * height : 0
             * voice_uri : http://mvoice.spriteapp.cn/voice/2016/0614/575f11934dd27.mp3
             * voicelength : 0
             * name :  阿九-
             * create_time : 2016-06-14 07:34:39
             * image3 : http://mpic.spriteapp.cn/crop/566x360/picture/2016/0614/575f119342544.jpg
             */

            private List<ContentlistBean> contentlist;

            public int getAllPages() {
                return allPages;
            }

            public void setAllPages(int allPages) {
                this.allPages = allPages;
            }

            public int getCurrentPage() {
                return currentPage;
            }

            public void setCurrentPage(int currentPage) {
                this.currentPage = currentPage;
            }

            public int getAllNum() {
                return allNum;
            }

            public void setAllNum(int allNum) {
                this.allNum = allNum;
            }

            public int getMaxResult() {
                return maxResult;
            }

            public void setMaxResult(int maxResult) {
                this.maxResult = maxResult;
            }

            public List<ContentlistBean> getContentlist() {
                return contentlist;
            }

            public void setContentlist(List<ContentlistBean> contentlist) {
                this.contentlist = contentlist;
            }

            public static class ContentlistBean {
                private String text;
                private String hate;
                private String videotime;
                private String voicetime;
                private String weixin_url;
                private String profile_image;
                private String width;
                private String voiceuri;
                private String type;
                private String id;
                private String love;
                private String height;
                private String voice_uri;
                private String voicelength;
                private String name;
                private String create_time;
                private String image3;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getHate() {
                    return hate;
                }

                public void setHate(String hate) {
                    this.hate = hate;
                }

                public String getVideotime() {
                    return videotime;
                }

                public void setVideotime(String videotime) {
                    this.videotime = videotime;
                }

                public String getVoicetime() {
                    return voicetime;
                }

                public void setVoicetime(String voicetime) {
                    this.voicetime = voicetime;
                }

                public String getWeixin_url() {
                    return weixin_url;
                }

                public void setWeixin_url(String weixin_url) {
                    this.weixin_url = weixin_url;
                }

                public String getProfile_image() {
                    return profile_image;
                }

                public void setProfile_image(String profile_image) {
                    this.profile_image = profile_image;
                }

                public String getWidth() {
                    return width;
                }

                public void setWidth(String width) {
                    this.width = width;
                }

                public String getVoiceuri() {
                    return voiceuri;
                }

                public void setVoiceuri(String voiceuri) {
                    this.voiceuri = voiceuri;
                }

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

                public String getLove() {
                    return love;
                }

                public void setLove(String love) {
                    this.love = love;
                }

                public String getHeight() {
                    return height;
                }

                public void setHeight(String height) {
                    this.height = height;
                }

                public String getVoice_uri() {
                    return voice_uri;
                }

                public void setVoice_uri(String voice_uri) {
                    this.voice_uri = voice_uri;
                }

                public String getVoicelength() {
                    return voicelength;
                }

                public void setVoicelength(String voicelength) {
                    this.voicelength = voicelength;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getCreate_time() {
                    return create_time;
                }

                public void setCreate_time(String create_time) {
                    this.create_time = create_time;
                }

                public String getImage3() {
                    return image3;
                }

                public void setImage3(String image3) {
                    this.image3 = image3;
                }
            }
        }
    }
}
