# 第八周作业状况

努力完成中...

---

### 作业内容

如何解决多个 WebSecurityConfigurerAdapter Bean 配置相 互冲突的问题?

提示:假设有两个 WebSecurityConfigurerAdapter Bean 定 义，并且标注了不同的 @Order，其中一个关闭 CSRF，一个 开启 CSRF，那么最终结果如何确定?

背景:Spring Boot 场景下，自动装配以及自定义 Starter 方 式非常流行，部分开发人员掌握了 Spring Security 配置方 法，并且自定义了自己的实现，解决了 Order 的问题，然而 会出现不确定配置因素。