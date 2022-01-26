package com.example.footballmanager.service.impl;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import com.example.footballmanager.model.FootballClub;
import com.example.footballmanager.model.Player;
import com.example.footballmanager.model.Transfer;
import com.example.footballmanager.repository.TransferRepository;
import com.example.footballmanager.service.FootballClubService;
import com.example.footballmanager.service.PlayerService;
import com.example.footballmanager.service.TransferService;
import org.springframework.stereotype.Service;

@Service
public class TransferServiceImpl implements TransferService {
    private final TransferRepository transferRepository;
    private final PlayerService playerService;
    private final FootballClubService footballClubService;

    public TransferServiceImpl(TransferRepository transferRepository,
                               PlayerService playerService,
                               FootballClubService footballClubService) {
        this.transferRepository = transferRepository;
        this.playerService = playerService;
        this.footballClubService = footballClubService;
    }

    @Override
    public Transfer transfer(Long playerId,
                             Long footballClubId) {
        Player player = playerService.getById(playerId);
        FootballClub footballClub = footballClubService.getById(footballClubId);
        Transfer transfer = new Transfer();
        transfer.setFootBallClub(footballClub);
        transfer.setPlayer(player);
        BigDecimal priceWithOutCommission = BigDecimal.valueOf(
                (Duration.between(player.getTransferredAt(), LocalDate.now())
                        .get(ChronoUnit.MONTHS) * 100000) /
                        Duration.between(player.getDayOfBirth(),
                                LocalDate.now()).get(ChronoUnit.YEARS));
        transfer.setPrice(priceWithOutCommission.add(priceWithOutCommission.divide(
                BigDecimal.valueOf(footballClub.getCommission()))));
        if (footballClub.getBalance().compareTo(transfer.getPrice()) < 0) {
            throw new RuntimeException("Not enough money for buy player "
                    + player.getName());
        }
        player.getFootballClub().setBalance(
                player.getFootballClub().getBalance().add(transfer.getPrice()));
        footballClub.setBalance(footballClub.getBalance()
                .add(transfer.getPrice().negate()));
        return transferRepository.save(transfer);
    }

    @Override
    public Transfer getById(Long id) {
        return transferRepository.getById(id);
    }

    @Override
    public List<Transfer> getAll() {
        return transferRepository.findAll();
    }
}
