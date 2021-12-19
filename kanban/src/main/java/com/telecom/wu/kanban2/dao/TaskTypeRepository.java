package com.telecom.wu.kanban2.dao;

import com.telecom.wu.kanban2.domain.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskTypeRepository extends JpaRepository<TaskType, Long> {
}