package com.example.footballmanager.service.impl;

import java.util.List;
import com.example.footballmanager.model.FootballClub;
import com.example.footballmanager.repository.FootBallClubRepository;
import com.example.footballmanager.service.FootballClubService;
import org.springframework.stereotype.Service;

@Service
public class FootballClubServiceImpl implements FootballClubService {
    private final FootBallClubRepository footBallClubRepository;

    public FootballClubServiceImpl(FootBallClubRepository footBallClubRepository) {
        this.footBallClubRepository = footBallClubRepository;
    }

    @Override
    public FootballClub add(FootballClub footballClub) {
        return footBallClubRepository.save(footballClub);
    }

    @Override
    public FootballClub getById(Long id) {
        return footBallClubRepository.getById(id);
    }

    @Override
    public List<FootballClub> getAll() {
        return footBallClubRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        footBallClubRepository.delete(getById(id));
    }
}
