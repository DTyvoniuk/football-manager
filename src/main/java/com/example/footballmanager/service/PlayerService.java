package com.example.footballmanager.service;

import java.util.List;
import com.example.footballmanager.model.Player;

public interface PlayerService {
    Player add(Player player);

    Player getById(Long id);

    List<Player> getAll();

    void delete(Long id);
}
