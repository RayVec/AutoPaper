package com.bd17kaka.autopaper.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.bd17kaka.autopaper.utils.MD5Util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Random on 2017/3/26.
 */

@Component
public class Configure {

    /**
     * static 变量，使用 @Value 从配置文件取值的时候，必须添加 set 方法，将 @Value 注解写在 set 方法上面
     */

    /**
     * SendGrid apikey
     */
    public static String API_KEY;

    /**
     * 邮箱认证模板ID
     */
    public static String MAILBOX_AUTHENTICATION_TEMPLATE_ID = "662298cf-fed0-442a-b95e-fc23dcb9002a";

    /**retrievePassword
     * 邮箱认证模板ID
     */
    public static String RETRIEVE_PASSWORD_TEMPLATE_ID = "662298cf-fed0-442a-b95e-fc23dcb9002a";

    /**
     * 服务名称，比如 freelancer
     */
    public static String PROJECT_NAME = "fl";


    /**
     * 注册等邮件，发件人名称
     */
    public static String MAIL_SENDER_NAME = "Surport";

    /**
     * 注册等邮件，发件人地址
     */
    public static String MAIL_SENDER_ADDRESS = "surport@fl.com";

    /**
     * HOST
     */
    public final static String HOST = "http://localhost:8080";

    /**
     * 文件上传保存路径
     */
    public static String File_SAVE_PATH = "F:/data/user/doc/";

    @Value("${sendgrid.apiKey}")
    public void setApiKey(String apiKey) {
        API_KEY = apiKey;
    }

    @Value("${sendgrid.mailSenderAddress}")
    public static void setMailSenderAddress(String mailSenderAddress) {
        MAIL_SENDER_ADDRESS = mailSenderAddress;
    }

    @Value("${sendgrid.mailSenderName}")
    public static void setMailSenderName(String mailSenderName) {
        MAIL_SENDER_NAME = mailSenderName;
    }

    @Value("${sendgrid.mailboxAuthenticationTemplateId}")
    public static void setMailboxAuthenticationTemplateId(String mailboxAuthenticationTemplateId) {
        MAILBOX_AUTHENTICATION_TEMPLATE_ID = mailboxAuthenticationTemplateId;
    }

    @Value("${sendgrid.retrievePasswordTemplateId}")
    public static void setRetrievePasswordTemplateId(String retrievePasswordTemplateId) {
        RETRIEVE_PASSWORD_TEMPLATE_ID = retrievePasswordTemplateId;
    }

    @Value("${file.savePath}")
    public static void setFileSavePath(String fileSavePath) {
        File_SAVE_PATH = fileSavePath;
    }
}
