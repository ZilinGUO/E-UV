
package com.rmc.service;

import com.rmc.dao.PostDao;
import com.rmc.po.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private PostDao postDao;

    @Autowired
    public void setPostDao(PostDao postDao){
        this.postDao = postDao;
    }

    public List<Post> getAllPosts(){
        return postDao.loadAll();
    }
}
