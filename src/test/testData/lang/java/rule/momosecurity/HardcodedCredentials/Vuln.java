import java.sql.DriverManager;
import java.util.Properties;

public class Vuln {
    <warning descr="MomoSec: 发现硬编码凭证">private String fieldToken = "f9IJosm2M2H7EqDBTAE2L2FE6";</warning>
    private String PASS_MSG = "我是中文";

    private String bar() {
        return "aloha";
    }

    public void foo() {
        String commonVar = "f9IJosm2M2H7EqDBTAE2L2FE6";
        <warning descr="MomoSec: 发现硬编码凭证">String private_token = "f9IJosm2M2H7EqDBTAE2L2FE6";</warning>
        String admin_passwd = "admin123";


        String myToken;
        <warning descr="MomoSec: 发现硬编码凭证">myToken = "f9IJosm2M2H7EqDBTAE2L2FE6"</warning>;

        String method_call = bar();
    }

    public void checkOnPropertiesKey() {
        Properties properties = new Properties();
        properties.put(PropertyKeyConstruct.AccessKey, "AccessKey");
        <warning descr="MomoSec: 发现硬编码凭证">properties.put(PropertyKeyConstruct.SecretKey, "f9IJosm2M2H7EqDBTAE2L2FE6")</warning>;
    }

    public void jdbcConn() throws Exception {
        <warning descr="MomoSec: 发现硬编码凭证">DriverManager.getConnection("jdbc:mysql://localhost/test?user=steve&password=blue&a=b")</warning>;
        <warning descr="MomoSec: 发现硬编码凭证">DriverManager.getConnection("jdbc:mysql://localhost/test","steve","blue")</warning>;
    }

    public void jdbcConnNotVul() throws Exception {
        DriverManager.getConnection("jdbc:mysql://localhost/test?user=steve&password="+getPwd());
        DriverManager.getConnection("jdbc:mysql://localhost/test","steve",getPwd());
    }

    private String getPwd() {
        return "pwd";
    }
}

class PropertyKeyConstruct {
    public static final String AccessKey = "AccessKey";
    public static final String SecretKey = "SecretKey";
}