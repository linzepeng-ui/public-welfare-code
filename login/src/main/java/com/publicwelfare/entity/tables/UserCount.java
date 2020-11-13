package com.publicwelfare.entity.tables;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 用户数量登记表
 * @author zepeng.lin
 * @date 2020/10/13
 */
@NoArgsConstructor
@AllArgsConstructor
public class UserCount {

    private Integer userIdCount;

    private String time;

    @Override
    public String toString() {
        return "UserCount{" +
                "userIdCount=" + userIdCount +
                ", time='" + time + '\'' +
                '}';
    }

    public Integer getUserIdCount() {
        return userIdCount;
    }

    public void setUserIdCount(Integer userIdCount) {
        this.userIdCount = userIdCount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
