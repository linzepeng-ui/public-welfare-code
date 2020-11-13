package com.publicwelfare.entity;

import com.publicwelfare.entity.tables.UserInfo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Administrator
 */

public class RegisterUserInfo extends UserInfo {

    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
