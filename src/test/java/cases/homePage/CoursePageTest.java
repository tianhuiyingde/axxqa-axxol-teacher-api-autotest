package cases.homePage;

import cases.TestBase;
import com.axxqa.axxol.teacher.ResponseBase;
import com.axxqa.axxol.teacher.homePage.CourseBean;
import com.axxqa.axxol.teacher.homePage.CoursePageResponse;
import org.simfast.simpletester.core.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.simfast.simpletester.annotation.DataFile;
import retrofit2.Response;


import java.io.IOException;

import static com.axxqa.axxol.teacher.HttpClient.*;

/**
 * @author tianhuiying on 2020/10/25.
 * @version 1.0
 */
public class CoursePageTest extends TestBase {

    @Test(dataProvider = "excel",groups = "courseList",dependsOnGroups = "teacherlogin",description = "首页查询课程列表接口-分页")
    @DataFile(path="src/test/java/resources/testData/CoursePageTestData.xls",sheetName = "normal")
    public void coursePageTest(TestData testData) throws IOException {
        String courseName=testData.getString("courseName");//根据课程名称模糊查询
        int courseProgress=testData.getInteger("courseProgress");//1:未开课，2：已开课，3：已结课
        int status=testData.getInteger("status");//0：未上线，1：已上线，-1：已下线
        int pageSize=testData.getInteger("pageSize");//每页多少条
        int pageNum=testData.getInteger("pageNum");//第几页
        Response<ResponseBase<CoursePageResponse>> response=httpClient.coursePage(courseName,courseProgress, status,institutionId,
         teacherId, userId,pageSize, pageNum);
        Assert.assertEquals(response.code(),200);
        Assert.assertEquals(response.body().getCode(),"SUCCESS");
        CoursePageResponse data=response.body().getData();
        if(data.getList()!=null){
            for(CourseBean course : data.getList()){
                Assert.assertNotNull(course.getId());
                Assert.assertNotNull(course.getClassId());
                Assert.assertNotNull(course.getClassTypeId());
                Assert.assertEquals(course.getName().contains(courseName),true);
                courseIdList.add(course.getId());
            }
        }
        System.out.println("courseIdList:"+courseIdList.toString());
    }
}
