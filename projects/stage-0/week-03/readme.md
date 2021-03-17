# 第三周作业状况

1. 整合jolokia, 通过 Jolokia 做 Servlet 代理
  - 实现方法：
    - pom.xml中添加 jolokia-core 和 jolokia-client-java 的依赖包
    - web.xml中添加以下内容
```xml
    <servlet>
        <servlet-name>jolokia-agent</servlet-name>
        <servlet-class>org.jolokia.http.AgentServlet</servlet-class>
        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>jolokia-agent</servlet-name>
        <url-pattern>/jolokia/*</url-pattern>
    </servlet-mapping>
```
  - 可通过以下方法验证：
    - 启动工程，通过浏览器访问以下URL，返回json。
      - http://localhost:8080/jolokia/
    - 启动工程，执行以下Demo中的main函数，返回当前堆内存使用量。
      - src/test/java/org/geektimes/jmx/demo/JolokiaDemo.java

2. 实现一个自定义 JMX MBean
  - 未实现，实现方法学习中。。。

---
### 作业内容
- 需求一(必须)
  - 整合 https://jolokia.org/
    - 实现一个自定义 JMX MBean，通过 Jolokia 做 Servlet 代理
- 需求二(选做)
  - 继续完成 Microprofile config API 中的实现
    - 扩展org.eclipse.microprofile.config.spi.ConfigSource 实现，包括 OS 环境变量，以及本地配置文件
    - 扩展 org.eclipse.microprofile.config.spi.Converter 实现，提供 String 类型到简单类型
  - 通过 org.eclipse.microprofile.config.Config 读取当前 应用名称
    - 应用名称 property name = "application.name"
