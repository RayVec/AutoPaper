package com.bd17kaka.autopaper.vo;

import java.io.Serializable;

/**
 * @author tupeng
 */
public class UploadStatus implements Serializable {

    private static final long serialVersionUID = 1L;

    private String fileName;

    private boolean status;

    private String message;

    private String url;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
