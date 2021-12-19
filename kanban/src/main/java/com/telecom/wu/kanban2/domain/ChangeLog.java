package com.telecom.wu.kanban2.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString   // Generate ToString() during the compilation.
@NoArgsConstructor  // Generate Constructor with NO arguments during the compilation.
@Data   // Generate getters and setters during the compilation.
@Entity
public class ChangeLog {
    // BEGIN: ATTRIBUTES
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime occured;

    @ManyToOne
    private Task task;

    @ManyToOne
    private TaskStatus targetStatus;

    @ManyToOne
    private TaskStatus sourceStatus;
    // END: ATTRIBUTES

    public ChangeLog(LocalDateTime occured, Task task, TaskStatus targetStatus, TaskStatus sourceStatus) {
        this.occured = occured;
        this.task = task;
        this.targetStatus = targetStatus;
        this.sourceStatus = sourceStatus;
    }
}
