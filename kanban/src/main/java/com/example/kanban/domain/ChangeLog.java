package com.example.kanban.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class ChangeLog {

    @Id
    @GeneratedValue
    private Long id;
    private Date occured;

    @ManyToOne
    private Task task;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOccured() {
        return occured;
    }

    public void setOccured(Date occured) {
        this.occured = occured;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
