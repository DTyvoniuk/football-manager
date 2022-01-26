package com.example.footballmanager.controller;

import java.util.List;
import com.example.footballmanager.model.FootballClub;
import com.example.footballmanager.service.FootballClubService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/football-clubs")
public class FootballClubController {
    private final FootballClubService footballClubService;

    public FootballClubController(FootballClubService footballClubService) {
        this.footballClubService = footballClubService;
    }

    @PostMapping
    public FootballClub add(FootballClub footballClub) {
        return footballClubService.add(footballClub);
    }

    @GetMapping("/{id}")
    public FootballClub getById(@PathVariable(value = "id") Long id) {
        return footballClubService.getById(id);
    }

    @GetMapping
    public List<FootballClub> getAll() {
        return footballClubService.getAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable(value = "id") Long id) {
        String footballClubName = footballClubService.getById(id).getName();
        footballClubService.delete(id);
        return footballClubName;
    }
}
