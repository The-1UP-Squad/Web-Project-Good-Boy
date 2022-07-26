package com.project.api.web.www;

public class Project {

    private int projId;
    private String projName;

    public int getProjId() {
        return projId;
    }
    public void setProjId(int projId) {
        this.projId = projId;
    }
    public String getProjName() {
        return projName;
    }
    public void setProjName(String projName) {
        this.projName = projName;
}
    public Project(int projId, String projName) {
        this.projId = projId;
        this.projName = projName;
    }

    @Override
    public String toString() {
        return "Project [projId=" + projId + ", projName=" + projName + "]";
    }
}