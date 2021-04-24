# 第七周作业状况

[demo-oauth2](https://github.com/ebertGit/geekbang-lessons/tree/master/projects/stage-0/week-07/demo-oauth2) 中使用 Spring Boot OAuth2 来实现了一个用 Github 快捷登录的功能。

## 实现过程

### 1、注册OAuth应用

在GitHub官网上注册一个新的OAuth应用（OAuth Apps） => Settings -> Developer settings -> OAuth Apps

- Application name：MyOAuthApp

- Homepage URL：http://localhost:8080/

- Authorization callback URL：http://localhost:8080/login/oauth2/code/github

  > 注：Spring Security OAuth 默认的重定向模板是{baseUrl}/login/oauth2/code/{registrationId},registrationId是ClientRegistration的唯一ID，通常以接入的OAuth服务提供商的简称来命名即可，所以此处设置为 github。

### 2、配置**application.yml**

在 Spring Boot 工程的 src/main/resources/application.yml 中设置以下内容：

```yaml
spring:
  security:
    oauth2:
      client:
        registration:
          github:
            client-id: your-github-client-id
            client-secret: your-github-client-secret
```

> client-id 和 client-secret 需要替换为前面在 GitHub 上注册得到的 clientId 和 clientSecret 。

### 3、效果演示

启动 Spring Boot 程序 ：

```shell
$ ./mvnw spring-boot:run
```
用浏览器访问`http://localhost:8080/hello`，将会显示 Github 登录页面。



### 参考：

- https://docs.github.com/en/developers/apps/building-oauth-apps
- https://spring.io/guides/tutorials/spring-boot-oauth2/

---

### 作业内容

- 使用 Spring Boot 来实现一个整合Gitee/或者Github OAuth2 认证
    - 最好使用 Servlet 来实现

