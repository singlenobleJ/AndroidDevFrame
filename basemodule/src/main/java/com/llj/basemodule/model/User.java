package com.llj.basemodule.model;

import java.io.Serializable;

/**
 * <pre>
 *     author: lilinjie
 *     time  : 2018/12/5 14:27
 *     desc  :
 * </pre>
 */
public class User implements Serializable {

    private String id;
    private String token;
    private String name;
    private String avatar;
    private boolean login;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", login=" + login +
                '}';
    }

    public void reset() {
        this.id = "";
        this.name = "";
        this.avatar = "";
        this.login = false;
    }
}
