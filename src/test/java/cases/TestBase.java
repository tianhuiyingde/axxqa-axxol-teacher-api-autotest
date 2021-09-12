package cases;

import com.axxqa.automation.AutomationTestBase;
import com.axxqa.axxol.teacher.HttpClient;
import org.apache.ibatis.session.SqlSession;
import org.simfast.simpletester.core.DataResoverUtils;
import org.simfast.simpletester.tester.SimpleTester;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import com.axxqa.axxol.utils.DatabaseUtil;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;

public class TestBase extends AutomationTestBase {

    public static HttpClient httpClient;

    @BeforeSuite(groups = "init",description = "测试准备，获取httpclient对象")
    public void BeforeSuite() throws IOException {
        Reporter.log("----开始测试-----");


        httpClient=new HttpClient();


    }
    @DataProvider(
            name = "excel"
    )
    protected Object[][] setupExcel(Method method) {
        return DataResoverUtils.resolveExcelTestParams(method);
    }

    @DataProvider(
            name = "json"
    )
    protected Object[][] setupJson(Method method) {
        return DataResoverUtils.resolveJsonTestParams(method);
    }

    @DataProvider(
            name = "yaml"
    )
    protected Iterator<Object[]> setupYaml(Method method) {
        return DataResoverUtils.resolveYamlTestParams(method);
    }

    @DataProvider(
            name = "csv"
    )
    protected Object[][] setupCSV(Method method) {
        return DataResoverUtils.resolveCsvTestParams(method);
    }
}
