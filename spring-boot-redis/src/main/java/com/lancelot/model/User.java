package com.lancelot.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lancelot
 * @date 2020/3/2
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String userName;
    private String password;
    private String email;
    private String nickname;
    private String regTime;

    public User() {
    }

    public User(Long id, String userName, String password, String email, String nickname, String regTime) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.regTime = regTime;
    }
}
