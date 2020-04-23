
package com.rmc.dao;

import com.rmc.po.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao extends BaseDao<User> {
    private static final String GET_USER_BY_NAME = "from User u where u.userName = ?";


    public User getUserByUserName(String userName) {
        List<User> users = (List<User>) getHibernateTemplate().find(GET_USER_BY_NAME, userName);
        if (users.size() == 0) {
            return null;
        } else {
            return users.get(0);
        }
    }
}