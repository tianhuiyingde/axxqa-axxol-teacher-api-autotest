package cases.login;

import cases.TestBase;
import com.axxqa.automation.AutomationTestBase;
import com.axxqa.axxol.teacher.HttpClient;
import com.axxqa.axxol.teacher.ResponseBase;
import com.axxqa.axxol.teacher.login.LoginResponse;
import com.axxqa.axxol.teacher.login.UserInfoBean;
import org.simfast.simpletester.core.DataResoverUtils;
import org.simfast.simpletester.core.TestData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import retrofit2.Response;
import org.simfast.simpletester.annotation.DataFile;
import jxl.read.biff.BiffException;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;

/**
 * @author tianhuiying on 2020/10/23.
 * @version 1.0
 */
public class AuthLoginTest  extends TestBase {

    @Test(dataProvider = "excel",groups = "teacherlogin",dependsOnGroups = "getKey",description = "教师登录")
    @DataFile(path="src/test/java/resources/testData/AuthLoginTestData.xls",sheetName = "normal")
    public void loginTest(TestData testData) throws IOException {
        String username=testData.getString("username");
        String password=testData.getString("password");

        Response<ResponseBase<LoginResponse>> response = httpClient.login(username,password);
        Assert.assertEquals(response.code(),200);
        Assert.assertEquals(response.body().getCode(),"SUCCESS");
        LoginResponse data=response.body().getData();
        if(data!=null){
            HttpClient.institutionId=data.getUserInfo().getInstitutionId();
            HttpClient.userId=data.getUserInfo().getId();
            HttpClient.ptaxxzxzbtpc=data.getToken();
            HttpClient.teacherId=data.getUserInfo().getTeacherId();
        }

    }


}
