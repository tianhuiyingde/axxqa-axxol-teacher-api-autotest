package cases.CourseDetail;

import cases.TestBase;
import com.axxqa.axxol.teacher.ResponseBase;
import com.axxqa.axxol.teacher.courseDetail.CourseDetailResponse;
import com.axxqa.axxol.teacher.courseDetail.KnowledgeBean;
import com.axxqa.axxol.teacher.homePage.CoursePageResponse;
import org.simfast.simpletester.annotation.DataFile;
import org.simfast.simpletester.core.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Response;


import java.io.IOException;

import static com.axxqa.axxol.teacher.HttpClient.*;

/**
 * @author tianhuiying on 2020/10/25.
 * @version 1.0
 */
public class CourseDetailTest extends TestBase {

    @Test(groups = "courseDetail",dependsOnGroups = "courseList",description = "课程详情讲次列表接口-从coursepage接口取courseid")
    public void courseDetailTestByList() throws IOException {
        if(courseIdList.size()>0){
            Response<ResponseBase<CourseDetailResponse>> response=httpClient.courseDetail(courseIdList.get(0),institutionId,teacherId,userId);
            Assert.assertEquals(response.code(),200);
            Assert.assertEquals(response.body().getCode(),"SUCCESS");
            CourseDetailResponse data=response.body().getData();
            for(KnowledgeBean knowledge:data.getKnowledgeList()){
                Assert.assertNotNull(knowledge.getId());
                knowledgeIdList.add(knowledge.getId());
            }
        }
        System.out.println("knowledgeIdList:"+knowledgeIdList.toString());

    }

    @Test(dataProvider = "excel",dependsOnGroups = "teacherlogin",description = "课程详情讲次列表接口-从excel取courseid")
    @DataFile(path = "src/test/java/resources/testData/CourseDetailTestData.xls",sheetName = "normal")
    public void courseDetailTestByExcel(TestData testData) throws IOException {
        int courseId=testData.getInteger("courseId");
        Response<ResponseBase<CourseDetailResponse>> response=httpClient.courseDetail(courseId,institutionId,teacherId,userId);
        Assert.assertEquals(response.code(),200);
        Assert.assertEquals(response.body().getCode(),"SUCCESS");
        CourseDetailResponse data=response.body().getData();
        Assert.assertNotNull(data.getId());
        Assert.assertNotNull(data.getClassId());
        Assert.assertNotNull(data.getAxgTeacherId());
        Assert.assertEquals(data.getKnowledgeList().size()>0,true);
        for(KnowledgeBean knowledge:data.getKnowledgeList()){
            Assert.assertNotNull(knowledge.getId());
            Assert.assertNotNull(knowledge.getLessonId());
            Assert.assertNotNull(knowledge.getLiveStatus());
            Assert.assertNotNull(knowledge.getPlayBackStatus());
            Assert.assertNotNull(knowledge.isWindowRoom());
            Assert.assertNotNull(knowledge.getSupportPlatform());
            knowledgeIdList.add(knowledge.getId());
        }
        System.out.println("knowledgeIdList:"+knowledgeIdList.toString());
    }
}
