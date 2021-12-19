package com.telecom.wu.kanban2.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

//@EqualsAndHashCode  // Generate equals() and HashCode() during the compilation.
@Data   // Generate getters and setters during the compilation.
@JsonIgnoreProperties({"password", "startContract", "tasks"})
@Entity
public class Task {
    // BEGIN: ATTRIBUTES
    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "Title cannot be null") //validates that the annotated property value is not null.
    @NotEmpty(message = "Title cannot be empty")//validates that the property is not null or empty; can be applied to String, Collection, Map or Array values.
    private String title;

    @NotNull(message = "NbHoursForecast cannot be null")
    @Min(value = 0, message = "NbHoursForecast should not be less than 0")//validates that the annotated property has a value no smaller than the value attribute.
    @Max(value = 144, message = "NbHoursForecast should not be greater than 144")//validates that the annotated property has a value no larger than the value attribute.
    private Integer nbHoursForecast;

    @NotNull(message = "NbHoursReal cannot be null")
    @Min(value = 0, message = "NbHoursReal should not be less than 0")
    @Max(value = 144, message = "NbHoursReal should not be greater than 144")
    private Integer nbHoursReal;

    private LocalDate created;


    @ManyToOne // relation
    private TaskType type;

    @ManyToOne
    private TaskStatus status;

    @ManyToMany(fetch= FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @NotEmpty(message = "Developers cannot be empty")
    private Set<Developer> developers;

    @OneToMany(mappedBy="task", cascade={CascadeType.ALL}, orphanRemoval=true)// its usage is to delete orphaned entities from the database
    @EqualsAndHashCode.Exclude
    private Set<ChangeLog> changeLogs;
    // END: ATTRIBUTES

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
}
