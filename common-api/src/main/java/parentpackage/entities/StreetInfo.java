package parentpackage.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author zepeng.lin
 * @date 2020/10/9
 * 街道拓展信息表
 */
@AllArgsConstructor
@NoArgsConstructor
public class StreetInfo {

    /**
     * 用户ID,在此为街道ID
     */
    private String userId;

    /**
     * 街道描述
     */
    private String streetIntroduce;

    /**
     * 街道位置
     */
    private String streetLocation;

    /**
     * 街道图片url
     */
    private String streetPicture;

    /**
     * 街道信息审核状态
     * 只有两种，分别为“审核中”,"审核完成"
     */
    private String streetStatus;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStreetIntroduce() {
        return streetIntroduce;
    }

    public void setStreetIntroduce(String streetIntroduce) {
        this.streetIntroduce = streetIntroduce;
    }

    public String getStreetLocation() {
        return streetLocation;
    }

    public void setStreetLocation(String streetLocation) {
        this.streetLocation = streetLocation;
    }

    public String getStreetPicture() {
        return streetPicture;
    }

    public void setStreetPicture(String streetPicture) {
        this.streetPicture = streetPicture;
    }

    public String getStreetStatus() {
        return streetStatus;
    }

    public void setStreetStatus(String streetStatus) {
        this.streetStatus = streetStatus;
    }

    @Override
    public String toString() {
        return "StreetInfo{" +
                "userId='" + userId + '\'' +
                ", streetIntroduce='" + streetIntroduce + '\'' +
                ", streetLocation='" + streetLocation + '\'' +
                ", streetPicture='" + streetPicture + '\'' +
                ", streetStatus='" + streetStatus + '\'' +
                '}';
    }
}
