package parentpackage.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author zepeng.lin
 * @date 2020/9/27
 * 首页轮播图表
 */
@NoArgsConstructor
@AllArgsConstructor
public class HomeSlideshow {

    /**
     * 轮播图标题
     */
    private String slideTitle;

    /**
     * 图片地址
     */
    private String imageUrl;

    public String getSlideTitle() {
        return slideTitle;
    }

    public void setSlideTitle(String slideTitle) {
        this.slideTitle = slideTitle;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "HomeSlideshow{" +
                "slideTitle='" + slideTitle + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
