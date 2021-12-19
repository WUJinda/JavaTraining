package com.telecom.wu.kanban2.dao;

import com.telecom.wu.kanban2.domain.ChangeLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChangeLogRepository extends JpaRepository<ChangeLog, Long> {
    List<ChangeLog> findByTaskId(Long taskId);
}
