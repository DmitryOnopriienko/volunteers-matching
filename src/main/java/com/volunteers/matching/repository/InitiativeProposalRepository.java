package com.volunteers.matching.repository;

import com.volunteers.matching.entity.InitiativeProposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InitiativeProposalRepository extends JpaRepository<InitiativeProposal, Integer> {
}
