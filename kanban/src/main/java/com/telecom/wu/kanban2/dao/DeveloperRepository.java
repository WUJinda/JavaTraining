package com.telecom.wu.kanban2.dao;

import com.telecom.wu.kanban2.domain.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {

}
