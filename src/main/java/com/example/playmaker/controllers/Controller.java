package com.example.playmaker.controllers;

import com.example.playmaker.models.TopPlayersRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value= "/api")
public interface Controller {

    @PostMapping(value="/getTopPlayers")
    public List<String> getTopPlayersFromGames(TopPlayersRequest data);

    @GetMapping(value="/health")
    public boolean healthCheck();
}
