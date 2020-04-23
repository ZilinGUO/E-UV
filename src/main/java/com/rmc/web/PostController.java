package com.rmc.web;

import com.rmc.po.Post;
import com.rmc.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PostController {

    private PostService postService;

    @Autowired
    public void setPostService(PostService postService){
        this.postService = postService;
    }

    /**
     * 列出所有的论坛模块
     * @return
     */
    @RequestMapping("/Post")
    public ModelAndView listAllPost() {
        ModelAndView view =new ModelAndView();
        List<Post> posts = postService.getAllPosts();
        view.addObject("posts", posts);
        view.setViewName("/listAllPosts");
        return view;
    }

}
