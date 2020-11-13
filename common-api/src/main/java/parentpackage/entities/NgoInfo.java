package parentpackage.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author zepeng.lin
 * @date 2020/9/25
 * NGO扩展信息表
 */
@NoArgsConstructor
@AllArgsConstructor
public class NgoInfo {

    /**
     * 用户id(NGO id)
     */
    private String userId;

    /**
     * NGO描述
     */
    private String ngoIntroduce;

    /**
     * NGO位置
     */
    private String ngoLocation;

    /**
     * NGO图片url地址
     */
    private String ngoPicture;

    /**
     * 承接需求数，数据库默认为0
     */
    private Integer undertakeBusiness;

    /**
     * 已完成需求数，数据库默认为0
     */
    private Integer doneBusiness;

    /**
     * 已完成服务数，数据库默认为0
     */
    private Integer doneService;

    /**
     * 综合评分，数据库默认为0
     */
    private Float comprehensiveScore;

    /**
     * NGO信息审核状态
     * 只有两种，分别为"审核中","审核完成"
     */
    private String ngoStatus;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getUndertakeBusiness() {
        return undertakeBusiness;
    }

    public void setUndertakeBusiness(Integer undertakeBusiness) {
        this.undertakeBusiness = undertakeBusiness;
    }

    public Integer getDoneBusiness() {
        return doneBusiness;
    }

    public void setDoneBusiness(Integer doneBusiness) {
        this.doneBusiness = doneBusiness;
    }

    public Integer getDoneService() {
        return doneService;
    }

    public void setDoneService(Integer doneService) {
        this.doneService = doneService;
    }

    public Float getComprehensiveScore() {
        return comprehensiveScore;
    }

    public void setComprehensiveScore(Float comprehensiveScore) {
        this.comprehensiveScore = comprehensiveScore;
    }

    public String getNgoIntroduce() {
        return ngoIntroduce;
    }

    public void setNgoIntroduce(String ngoIntroduce) {
        this.ngoIntroduce = ngoIntroduce;
    }

    public String getNgoLocation() {
        return ngoLocation;
    }

    public void setNgoLocation(String ngoLocation) {
        this.ngoLocation = ngoLocation;
    }

    public String getNgoPicture() {
        return ngoPicture;
    }

    public void setNgoPicture(String ngoPicture) {
        this.ngoPicture = ngoPicture;
    }

    public String getNgoStatus() {
        return ngoStatus;
    }

    public void setNgoStatus(String ngoStatus) {
        this.ngoStatus = ngoStatus;
    }

    @Override
    public String toString() {
        return "NgoInfo{" +
                "userId='" + userId + '\'' +
                ", ngoIntroduce='" + ngoIntroduce + '\'' +
                ", ngoLocation='" + ngoLocation + '\'' +
                ", ngoPicture='" + ngoPicture + '\'' +
                ", undertakeBusiness=" + undertakeBusiness +
                ", doneBusiness=" + doneBusiness +
                ", doneService=" + doneService +
                ", comprehensiveScore=" + comprehensiveScore +
                ", ngoStatus='" + ngoStatus + '\'' +
                '}';
    }
}
