package com.example.footballmanager.service;

import java.util.List;
import com.example.footballmanager.model.FootballClub;

public interface FootballClubService {
    FootballClub add(FootballClub footballClub);

    FootballClub getById(Long id);

    List<FootballClub> getAll();

    void delete(Long id);
}
