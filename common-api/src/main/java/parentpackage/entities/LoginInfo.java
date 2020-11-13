package parentpackage.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author zepeng.lin
 * @date 2020/9/25
 * 用户登录表
 */
@AllArgsConstructor
@NoArgsConstructor
public class LoginInfo {

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户电话号码
     */
    private String telNum;

    /**
     * 用户密码
     */
    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginInfo{" +
                "userId='" + userId + '\'' +
                ", telNum='" + telNum + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
