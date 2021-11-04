package com.example.playmaker.controllers;

import com.example.playmaker.models.TopPlayersRequest;
import com.example.playmaker.services.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControllerImpl implements Controller {

    Logger logger = LoggerFactory.getLogger(ControllerImpl.class);

    Service service;

    @Autowired
    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public List<String> getTopPlayersFromGames(@RequestBody TopPlayersRequest data) {
        logger.debug(ControllerImpl.class.toString(),"Entering method 'getTopPlayersFromGames' with params: "+data.toString());
        List<String> mostPlayedPlayer = service.getTopParticipates(data);
        logger.debug(ControllerImpl.class.toString(),"Exiting method 'getTopPlayersFromGames' with result: "+mostPlayedPlayer.toArray());
        return mostPlayedPlayer;
    }

    @Override
    public boolean healthCheck() {
        return true;
    }
}
