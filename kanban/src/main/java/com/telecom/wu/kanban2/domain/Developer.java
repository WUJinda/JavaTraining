package com.telecom.wu.kanban2.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

//@ToString   // Generate ToString() during the compilation.
//@EqualsAndHashCode  // Generate equals() and HashCode() during the compilation.
// If annotation is created here, it will make stackoverflow errors
@AllArgsConstructor  // Generate Constructor with all arguments during the compilation.
@Data  // Generate getters and setters during the compilation.
@JsonIgnoreProperties({"tasks", "password"})
@Entity
public class Developer {

    // BEGIN: ATTRIBUTES
    @Id
    @GeneratedValue
    private Long id;

    private String firstname;
    private String lastname;
    private String password;
    private String email;


    @ToString.Exclude
    @EqualsAndHashCode.Exclude  // This way to avoid errors of stackoverflow and HashCode() is necessary cuz of Set<T>
    @ManyToMany(mappedBy = "developers", fetch = FetchType.EAGER) // fetchtype eager needed to erase error laziness
    private Set<Task> tasks;

    private LocalDate startContract;
    // END: ATTRIBUTES


    public Developer() {

        this.tasks = new HashSet<>();
    }
}

