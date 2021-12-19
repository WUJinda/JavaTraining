package com.telecom.wu.kanban2.dao;

import com.telecom.wu.kanban2.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}