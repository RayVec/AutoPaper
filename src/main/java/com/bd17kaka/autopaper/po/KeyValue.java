package com.bd17kaka.autopaper.po;

import java.util.Date;

public class KeyValue {
	
	/** 忘记密码 */
	public final static String PRE_FORGET_PASSWORD = "FORGET_PASSWORD";
	/** 邮箱激活 */
	public final static String PRE_VERIFY_MAILBOX = "VERIFY_MAILBOX";
	
    private Long id;

    private String key1;

    private String value1;

    private String pre;

    private Date gmtCreated;

    private Date gmtExpired;

    private Long ttl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1 == null ? null : key1.trim();
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1 == null ? null : value1.trim();
    }

    public String getPre() {
        return pre;
    }

    public void setPre(String pre) {
        this.pre = pre == null ? null : pre.trim();
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtExpired() {
        return gmtExpired;
    }

    public void setGmtExpired(Date gmtExpired) {
        this.gmtExpired = gmtExpired;
    }

    public Long getTtl() {
        return ttl;
    }

    public void setTtl(Long ttl) {
        this.ttl = ttl;
    }
}