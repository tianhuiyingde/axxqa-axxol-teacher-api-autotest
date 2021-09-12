package cases.login;

import cases.TestBase;
import com.axxqa.automation.AutomationTestBase;
import com.axxqa.axxol.teacher.HttpClient;
import com.axxqa.axxol.teacher.ResponseBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.IOException;

/**
 * @author tianhuiying on 2020/10/23.
 * @version 1.0
 */
public class AuthKeyTest  extends TestBase {

    @Test(groups = "getKey",description = "教师登录获取pubkey")
    public void getPublicKeyTest() throws IOException {
        Response<ResponseBase> response = httpClient.getPublicKey();
        Assert.assertEquals(response.code(),200);
        Assert.assertEquals(response.body().getCode(),"SUCCESS");
        if(response.body().getData()!=null){
            HttpClient.PUBLICKEY=response.body().getData().toString();
        }
    }
}
