package com.publicwelfare.entity;

import com.publicwelfare.entity.tables.NgoInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Administrator
 */
public class RegisterNgoInfo extends NgoInfo {

    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
