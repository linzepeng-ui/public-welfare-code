package parentpackage.entities.common;

/**
 * @author zepeng.lin
 * @date 2020/9/25
 * 存储静态resultCode和resultMsg的类
 * 皆运用public static修饰
 */
public class StatusCodeAndMsg {

    /**
     * 查询成功或处理成功状态码
     */
    public static Integer SUCCESS_CODE = 200;

    /**
     * 登录查询成功，密码错误
     */
    public static Integer PASSWORD_ERROR = 102;

    /**
     * 查询失败，数据库没此数据或数据库出错返回状态码
     */
    public static Integer RESULT_NOT_FOUND = 404;

    /**
     * 请求的参数出错
     */
    public static Integer REQUEST_ERROR = 405;

    /**
     * 数据库出错
     */
    public static Integer DATABASE_ERROR = 103;

    /**
     * 微信小程序AppId
     */
    public static String APP_ID = "wxf8d3e029ebed7428";

    /**
     * 微信小程序AppSecret
     */
    public static String APP_SECRET = "3570f3eed304c3b80f2cfb80c5293f21";
}
