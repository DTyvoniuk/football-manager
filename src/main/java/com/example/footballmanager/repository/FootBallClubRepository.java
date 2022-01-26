package com.example.footballmanager.repository;

import com.example.footballmanager.model.FootballClub;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FootBallClubRepository extends JpaRepository<FootballClub, Long> {
}
