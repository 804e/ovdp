# ovdp-ms-gateway 微服务网关

微服务网关


### 查看已经加载的路由
http://localhost/actuator/gateway/routes

```
[{"route_id":"CompositeDiscoveryClient_CLIENT-DEMO","route_definition":{"id":"CompositeDiscoveryClient_CLIENT-DEMO","predicates":[{"name":"Path","args":{"pattern":"/client-demo/**"}}],"filters":[{"name":"RewritePath","args":{"regexp":"/client-demo/(?<remaining>.*)","replacement":"/${remaining}"}}],"uri":"lb://CLIENT-DEMO","order":0},"order":0},{"route_id":"CompositeDiscoveryClient_GATEWAY","route_definition":{"id":"CompositeDiscoveryClient_GATEWAY","predicates":[{"name":"Path","args":{"pattern":"/gateway/**"}}],"filters":[{"name":"RewritePath","args":{"regexp":"/gateway/(?<remaining>.*)","replacement":"/${remaining}"}}],"uri":"lb://GATEWAY","order":0},"order":0},{"route_id":"CompositeDiscoveryClient_UIMS","route_definition":{"id":"CompositeDiscoveryClient_UIMS","predicates":[{"name":"Path","args":{"pattern":"/uims/**"}}],"filters":[{"name":"RewritePath","args":{"regexp":"/uims/(?<remaining>.*)","replacement":"/${remaining}"}}],"uri":"lb://UIMS","order":0},"order":0},{"route_id":"test_route","route_definition":{"id":"test_route","predicates":[{"name":"Path","args":{"_genkey_0":"/uims/**"}}],"filters":[],"uri":"lb://uims","order":0},"order":0},{"route_id":"test_eureka","route_definition":{"id":"test_eureka","predicates":[{"name":"Path","args":{"_genkey_0":"/uims2222/**"}}],"filters":[],"uri":"http://localhost:8080","order":0},"order":0}]
```