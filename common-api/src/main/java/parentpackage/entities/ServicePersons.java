package parentpackage.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author zepeng.lin
 * @date 2020/9/25
 * 服务人员表
 */
@NoArgsConstructor
@AllArgsConstructor
public class ServicePersons {

    /**
     * 具体的服务ID
     */
    private String serviceId;

    /**
     * 服务人员ID
     */
    private String userId;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ServicePersons{" +
                "serviceId='" + serviceId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
