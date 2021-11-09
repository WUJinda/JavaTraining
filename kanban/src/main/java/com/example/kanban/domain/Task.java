package com.example.kanban.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;
    private Integer nbHoursForecast;
    private Integer nbHoursReal;
    private Date created;

    // relation
    @ManyToOne
    private TaskType type;

    @ManyToOne
    private TaskStatus status;

    @ManyToMany(fetch= FetchType.EAGER)
    private Set<Developer> developers;

    @OneToMany(mappedBy = "task", fetch = FetchType.EAGER)
    private Set<ChangeLog> changeLogs;

    public Task() {

        this.developers = new HashSet<>();

        this.changeLogs = new HashSet<>();
    }

    public void addDeveloper(Developer developer) {

        developer.getTasks().add(this);

        this.developers.add(developer);
    }

    public void addChangeLog(ChangeLog changeLog) {

        changeLog.setTask(this);

        this.changeLogs.add(changeLog);
    }

    public void clearChangeLogs() {

        for (ChangeLog changeLog :  this.changeLogs) {

            changeLog.setTask(null);
        }

        this.changeLogs.clear();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNbHoursForecast() {
        return nbHoursForecast;
    }

    public void setNbHoursForecast(Integer nbHoursForecast) {
        this.nbHoursForecast = nbHoursForecast;
    }

    public Integer getNbHoursReal() {
        return nbHoursReal;
    }

    public void setNbHoursReal(Integer nbHoursReal) {
        this.nbHoursReal = nbHoursReal;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public TaskType getType() {
        return type;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Set<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }

    public Set<ChangeLog> getChangeLogs() {
        return changeLogs;
    }

    public void setChangeLogs(Set<ChangeLog> changeLogs) {
        this.changeLogs = changeLogs;
    }
}
