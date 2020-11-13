package com.publicwelfare.entity.tables;

import lombok.AllArgsConstructor;

/**
 * @author zepeng.lin
 * @date 2020/9/25
 * 用户基本信息表
 */
@AllArgsConstructor
public class UserInfo<T> {

    /**
     * 用户id
     */
    private String userId;

    /**
     * 微信用户唯一标识符openid，允许为null
     */
    private String openId;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 用户类别，在数据库中此值为枚举类型，分别为“志愿者，街道，NGO，平台”
     */
    private String userType;

    /**
     * 用户身份证号,允许为null
     */
    private String identifiedCardId;

    /**
     * 用户电话号码,允许为null
     */
    private String telephoneNum;

    /**
     * 用户的头像图片地址，允许为null
     */
    private String imageUrl;

    /**
     * 用户的邮箱地址
     */
    private String emailAddr;

    /**
     * 用户扩展信息
     * 每一个用户分别都有不同的扩展信息，例如志愿者对应volunteerInfo
     * 在实例化的时候可以调用没有expandInfo的构造函数，这样此条数据为null
     */
    private T expandInfo;

    /**
     * 此构造方法用于没有扩展信息或不使用扩展信息的情况
     */
    public UserInfo() {
        this.expandInfo = null;
    }

    /**
     * 此构造方法用于需要使用用户扩展信息的情况
     * @param expandInfo 用户扩展信息
     */
    public UserInfo(T expandInfo) {
        this.expandInfo = expandInfo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getIdentifiedCardId() {
        return identifiedCardId;
    }

    public void setIdentifiedCardId(String identifiedCardId) {
        this.identifiedCardId = identifiedCardId;
    }

    public String getTelephoneNum() {
        return telephoneNum;
    }

    public void setTelephoneNum(String telephoneNum) {
        this.telephoneNum = telephoneNum;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getEmailAddr() {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    public T getExpandInfo() {
        return expandInfo;
    }

    public void setExpandInfo(T expandInfo) {
        this.expandInfo = expandInfo;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId='" + userId + '\'' +
                ", openId='" + openId + '\'' +
                ", username='" + username + '\'' +
                ", userType='" + userType + '\'' +
                ", identifiedCardId='" + identifiedCardId + '\'' +
                ", telephoneNum='" + telephoneNum + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", emailAddr='" + emailAddr + '\'' +
                ", expandInfo=" + expandInfo +
                '}';
    }
}
