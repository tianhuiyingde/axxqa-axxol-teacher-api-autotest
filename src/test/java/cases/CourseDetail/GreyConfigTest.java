package cases.CourseDetail;

import cases.TestBase;
import com.axxqa.axxol.teacher.ResponseBase;
import com.axxqa.axxol.teacher.courseDetail.GreyConfigResponse;
import org.simfast.simpletester.annotation.DataFile;
import org.simfast.simpletester.core.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

import static com.axxqa.axxol.teacher.HttpClient.*;

/**
 * @author tianhuiying on 2020/10/25.
 * @version 1.0
 */
public class GreyConfigTest extends TestBase {

    @Test(dataProvider = "excel",dependsOnGroups = "teacherlogin",description = "灰度配置接口")
    @DataFile(path = "src/test/java/resources/testData/GreyConfigTestData.xls",sheetName = "normal")
    public void greyConfigTest(TestData testData) throws IOException {
        String[] typeList = {"ppt","pdf","localware","gslWindow"};
//        String typeList2=testData.getString("typeList");

        Response<ResponseBase<GreyConfigResponse>> response=httpClient.greyConfig(userId,teacherId,institutionId,typeList);
        Assert.assertEquals(response.code(),200);
        Assert.assertEquals(response.body().getCode(),"SUCCESS");
        GreyConfigResponse data=response.body().getData();
        Assert.assertNotNull(data.getLocalware());
        Assert.assertNotNull(data.getGslWindow());
        Assert.assertNotNull(data.getPdf());
        Assert.assertNotNull(data.getPpt());
    }
}
