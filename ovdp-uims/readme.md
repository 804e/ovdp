用户信息管理系统，包括
1. RBAC信息管理
2. oauth2登录授权
3. sso登录

数据库初始化语句存放在db/目录

1. 获取token

post http://localhost:8080/uims/oauth/token?grant_type=password&username=admin&password=fdsajkl;&client_id=uims&client_secret=fdsajkl;

返回
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
        "remoteAddress": "0:0:0:0:0:0:0:1",
        "sessionId": null,
        "tokenValue": "77e14829-071e-4189-98de-fada7e390058",
        "tokenType": "Bearer",
        "decodedDetails": null
    },
    "authenticated": true,
    "userAuthentication": {
        "authorities": [],
        "details": {
            "client_secret": "fdsajkl;",
            "grant_type": "password",
            "client_id": "uims",
            "username": "admin"
        },
        "authenticated": true,
        "principal": {
            "password": null,
            "username": "admin",
            "authorities": [],
            "accountNonExpired": true,
            "accountNonLocked": true,
            "credentialsNonExpired": true,
            "enabled": true
        },
        "credentials": null,
        "name": "admin"
    },
    "clientOnly": false,
    "principal": {
        "password": null,
        "username": "admin",
        "authorities": [],
        "accountNonExpired": true,
        "accountNonLocked": true,
        "credentialsNonExpired": true,
        "enabled": true
    },
    "oauth2Request": {
        "clientId": "uims",
        "scope": [
            "uims"
        ],
        "requestParameters": {
            "grant_type": "password",
            "client_id": "uims",
            "username": "admin"
        },
        "resourceIds": [],
        "authorities": [],
        "approved": true,
        "refresh": false,
        "redirectUri": null,
        "responseTypes": [],
        "extensions": {},
        "grantType": "password",
        "refreshTokenRequest": null
    },
    "credentials": "",
    "name": "admin"
}
```

3. 访问api