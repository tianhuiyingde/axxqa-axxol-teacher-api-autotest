package cases.homePage;

import cases.TestBase;
import com.axxqa.axxol.teacher.ResponseBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.IOException;

import static com.axxqa.axxol.teacher.HttpClient.institutionId;
import static com.axxqa.axxol.teacher.HttpClient.userId;

/**
 * @author tianhuiying on 2020/10/25.
 * @version 1.0
 */
public class HourEnoughTest extends TestBase {

    @Test(dependsOnGroups = "teacherlogin",description = "判断小时包是否足够接口")
    public void hourEnoughTest() throws IOException {
        Response<ResponseBase> response=httpClient.hourEnough(institutionId,userId);
        Assert.assertEquals(response.code(),200);
        Assert.assertEquals(response.body().getCode(),"SUCCESS");
    }
}
