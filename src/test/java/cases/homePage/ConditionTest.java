package cases.homePage;

import cases.TestBase;
import com.axxqa.axxol.teacher.ResponseBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Response;


import java.io.IOException;

import static com.axxqa.axxol.teacher.HttpClient.teacherId;
import static com.axxqa.axxol.teacher.HttpClient.userId;

/**
 * @author tianhuiying on 2020/10/25.
 * @version 1.0
 */
public class ConditionTest extends TestBase {

    @Test(dependsOnGroups = "teacherlogin",description = "首页获取课程默认状态接口")
    public void conditionTest() throws IOException {
        Response<ResponseBase> response=httpClient.condition(teacherId,userId);
        Assert.assertEquals(response.code(),200);
        Assert.assertEquals(response.body().getCode(),"SUCCESS");
    }
}
