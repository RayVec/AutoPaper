package com.bd17kaka.autopaper.po;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class User implements Serializable {
	
	public interface CREATE{};
	public interface UPDATE{};
	public interface LOGIN{};
	public interface VERIFY_RESET_PASSWORD_CODE{};
	public interface RESET_PASSWORD{};
	
	public final static Short EMAIL_VERIFY = 1;
	public final static Short EMAIL_NOT_VERIFY = 0;
	
	/** 商户 */
	public final static Short USER_TYPE_MERCHANT = 1;
	/** 开发者 */
	public final static Short USER_TYPE_DEVELOPER = 2;
	/** 顾问 */
	public final static Short USER_TYPE_CONSULTANT = 3;
	
    private Long id;

	@NotBlank(message = "用户名称不能为空", groups = {CREATE.class, LOGIN.class})
    @Size(min=6, max=32, message = "名字长度必须在6和32之间", groups = {CREATE.class, LOGIN.class})
    private String name;

	@NotBlank(message = "邮件地址不能为空", groups = {CREATE.class, VERIFY_RESET_PASSWORD_CODE.class})
    @Size(max=1024, message = "邮件地址不能大于1024个字符", groups = {CREATE.class, VERIFY_RESET_PASSWORD_CODE.class})
    private String email;

    private Short emailVerify;

    @NotBlank(message = "密码不能为空", groups = {CREATE.class, LOGIN.class, RESET_PASSWORD.class})
    @Size(min=6, max=16, message = "密码长度必须在8和16之间", groups = {CREATE.class, LOGIN.class, RESET_PASSWORD.class})
    private String password;
    
    private Short type;

    private String avatarUrl;

    private Date gmtCreated;

    private Date gmtUpdated;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Short getEmailVerify() {
        return emailVerify;
    }

    public void setEmailVerify(Short emailVerify) {
        this.emailVerify = emailVerify;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }
    
    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtUpdated() {
        return gmtUpdated;
    }

    public void setGmtUpdated(Date gmtUpdated) {
        this.gmtUpdated = gmtUpdated;
    }
}