package com.code.service;

import com.code.model.EmailSetting;

import java.util.List;

public interface EmailService {
    EmailSetting emailSave (EmailSetting emailSetting);

    List<String> getLanguageList();

    List<Integer> getPage();
}
