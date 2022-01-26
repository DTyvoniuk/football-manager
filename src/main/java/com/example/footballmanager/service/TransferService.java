package com.example.footballmanager.service;

import java.util.List;
import com.example.footballmanager.model.Transfer;

public interface TransferService {
    Transfer transfer(Long player_id,
                      Long footballClub_id);

    Transfer getById(Long id);

    List<Transfer> getAll();
}
