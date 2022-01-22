package Postman;

import com.google.gson.reflect.TypeToken;

public class ProjectAdapter extends BaseAdapter{

    final String PROJECT_URI = "project/";

    public ProjectResponseBody getAllProjects(int expectedStatusCode) {
        return  gson.fromJson(get(PROJECT_URI, expectedStatusCode), new TypeToken<ProjectResponseBody<AllProjects>>(){}.getType());
    }

    public ProjectResponseBody getProject(String projectCode, int expectedStatusCode) {
        return  gson.fromJson(get(PROJECT_URI + projectCode, expectedStatusCode), new TypeToken<ProjectResponseBody<Project>>(){}.getType());
    }

    public ProjectResponseBody createProject(Project project) {
        return gson.fromJson(post(PROJECT_URI, gson.toJson(project),200), new TypeToken<ProjectResponseBody<ResultCode>>(){}.getType());
    }
}
