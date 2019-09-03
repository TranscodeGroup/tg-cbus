package com.cbus.token;

import com.cbus.utils.TgRole;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 用户认证信息
 * 
 * @author zhen.lin
 * @date 2019年4月28日
 */
public class TokenModel {
    /**
     * 登陆IP
     */
    private String ip;
    /**
     * 用户id
     */
    private String uid;
    /**
     * 账号
     */
    private String account;
    /**
     * 昵称
     */
    private String title;
    /**
     * 当前选中企业编码,默认为用户归属企业编码
     */
    private String cid;
    /**
     * 是否管理员 0=普通用户 1=企业管理 100=超管或系统管理员
     */
    private int ismgr;
    /**
     * 普通用户角色,对应角色表gid
     */
    private String roleid;

    /**
     * key
     */
    private String key;
    /**
     * token
     */
    private String token;
    /**
     * 登陆时间
     */
    private long time;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getIsmgr() {
        return ismgr;
    }

    public void setIsmgr(int ismgr) {
        this.ismgr = ismgr;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    @JsonIgnore
    public TgRole getTgRole() {
        return TgRole.getRole(ismgr);
    }

}
