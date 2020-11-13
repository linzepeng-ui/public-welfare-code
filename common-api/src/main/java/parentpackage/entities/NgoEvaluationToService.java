package parentpackage.entities;

/**
 * @author Administrator
 */
public class NgoEvaluationToService {

    private String evaluationId;

    private String serviceId;

    public String getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(String evaluationId) {
        this.evaluationId = evaluationId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String toString() {
        return "NgoEvaluationToService{" +
                "evaluationId='" + evaluationId + '\'' +
                ", serviceId='" + serviceId + '\'' +
                '}';
    }
}
