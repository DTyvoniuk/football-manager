package com.example.footballmanager.controller;

import java.util.List;
import com.example.footballmanager.model.Player;
import com.example.footballmanager.service.PlayerService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public Player add(@RequestBody Player player) {
        return playerService.add(player);
    }

    @GetMapping("/{id}")
    public Player getById(@PathVariable(value = "id") Long id) {
        return playerService.getById(id);
    }

    @GetMapping
    public List<Player> getAll() {
        return playerService.getAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable(value = "id") Long id) {
        String playerName = playerService.getById(id).getName();
        playerService.delete(id);
        return "Was deleted player " + playerName;
    }
}
