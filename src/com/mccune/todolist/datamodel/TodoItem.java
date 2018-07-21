package com.mccune.todolist.datamodel;

import java.time.LocalDate;

public class TodoItem {

    private String shortDescription;
    private String detials;
    private LocalDate deadline;

    public TodoItem(String shortDescription, String detials, LocalDate deadline) {
        this.shortDescription = shortDescription;
        this.detials = detials;
        this.deadline = deadline;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDetials() {
        return detials;
    }

    public void setDetials(String detials) {
        this.detials = detials;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return shortDescription;
    }
}
