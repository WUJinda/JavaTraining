package com.telecom.wu.kanban2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class TaskStatus {
    // BEGIN: ATTRIBUTES
    @Id
    private Long id;

    private String label;
    // END: ATTRIBUTES
}
