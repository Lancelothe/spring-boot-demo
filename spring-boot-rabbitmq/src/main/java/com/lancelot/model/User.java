package com.lancelot.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lancelot
 * @date 2020/3/2
 */
@Data
public class User implements Serializable {
    private String name;

    private String pass;
}
