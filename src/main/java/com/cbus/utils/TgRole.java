package com.cbus.utils;

/**
 * 中车自定义角色
 * 
 * @author eason
 * @date 2019/08/22
 */
public enum TgRole {
    /**
     * 普通用户
     */
    ROLE_USER(0, "user"),

    /**
     * 企业管理员
     */
    ROLE_ADMIN(1, "admin"),

    /**
     * 系统管理员
     */
    ROLE_SYSADMIN(100, "sysadmin");

    /**
     * 角色id
     */
    private int role;
    /**
     * 描述
     */
    private String describe;

    TgRole(int role, String describe) {
        this.role = role;
        this.describe = describe;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
    
    public int val() {
        return role;
    }

    public static TgRole getRole(int id) {
        TgRole[] value = values();
        for (TgRole tgRole : value) {
            if (tgRole.getRole() == id) {
                return tgRole;
            }
        }
        return null;
    }

}
