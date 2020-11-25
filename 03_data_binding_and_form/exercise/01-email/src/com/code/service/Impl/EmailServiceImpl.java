package com.code.service.Impl;

import com.code.model.EmailSetting;
import com.code.service.EmailService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmailServiceImpl implements EmailService {
    @Override
    public EmailSetting emailSave(EmailSetting emailSetting) {
        return emailSetting;
    }

    @Override
    public List<String> getLanguageList() {
        List<String> languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
        return languageList;
    }

    @Override
    public List<Integer> getPage() {
        List<Integer> pageSizeList = new ArrayList<>();
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);
        return pageSizeList;
    }
}
