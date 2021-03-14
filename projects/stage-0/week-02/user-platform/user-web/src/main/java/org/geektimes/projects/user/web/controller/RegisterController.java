package org.geektimes.projects.user.web.controller;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.validator.bean.validation.ValidResult;
import org.geektimes.web.mvc.controller.PageController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

public class RegisterController implements PageController {

    @Resource(name = "service/UserService")
    private UserService userService;

    @Resource(name = "valid/ValidResult")
    private ValidResult validResult;

    @GET
    @POST
    @Path("/register")
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {

        // 清空状态
        initValidResult();

        User user = new User();
        // 用户注册信息登入DB
        user.setName(request.getParameter("name"));
        user.setPhoneNumber(request.getParameter("phone"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));

        request.setAttribute("userInfo", user);
        request.setAttribute("result",validResult);

        if (HttpMethod.GET.equals(request.getMethod())) {
            return "register.jsp";
        }

        // 校验邮箱是否已经存在
        if (this.userService.isEmailExisted(user.getEmail())) {
//            System.out.println("邮箱已经存在");
//            request.setAttribute("result",validResult);
            return "register.jsp";
        }

        this.userService.register(user);
        if (validResult.getResultCode() != 0) {
//            request.setAttribute("result", validResult);
            return "register.jsp";
        }

        // 查询登入后的信息
        user = this.userService.queryUserByNameAndPassword(user.getName(), user.getPassword());
        if (user == null) {
            user = new User();
            validResult.setResultCode(-1);
        }
        request.setAttribute("userInfo", user);

        return "register-success.jsp";
    }

    private void initValidResult() {
        validResult.setResultCode(0);
        validResult.getResultMap().clear();
    }
}
