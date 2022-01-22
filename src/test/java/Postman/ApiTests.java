package Postman;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ApiTests {

    ProjectAdapter projectAdapter;

    @BeforeClass
    public void setUp() {
        projectAdapter = new ProjectAdapter();
    }

    @Test
    public void getProjectTest() {
        String code = "TESTDEMO";
        Project expectedProject = Project.builder().
                title("TestDemo").
                code(code).
                counts(Counts.builder().
                        suites(0).
                        cases(0).
                        milestones(0).
                        defects(Defects.builder().
                                open(0).
                                total(0).
                                build()).
                        runs(Runs.builder().
                                total(0).
                                active(0).
                                build()).
                        build()).
                build();
        ProjectResponseBody<Object> expectedResponseResult = ProjectResponseBody.builder().
                status(true).result(expectedProject).build();

        ProjectResponseBody<Project> actualResponseBody = projectAdapter.getProject(code, 200);

        assertEquals(actualResponseBody, expectedResponseResult);
    }

    @Test
    public void createProjectPositiveTest1() {
        String projectCode = "LGJGGDFHR";

        ProjectResponseBody expectedResponse = ProjectResponseBody.builder().
                status(true).
                result(ResultCode.builder().
                        code(projectCode).
                        build()).
                build();

        Project project = Project.builder().
                title("QA_14_5").
                code(projectCode).
                build();

        ProjectResponseBody actualResponse = projectAdapter.createProject(project);
        assertEquals(actualResponse, expectedResponse);
    }

    @Test
    public void getAllProjectsTest() {
        ProjectResponseBody<AllProjects> actualResponse = projectAdapter.getAllProjects(200);
        System.out.println(actualResponse);
        System.out.println(actualResponse.getResult().getEntities()[9].getCode());
    }



}
