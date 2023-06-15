package com.volunteers.matching.repository;

import com.volunteers.matching.entity.Initiative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InitiativeRepository extends JpaRepository<Initiative, Integer> {
}
