> requirejs+bootstrap+codemirror

这个项目使用了requirejs，bootstrap和codemirror, 户可以使用比较漂亮的编辑器去编写代码

> spring-cloud-xxx

以下项目演示如何使用springcloud构建自己的微服务平台

- spring-cloud-eureka 启动一个eureka服务注册中心
- spring-cloud-eureka-client 启动一个eureka服务提供者
- spring-cloud-service-consumer 使用ribbon实现客户端路由功能
- spring-cloud-hystrix-dashboard 这个项目(spring-cloud-service-consumer)开启了熔断保护，因此可以通过dashboard来查看服务的健康状况
- spring-cloud-feigin 这个项目使用feign演示ribbon以及hystrix熔断功能，feigin是对ribbon和hystrix的一个高层次封装
