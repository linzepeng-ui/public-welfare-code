package parentpackage.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author zepeng.lin
 * @date 2020/9/25
 * 服务基本信息表
 */
@AllArgsConstructor
@NoArgsConstructor
public class BasicServiceInfo {

    /**
     * 服务id号
     * 每个服务id号唯一
     */
    private String serviceId;

    /**
     * 公益名称
     */
    private String welfareName;

    /**
     * 公益项目介绍
     * 此字段限定最大500，允许为null
     */
    private String welfareIntroduce;

    /**
     * 公益内容
     * 此字段限定最大500，允许为null
     */
    private String welfareContent;

    /**
     * 公益项目资金
     * 默认为0
     */
    private Float welfareWealthy;

    /**
     * 公益项目类型
     */
    private String welfareType;

    /**
     * 服务类型
     */
    private String serviceType;

    /**
     * 服务大致地点
     */
    private String serviceLocation;

    public String getServiceLocation() {
        return serviceLocation;
    }

    public void setServiceLocation(String serviceLocation) {
        this.serviceLocation = serviceLocation;
    }

    /**
     * 公益服务状态
     * 在数据库中为枚举类型，为“报名中，已发布，进行中，已完成”
     */
    private String serviceStatus;

    /**
     * 服务街道名称
     * 此服务发布于哪个街道，serviceFrom为其街道名称
     */
    private String serviceFrom;

    /**
     * 执行服务请求的NGO机构名称
     * 此服务被哪个NGO机构所接收请求，如果这个服务还处于已发布状态，则此项为null，数据库允许为null
     */
    private String executeInstitution;

    /**
     * 服务人数
     * 由NGO规定此项目有多少人进行志愿服务，默认为0
     */
    private Integer servicePersonNum;

    /**
     * 所有服务人员姓名
     * 此字段规定最大500，可能根据需求进行变动，运用“zzz\n"+"zzz"的形式进行字符串拼接进行存储
     */
    private String servicePersons;

    /**
     * 服务受助人数
     * 此服务受到援助的人数
     */
    private Integer serviceHelpPersonNum;

    /**
     * 服务开始时间
     * 此段在数据库中是date型数据（YYYY-MM-DD）
     */
    private String serviceStartTime;

    /**
     * 服务结束时间
     * 此段在数据库中是date型数据（YYYY-MM-DD）
     */
    private String serviceEndTime;

    /**
     * 服务次数
     * 表示此服务所做的次数，默认为1
     */
    private Integer serviceTimes;

    /**
     * 公益宣传图片
     * 公益的封面图片
     * @problem 可能会涉及到多张图片宣传，后期应改进为List<String>
     */
    private String imageUrl;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getWelfareName() {
        return welfareName;
    }

    public void setWelfareName(String welfareName) {
        this.welfareName = welfareName;
    }

    public String getWelfareIntroduce() {
        return welfareIntroduce;
    }

    public void setWelfareIntroduce(String welfareIntroduce) {
        this.welfareIntroduce = welfareIntroduce;
    }

    public String getWelfareContent() {
        return welfareContent;
    }

    public void setWelfareContent(String welfareContent) {
        this.welfareContent = welfareContent;
    }

    public Float getWelfareWealthy() {
        return welfareWealthy;
    }

    public void setWelfareWealthy(Float welfareWealthy) {
        this.welfareWealthy = welfareWealthy;
    }

    public String getWelfareType() {
        return welfareType;
    }

    public void setWelfareType(String welfareType) {
        this.welfareType = welfareType;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public String getServiceFrom() {
        return serviceFrom;
    }

    public void setServiceFrom(String serviceFrom) {
        this.serviceFrom = serviceFrom;
    }

    public String getExecuteInstitution() {
        return executeInstitution;
    }

    public void setExecuteInstitution(String executeInstitution) {
        this.executeInstitution = executeInstitution;
    }

    public Integer getServicePersonNum() {
        return servicePersonNum;
    }

    public void setServicePersonNum(Integer servicePersonNum) {
        this.servicePersonNum = servicePersonNum;
    }

    public String getServicePersons() {
        return servicePersons;
    }

    public void setServicePersons(String servicePersons) {
        this.servicePersons = servicePersons;
    }

    public Integer getServiceHelpPersonNum() {
        return serviceHelpPersonNum;
    }

    public void setServiceHelpPersonNum(Integer serviceHelpPersonNum) {
        this.serviceHelpPersonNum = serviceHelpPersonNum;
    }

    public String getServiceStartTime() {
        return serviceStartTime;
    }

    public void setServiceStartTime(String serviceStartTime) {
        this.serviceStartTime = serviceStartTime;
    }

    public String getServiceEndTime() {
        return serviceEndTime;
    }

    public void setServiceEndTime(String serviceEndTime) {
        this.serviceEndTime = serviceEndTime;
    }

    public Integer getServiceTimes() {
        return serviceTimes;
    }

    public void setServiceTimes(Integer serviceTimes) {
        this.serviceTimes = serviceTimes;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "BasicServiceInfo{" +
                "serviceId='" + serviceId + '\'' +
                ", welfareName='" + welfareName + '\'' +
                ", welfareIntroduce='" + welfareIntroduce + '\'' +
                ", welfareContent='" + welfareContent + '\'' +
                ", welfareWealthy=" + welfareWealthy +
                ", welfareType='" + welfareType + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", serviceLocation='" + serviceLocation + '\'' +
                ", serviceStatus='" + serviceStatus + '\'' +
                ", serviceFrom='" + serviceFrom + '\'' +
                ", executeInstitution='" + executeInstitution + '\'' +
                ", servicePersonNum=" + servicePersonNum +
                ", servicePersons='" + servicePersons + '\'' +
                ", serviceHelpPersonNum=" + serviceHelpPersonNum +
                ", serviceStartTime='" + serviceStartTime + '\'' +
                ", serviceEndTime='" + serviceEndTime + '\'' +
                ", serviceTimes=" + serviceTimes +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
