package com.example.playmaker.services;

import com.example.playmaker.exceptions.WrongDataException;
import com.example.playmaker.helper.Helper;
import com.example.playmaker.models.TopPlayersRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    Logger logger =  LoggerFactory.getLogger(ServiceImpl.class);

    Helper helper;

    @Autowired
    public void setHelper(Helper helper) {
        this.helper = helper;
    }

    @Override
    public List<String> getTopParticipates(TopPlayersRequest data) {
        logger.debug(ServiceImpl.class.toString(),"Entering method: 'getTopParticipates', params: "+data.toString());
        if(data.getRequiredTopPlayers()<1){
            String errorMessage ="Error occurred, requested number of players is not valid";
            logger.info(errorMessage);
            throw new WrongDataException(errorMessage);
        }

        List<String> players = helper.getMostCommonPlayers(data);

        logger.debug(ServiceImpl.class.toString(),"Exiting method: 'getTopParticipates', result: "+players.toArray().toString());
        return players;
    }
}
