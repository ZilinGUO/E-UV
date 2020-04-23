
package com.rmc.dao;


import com.rmc.po.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDao extends BaseDao<Post> {

    private static final String GET_POST_BY_NAME = "from Post p where p.post";

    public Post getPostByName(String postName){
        List<Post> posts = (List<Post>)getHibernateTemplate().find(GET_POST_BY_NAME,postName);
        if(posts.size()==0){
            return null;
        }else{
            return posts.get(0);
        }
    }


}