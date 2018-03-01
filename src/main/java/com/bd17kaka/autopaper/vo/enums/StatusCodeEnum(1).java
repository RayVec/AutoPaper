package com.bd17kaka.autopaper.vo.enums;

public enum StatusCodeEnum {
	
	/** 全局错误 */
    GLOBAL_SUCCESS(200, "成功"),
    GLOBAL_ERROR(500, "服务器异常, 请稍后重试"),
    GLOBAL_UPDATE_FAILED(501, "更新失败"),
    GLOBAL_CREATE_FAILED(502, "创建失败"),
    GLOBAL_DELETE_FAILED(503, "删除失败"),
    
    ;
	
	private int code;
	private String message;

	StatusCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
