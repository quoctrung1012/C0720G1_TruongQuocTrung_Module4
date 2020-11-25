package com.code.model;

public class EmailSetting {
    private String languages;
    private String pageSize;
    private boolean spamFitter;
    private String signature;

    public EmailSetting() {
    }

    public EmailSetting(String languages, String pageSize, boolean spamFitter, String signature) {
        this.languages = languages;
        this.pageSize = pageSize;
        this.spamFitter = spamFitter;
        this.signature = signature;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public boolean getSpamFitter() {
        return spamFitter;
    }

    public void setSpamFitter(boolean spamFitter) {
        this.spamFitter = spamFitter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
