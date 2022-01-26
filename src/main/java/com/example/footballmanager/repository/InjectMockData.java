package com.example.footballmanager.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.annotation.PostConstruct;
import com.example.footballmanager.model.FootballClub;
import com.example.footballmanager.model.Player;
import com.example.footballmanager.service.FootballClubService;
import com.example.footballmanager.service.PlayerService;
import org.springframework.stereotype.Component;

@Component
public class InjectMockData {
    private final PlayerService playerService;
    private final FootballClubService footballClubService;

    public InjectMockData(PlayerService playerService, FootballClubService footballClubService) {
        this.playerService = playerService;
        this.footballClubService = footballClubService;
    }

    @PostConstruct
    public void inject() {
        FootballClub footballClub = new FootballClub();
        footballClub.setName("Dynamo Kyiv");
        footballClub.setCommission(5);
        footballClub.setBalance(BigDecimal.valueOf(1000000000));
        footballClubService.add(footballClub);
        Player player = new Player();
        player.setName("Awesome player");
        player.setFootballClub(footballClub);
        player.setDayOfBirth(LocalDate.parse("15.09.1990", DateTimeFormatter.ISO_DATE));
        player.setTransferredAt(LocalDate.parse("15.09.2015", DateTimeFormatter.ISO_DATE));
        playerService.add(player);
    }
}
