package com.example.kanban.repositories;

import com.example.kanban.domain.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {

}