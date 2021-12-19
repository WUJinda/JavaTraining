package com.telecom.wu.kanban2.dao;

import com.telecom.wu.kanban2.domain.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskStatusRepository extends JpaRepository<TaskStatus, Long> {
}