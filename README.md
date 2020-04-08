# lightrain-spring
使用springboot为轻雨而搭建的后台

# 轻雨（light-rain）文档


```

```



## 用户模块



### 登录



```
GET /lr/user/login
```

参数

```
username=15244482896
password=123456
```

返回

```
{
    "code": 100,
    "msg": "success",
    "data": {
        "username": "15244482896",
        "password": "123456",
        "nickname": "rainner",
        "userGender": 1,
        "userBirthday": "1998-12-10",
        "userAge": 22,
        "userSchool": "sdnu",
        "userStatus": 1
    }
}
```



### 注销

```
GET /lr/user/logout
```

参数

```
username=15244482896
```

返回

```
{
    "code": 100,
    "msg": "success"
}
```



### 注册

```
POST /lr/user/register
```

参数

```
username=13562663180
password=123456
nickName=dad
userIcon=http://zt-data.test.upcdn.net/icon.jpg
userGender=1
userBirthday=1976-1-1
userSchool=StayHome
```

返回

```
{
    "code": 100,
    "msg": "success",
    "data": {
        "username": "13562663180",
        "password": "123456",
        "nickname": "dad",
        "userIcon": "http://zt-data.test.upcdn.net/icon.jpg",
        "userGender": 1,
        "userBirthday": "1976-1-1",
        "userAge": 44,
        "userSchool": "StayHome",
        "userStatus": 0
    }
}
```



### 更新

```
POST /lr/user/update
```

参数：

```
username=13562663180
password=123456
nickName=dad
userIcon=http://zt-data.test.upcdn.net/icon.jpg
userGender=1
userBirthday=1976-10-1
userSchool=StayHome
```

返回

```
{
    "code": 100,
    "msg": "success"
}
```





### 获取用户信息

```
GET /lr/user/info
```

参数：

```
username=15244482896
```

返回

```
{
    "code": 100,
    "msg": "success",
    "data": {
        "username": "15244482896",
        "password": "e10adc3949ba59abbe56e057f20f883e",
        "nickname": "落花丿飞雪",
        "userIcon": "http://zt-data.test.upcdn.net//uploads/15244482896/icon/20200403/gge7yn6zr452kfdee0qepjsieq04xx8d",
        "userGender": 1,
        "userBirthday": "1997-10-22",
        "userAge": 23,
        "userSchool": "山东师范大学",
        "userStatus": 1,
        "userSign": "平平淡淡才是真",
        "userLocation": "山东省-济南市",
        "userIdentity": 2
    }
}
```

### 获取用户关系（粉丝、关注、收藏列表）

```
POST /lr/user/relationship/info
```

参数：

```
username=15244482896
```

返回

```
{
    "code": 100,
    "msg": "success",
    "data": {
        "username": "15244482896",
        "userFans": "18340096978;18340091098",
        "userFansNum": 0,
        "userFollows": "18340096978;18340091098",
        "userFollowsNum": 0,
        "userIntegral": 0,
        "userFavourites": "1586222544066616229"
    }
}
```

### 更新用户关系（粉丝、关注、收藏列表）

```
POST /lr/user/relationship/update
```

参数：

```
username=15244482896
userFans=18340096978
userFansNum=1
userFollows=18340096978
userFollowsNum=1
userIntegral=0
userFavourites=1586222544066616229
```

返回

```
{
    "code": 100,
    "msg": "success",
    "data": {
        "username": "15244482896",
        "userFans": "18340096978",
        "userFansNum": 1,
        "userFollows": "18340096978",
        "userFollowsNum": 1,
        "userIntegral": 0,
        "userFavourites": "1586222544066616229"
    }
}
```







## 视频模块



### 获取指定视频信息

```
GET /lr/video/info
```

参数

```
videoId=1586222544066616229
```

返回

```
{
    "code": 100,
    "msg": "success",
    "data": {
        "videoId": "1586222544066616229",
        "username": "10000000000",
        "videoTitle": "这就是我-七年级上",
        "videoBrief": "刚入初中，面对新老师、新同学，来一番自我介绍。要抓住自己的主要特征、兴趣、爱好等，用第一人称将自己的自画像描绘出来，尽量做到文笔生动活泼",
        "videoScoreAva": "10.0",
        "videoTime": "2021",
        "videoPrice": "9.9",
        "videoLearningNum": "0",
        "videoIcon": "http://zt-data.test.upcdn.net/cover/composition/composition_grade_seven_up1.png",
        "videoUrl": "http://zt-data.test.upcdn.net/video/composition/composition_grade_seven_up1.avi",
        "videoLabel": "作文;七年级"
    }
}
```



### 获取全部视频

```
POST /lr/info/all
```

参数：

```
无
```

返回

```
{
    "code": 100,
    "msg": "success",
    "data": [
        {
            "videoId": "1586222544066616229",
            "username": "10000000000",
            "videoTitle": "这就是我-七年级上",
            "videoBrief": "刚入初中，面对新老师、新同学，来一番自我介绍。要抓住自己的主要特征、兴趣、爱好等，用第一人称将自己的自画像描绘出来，尽量做到文笔生动活泼",
            "videoScoreAva": "10.0",
            "videoTime": "2021",
            "videoPrice": "9.9",
            "videoLearningNum": "0",
            "videoIcon": "http://zt-data.test.upcdn.net/cover/composition/composition_grade_seven_up1.png",
            "videoUrl": "http://zt-data.test.upcdn.net/video/composition/composition_grade_seven_up1.avi",
            "videoLabel": "作文;七年级"
        },
        {
            "videoId": "1586222616454481924",
            "username": "10000000000",
            "videoTitle": "漫游语文世界-七年级上",
            "videoBrief": "漫游语文世界，能让我感受到了语文的无穷魅力",
            "videoScoreAva": "10.0",
            "videoTime": "1293",
            "videoPrice": "9.9",
            "videoLearningNum": "0",
            "videoIcon": "http://zt-data.test.upcdn.net/cover/composition/composition_grade_seven_up2.png",
            "videoUrl": "http://zt-data.test.upcdn.net/video/composition/composition_grade_seven_up2.avi",
            "videoLabel": "作文;七年级"
        },
        {
            "videoId": "1586222628305190790",
            "username": "10000000000",
            "videoTitle": "成长的烦恼-七年级下",
            "videoBrief": "成长的烦恼让我总是在想:我小的时候不是老是向往着当一个大人吗?为什么现在你却是这番样子呢?",
            "videoScoreAva": "10.0",
            "videoTime": "1594",
            "videoPrice": "9.9",
            "videoLearningNum": "0",
            "videoIcon": "http://zt-data.test.upcdn.net/cover/composition/composition_grade_seven_down1.png",
            "videoUrl": "http://zt-data.test.upcdn.net/video/composition/composition_grade_seven_down1.avi",
            "videoLabel": "作文;七年级"
        }
     ]
}
```



### 更新视频（上传、改参等）

```
POST /lr/update
```

参数：

```
videoId=1586222628305190790
username=10000000000
videoTitle=成长的烦恼-七年级下
videoBrief=成长的烦恼让我总是在想:我小的时候不是老是向往着当一个大人吗?为什么现在你却是这番样子呢?
videoScoreAva=10.0
videoTime=1594
videoPrice=9.9
videoLearningNum=0
videoIcon=http://zt-data.test.upcdn.net/cover/composition/composition_grade_seven_down1.png
videoUrl=http://zt-data.test.upcdn.net/video/composition/composition_grade_seven_down1.avi
videoLabel=作文;七年级
```

返回

```
{
    "code": 100,
    "msg": "success"
}
```



------



### 获取用户观看指定视频时长和最近观看时间

```
GET /lr/video/uv/get
```

参数：

```
videoId=1586222644692930628
username=15244482896
```

返回

```
{
    "code": 100,
    "msg": "success",
    "data": {
        "username": "15244482896",
        "videoId": "1586222644692930628",
        "videoProgress": 101,
        "videoTimeLearning": "2020-04-08T15:38:49.000+0000"
    }
}
```





### 更新用户观看视频信息（增添或者修改）

```
POST /lr/video/uv/update
```

参数：

```
videoId=1586222644692930628
username=15244482896
videoProgress=99
```

返回

```
{
    "code": 100,
    "msg": "success",
    "data": {
        "username": "15244482896",
        "videoId": "1586222644692930628",
        "videoProgress": 99,
        "videoTimeLearning": "2020-04-08T15:41:43.000+0000"
    }
}
```





### 获取指定用户的观看视频列表

```
GET /lr/video/uv/get/all/user
```

参数：

```
username=15244482896
```

返回

```
{
    "code": 100,
    "msg": "success",
    "data": [
        {
            "username": "15244482896",
            "videoId": "1586222544066616229",
            "videoProgress": 122,
            "videoTimeLearning": "2020-04-08T15:17:43.000+0000"
        },
        {
            "username": "15244482896",
            "videoId": "1586222644692930628",
            "videoProgress": 99,
            "videoTimeLearning": "2020-04-08T15:41:43.000+0000"
        }
    ]
}
```





### 获取指定视频的观看用户列表

```
GET /lr/video/uv/get/all/video
```

参数：

```
videoId=1586222544066616229
```

返回

```
{
    "code": 100,
    "msg": "success",
    "data": [
        {
            "username": "15244482896",
            "videoId": "1586222544066616229",
            "videoProgress": 122,
            "videoTimeLearning": "2020-04-08T15:17:43.000+0000"
        }
    ]
}
```



------



### 增加用户对指定视频的评分

```
POST /lr/video/evaluate/update
```

参数：

```
videoId=1586222644692930628
username=15244482896
videoScore=9
VideoEvaluateDetail=非常喜欢这个视频！！
```

返回

```
{
    "code": 100,
    "msg": "success",
    "data": {
        "videoId": "1586222644692930628",
        "username": "15244482896",
        "videoScore": "9",
        "videoEvaluateDetail": "非常喜欢这个视频！！"
    }
}
```





### 获取指定视频的用户评价列表

```
GET /lr/video/evaluate/get/video
```

参数：

```
videoId=1586222644692930628
```

返回

```
{
    "code": 100,
    "msg": "success",
    "data": [
        {
            "videoId": "1586222644692930628",
            "username": "15244482896",
            "videoScore": "9",
            "videoEvaluateDetail": "非常喜欢这个视频！！"
        }
    ]
}
```





### 获取用户的评价过视频列表

```
GET /lr/video/evaluate/get/user
```

参数：

```
username=15244482896
```

返回

```
{
    "code": 100,
    "msg": "success",
    "data": [
        {
            "videoId": "1586222644692930628",
            "username": "15244482896",
            "videoScore": "9",
            "videoEvaluateDetail": "非常喜欢这个视频！！"
        }
    ]
}
```



------



### 搜索匹配——标签

```
GET /lr/video/match/label
```

参数：

```
videoLabel=化学
```

返回

```
{
    "code": 100,
    "msg": "success",
    "data": [
        {
            "videoId": "1586224145897916412",
            "username": "10000000008",
            "videoTitle": "化学是一门以实验为基础的科学-九年级上",
            "videoBrief": "为大家提供化学是一门以实验为基础的初中教案相关内容",
            "videoScoreAva": 10.0,
            "videoTime": 812,
            "videoPrice": 0.0,
            "videoLearningNum": 0,
            "videoIcon": "http://zt-data.test.upcdn.net/cover/chemistry/chemistry_grade_nine_up0.png",
            "videoUrl": "http://zt-data.test.upcdn.net/video/chemistry/chemistry_grade_nine_up1.avi",
            "videoLabel": "化学;九年级"
        },
        {
            "videoId": "1586224152938714094",
            "username": "10000000008",
            "videoTitle": "走进化学实验室-九年级上",
            "videoBrief": "认识学习化学的一个重要途径是实验，初步学会对实验现象进行观察和描述的方法。",
            "videoScoreAva": 10.0,
            "videoTime": 1106,
            "videoPrice": 39.9,
            "videoLearningNum": 0,
            "videoIcon": "http://zt-data.test.upcdn.net/cover/chemistry/chemistry_grade_nine_up2.png",
            "videoUrl": "http://zt-data.test.upcdn.net/video/chemistry/chemistry_grade_nine_up2.avi",
            "videoLabel": "化学;九年级"
        },
        {
            "videoId": "1586224159323712872",
            "username": "10000000008",
            "videoTitle": "燃烧条件的探究-九年级下",
            "videoBrief": "认识燃烧;知道燃烧和燃烧的条件;能利用燃烧条件解释一些日常生活中的现象.",
            "videoScoreAva": 10.0,
            "videoTime": 319,
            "videoPrice": 39.9,
            "videoLearningNum": 0,
            "videoIcon": "http://zt-data.test.upcdn.net/cover/chemistry/chemistry_grade_nine_down1.png",
            "videoUrl": "http://zt-data.test.upcdn.net/video/chemistry/chemistry_grade_nine_down1.avi",
            "videoLabel": "化学;九年级"
        },
        {
            "videoId": "1586224169808317078",
            "username": "10000000008",
            "videoTitle": "白磷的自然现象-九年级下",
            "videoBrief": "白磷为白色蜡状固体，遇光会逐渐变为淡黄色晶体（所以又称为黄磷），有大蒜的气味，有毒。着火点很低，能自燃，在空气中发光。",
            "videoScoreAva": 10.0,
            "videoTime": 367,
            "videoPrice": 39.9,
            "videoLearningNum": 0,
            "videoIcon": "http://zt-data.test.upcdn.net/cover/chemistry/chemistry_grade_nine_down2.png",
            "videoUrl": "http://zt-data.test.upcdn.net/video/chemistry/chemistry_grade_nine_down2.avi",
            "videoLabel": "化学;九年级"
        }
    ]
}
```





### 搜索匹配——教师ID

```
GET /lr/video/match/teacher
```

参数：

```
username=10000000008
```

返回

```
{
    "code": 100,
    "msg": "success",
    "data": [
        {
            "videoId": "1586224145897916412",
            "username": "10000000008",
            "videoTitle": "化学是一门以实验为基础的科学-九年级上",
            "videoBrief": "为大家提供化学是一门以实验为基础的初中教案相关内容",
            "videoScoreAva": 10.0,
            "videoTime": 812,
            "videoPrice": 0.0,
            "videoLearningNum": 0,
            "videoIcon": "http://zt-data.test.upcdn.net/cover/chemistry/chemistry_grade_nine_up0.png",
            "videoUrl": "http://zt-data.test.upcdn.net/video/chemistry/chemistry_grade_nine_up1.avi",
            "videoLabel": "化学;九年级"
        },
        {
            "videoId": "1586224152938714094",
            "username": "10000000008",
            "videoTitle": "走进化学实验室-九年级上",
            "videoBrief": "认识学习化学的一个重要途径是实验，初步学会对实验现象进行观察和描述的方法。",
            "videoScoreAva": 10.0,
            "videoTime": 1106,
            "videoPrice": 39.9,
            "videoLearningNum": 0,
            "videoIcon": "http://zt-data.test.upcdn.net/cover/chemistry/chemistry_grade_nine_up2.png",
            "videoUrl": "http://zt-data.test.upcdn.net/video/chemistry/chemistry_grade_nine_up2.avi",
            "videoLabel": "化学;九年级"
        },
        {
            "videoId": "1586224159323712872",
            "username": "10000000008",
            "videoTitle": "燃烧条件的探究-九年级下",
            "videoBrief": "认识燃烧;知道燃烧和燃烧的条件;能利用燃烧条件解释一些日常生活中的现象.",
            "videoScoreAva": 10.0,
            "videoTime": 319,
            "videoPrice": 39.9,
            "videoLearningNum": 0,
            "videoIcon": "http://zt-data.test.upcdn.net/cover/chemistry/chemistry_grade_nine_down1.png",
            "videoUrl": "http://zt-data.test.upcdn.net/video/chemistry/chemistry_grade_nine_down1.avi",
            "videoLabel": "化学;九年级"
        },
        {
            "videoId": "1586224169808317078",
            "username": "10000000008",
            "videoTitle": "白磷的自然现象-九年级下",
            "videoBrief": "白磷为白色蜡状固体，遇光会逐渐变为淡黄色晶体（所以又称为黄磷），有大蒜的气味，有毒。着火点很低，能自燃，在空气中发光。",
            "videoScoreAva": 10.0,
            "videoTime": 367,
            "videoPrice": 39.9,
            "videoLearningNum": 0,
            "videoIcon": "http://zt-data.test.upcdn.net/cover/chemistry/chemistry_grade_nine_down2.png",
            "videoUrl": "http://zt-data.test.upcdn.net/video/chemistry/chemistry_grade_nine_down2.avi",
            "videoLabel": "化学;九年级"
        }
    ]
}
```











##错误码

```
	LOGIN_FAILED(110,"登陆失败，请检查账户或密码是否填写正确"),
    USER_NO_LOGIN(111,"用户尚未登陆，请先登录"),
    LOGOUT_FAILED(112,"注销失败，您已注销"),
    REGISTER_FAILED(113,"注册失败，该号码已注册，请去登录"),
    REGISTER_FAILED_BY_PARAM(114,"注册失败，该号码已注册，请去登录"),
    UPDATE_FAILED(115,"更新个人信息失败，请仔细检查传递参数"),
    LOGIN_REPEAT(116,"已登录，请勿重复登陆"),
    UPDATE_USER_RELATIONSHIP_FAILED(117,"更新用户关系失败"),
    GET_USER_RELATIONSHIP_FAILED(118,"获取用户关系失败"),
    USER_EXITS(119,"用户已存在，请勿重复注册"),
    UPDATE_VIDEO_FAILED(200,"上传视频失败"),
    UPDATE_VIDEO_EVALUATE_FAILED(201,"更新用户视频评分失败"),
    VIDEO_EVALUATE_EXITS(202,"用户已评价，请勿重复评价"),
    UPDATE_UV_FAILED(202,"尚未购买，请先去购买"),
    VIDEO_TIME_ERROR(203,"传递用户观看时长错误"),
    MATCH_FAILED(300,"无搜索结果")
```






