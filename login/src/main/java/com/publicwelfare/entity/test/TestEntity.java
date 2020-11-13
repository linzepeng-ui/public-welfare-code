package com.publicwelfare.entity.test;

import org.springframework.web.multipart.MultipartFile;

public class TestEntity {

    MultipartFile file;

    String text;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
