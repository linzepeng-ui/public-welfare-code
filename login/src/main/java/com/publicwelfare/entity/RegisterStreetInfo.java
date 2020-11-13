package com.publicwelfare.entity;

import com.publicwelfare.entity.tables.StreetInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Administrator
 */
public class RegisterStreetInfo extends StreetInfo {

    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
