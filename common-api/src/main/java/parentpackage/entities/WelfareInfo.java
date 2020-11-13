package parentpackage.entities;

/**
 * @author zepeng.lin
 * @date 2020/9/27
 * 公益资讯表
 */
public class WelfareInfo {

    /**
     * 资讯标题
     */
    private String infoTitle;

    /**
     * 资讯内容
     */
    private String infoContent;

    /**
     * 资讯发布时间
     * 资讯发布时间在数据库中为date型数据（YYYY-MM-DD）
     */
    private String infoTime;

    /**
     * 资讯图片url地址
     */
    private String infoImage;

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }

    public String getInfoContent() {
        return infoContent;
    }

    public void setInfoContent(String infoContent) {
        this.infoContent = infoContent;
    }

    public String getInfoTime() {
        return infoTime;
    }

    public void setInfoTime(String infoTime) {
        this.infoTime = infoTime;
    }

    public String getInfoImage() {
        return infoImage;
    }

    public void setInfoImage(String infoImage) {
        this.infoImage = infoImage;
    }

    @Override
    public String toString() {
        return "WelfareInfo{" +
                "infoTitle='" + infoTitle + '\'' +
                ", infoContent='" + infoContent + '\'' +
                ", infoTime='" + infoTime + '\'' +
                ", infoImage='" + infoImage + '\'' +
                '}';
    }
}
