package com.cbus.token;

import java.util.List;

/**
 * 用户认证信息
 * 
 * @author zhen.lin
 * @date 2019年4月28日
 */
public class TokenModel {

    // 用户id
    private String uid;
    // 账号
    private String account;
    // 名称
    private String title;
    // cid
    private String cid;
    // key
    private String key;
    // 身份token
    private String token;
    // 是否管理 0=普通用户 1=企业管理 100=超管
    private int ismgr;
    // login 时间
    private long time;
    // login ip
    private String ip;
    // 权限
    private List<ModelAndPerm> perm;

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

    public List<ModelAndPerm> getPerm() {
        return perm;
    }

    public void setPerm(List<ModelAndPerm> perm) {
        this.perm = perm;
    }

}
