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





##错误码

```
LOGIN_FAILED(10,"登陆失败，请检查账户或密码是否填写正确"),
USER_NO_LOGIN(11,"用户尚未登陆，请先登录"),
LOGOUT_FAILED(12,"注销失败，您已注销"),
REGISTER_FAILED(13,"注册失败，该号码已注册，请去登录"),
REGISTER_FAILED_BY_PARAM(14,"注册失败，该号码已注册，请去登录"),
UPDATE_FAILED(15,"更新个人信息失败，请仔细检查传递参数");
```



