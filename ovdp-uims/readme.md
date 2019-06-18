# 用户信息管理系统
包括
1. RBAC信息管理
2. oauth2登录授权
3. sso登录

# 启动

数据库初始化语句存放在db/目录

运行类com.ov.dp.uims.UimsApplication，启动完成后访问http://localhost:8080/uims

# token使用方法


1. 获取token

post http://localhost:8080/uims/oauth/token?grant_type=password&username=admin&password=admin&client_id=uims&client_secret=admin

```
{
    "access_token": "77e14829-071e-4189-98de-fada7e390058",
    "token_type": "bearer",
    "expires_in": 43199,
    "scope": "uims"
}
```

2. 查看用户信息

get http://localhost:8080/uims/principal?access_token=77e14829-071e-4189-98de-fada7e390058

```
{
    "authorities": [],
    "details": {
        ...
    },
    "authenticated": true,
    "userAuthentication": {
        ...
    },
    "clientOnly": false,
    "principal": {
        ...
    },
    "oauth2Request": {
        ...
    },
    "credentials": "",
    "name": "admin"
}
```

3. 访问api
