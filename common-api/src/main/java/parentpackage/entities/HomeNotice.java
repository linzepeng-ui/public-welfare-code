package parentpackage.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author zepeng.lin
 * @date 2020/9/27
 * 首页公告栏表
 */
@NoArgsConstructor
@AllArgsConstructor
public class HomeNotice {

    /**
     * 公告标题
     */
    private String noticeTitle;

    /**
     * 公告内容
     */
    private String noticeContent;

    /**
     * 公告发布时间
     * 公告发布时间格式为“YYYY-MM-DD HH:MM:SS”
     */
    private String noticeSendTime;

    /**
     * 内容图片地址
     */
    private String imageUrl;

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getNoticeSendTime() {
        return noticeSendTime;
    }

    public void setNoticeSendTime(String noticeSendTime) {
        this.noticeSendTime = noticeSendTime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "HomeNotice{" +
                "noticeTitle='" + noticeTitle + '\'' +
                ", noticeContent='" + noticeContent + '\'' +
                ", noticeSendTime='" + noticeSendTime + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
