package com.example.footballmanager.controller;

import java.util.List;
import com.example.footballmanager.model.Transfer;
import com.example.footballmanager.service.TransferService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfers")
public class TransferController {
    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/complete")
    public Transfer complete(@RequestParam(value = "player_id") Long playerId,
                             @RequestParam(value = "football_club_id") Long footballClubId) {
        return transferService.transfer(playerId, footballClubId);
    }

    @GetMapping("/{id}")
    public Transfer getById(@PathVariable(value = "id") Long id) {
        return transferService.getById(id);
    }

    @GetMapping
    public List<Transfer> getAll() {
        return transferService.getAll();
    }
}
