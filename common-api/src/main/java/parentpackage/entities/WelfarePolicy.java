package parentpackage.entities;

/**
 * @author zepeng.lin
 * @date 2020/9/27
 * 公益政策表
 */
public class WelfarePolicy {

    /**
     * 政策标题
     */
    private String policyTitle;

    public String getPolicyTitle() {
        return policyTitle;
    }

    public void setPolicyTitle(String policyTitle) {
        this.policyTitle = policyTitle;
    }

    @Override
    public String toString() {
        return "WelfarePolicy{" +
                "policyTitle='" + policyTitle + '\'' +
                '}';
    }
}
