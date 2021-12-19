package com.telecom.wu.kanban2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class TaskType {
    // BEGIN: ATTRIBUTES
    @Id
    @GeneratedValue
    private Long id;
    private String label;
    // END: ATTRIBUTES
}
