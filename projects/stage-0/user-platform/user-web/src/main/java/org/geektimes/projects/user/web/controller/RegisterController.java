package org.geektimes.projects.user.web.controller;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.service.UserServiceImpl;
import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

public class RegisterController implements PageController {

    private UserService userService = new UserServiceImpl();
    @GET
    @POST
    @Path("/register")
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {

        if (HttpMethod.GET.equals(request.getMethod())) {
            return "register.jsp";
        }

        String email = request.getParameter("email");
        // 校验邮箱是否已经存在
        if (this.userService.emailExisted(email)) {
            System.out.println("邮箱已经存在");
            request.setAttribute("email_existed", true);
            return "register.jsp";
        }

        // 用户注册信息登入DB
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setPhoneNumber(request.getParameter("phone"));
        user.setEmail(email);
        user.setPassword(request.getParameter("password"));

        if (!this.userService.register(user)) {
            request.setAttribute("result", false);
            return "register.jsp";
        }

        request.setAttribute("userInfo", user);

        return "register-success.jsp";
    }
}
