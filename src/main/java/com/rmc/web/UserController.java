package com.rmc.web;

import com.rmc.po.User;
import com.rmc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }


    @RequestMapping("/index")
    public ModelAndView login() {
        ModelAndView view =new ModelAndView();
        view.setViewName("forward:/login.jsp");
        return view;
    }

    @RequestMapping("/login/doLogin")
    public ModelAndView doLogin(HttpServletRequest request, User user){
        User dbUser = userService.getUserByUserName(user.getUserName());
        ModelAndView mav = new ModelAndView();
        mav.setViewName("forward:/login.jsp");
        if(dbUser == null){
            mav.addObject("erromsg","用户名不存在");
        }else if(!dbUser.getPassword().equals(user.getPassword())){
            mav.addObject("errormsg","用户密码错误");
        }else{
            mav.setViewName("redirect:/Post.html");
        }
        return mav;
    }

}
