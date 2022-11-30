package com.mykola.myapplication;

public class Task {


    private String taskName;
    private String textTask;
    private String createDate;

    public Task(String taskName, String textOfTask
                 , String createDate) {

        this.taskName = taskName;
        this.textTask = textOfTask;
        this.createDate = createDate;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTextTask() {
        return textTask;
    }

    public String getCreateDate() {
        return createDate;
    }


}