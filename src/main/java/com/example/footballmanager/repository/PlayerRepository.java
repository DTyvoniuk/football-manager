package com.example.footballmanager.repository;

import com.example.footballmanager.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
