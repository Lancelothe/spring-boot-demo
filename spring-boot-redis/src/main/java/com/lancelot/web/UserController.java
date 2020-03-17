package com.lancelot.web;

import com.lancelot.model.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @author lancelot
 * @date 2020/3/2
 */
@RestController
public class UserController {

    @GetMapping("/getUser")
    @Cacheable(value = "user-key", key = "#id")
    public User getUser(Long id) {
        User user = new User(id, "aa@126.com", "aa", "aa123456", "aa", "123");
        System.out.println("缓存成功，只调用一次，下一次走缓存");
        return user;
    }

    @GetMapping("/updateUser")
    @CachePut(value = "user-key", key = "#id")
    public User updateUser(Long id) {
        User user = new User(id, "bb@126.com", "aa", "aa123456", "aa", "123");
        System.out.println("更新成功");
        return user;
    }

    @GetMapping("/delUser")
    @CacheEvict(value = "user-key", key = "#id")
    public String delUser(Long id) {
        String result = "删除成功";
        System.out.println(result);
        return result;
    }

    @GetMapping("/delAll")
    @CacheEvict(value = "user-key", allEntries = true)
    public String delAll(Long id) {
        String result = "全部删除成功";
        System.out.println(result);
        return result;
    }

    @GetMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }
}
