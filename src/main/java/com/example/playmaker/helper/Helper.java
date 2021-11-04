package com.example.playmaker.helper;

import com.example.playmaker.controllers.ControllerImpl;
import com.example.playmaker.models.TopPlayersRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Helper {

    Logger logger =  LoggerFactory.getLogger(ControllerImpl.class);

    public List<String> getMostCommonPlayers(TopPlayersRequest data) {
        logger.debug("Helper","entering method: 'getMostCommonPlayers'");
        //key = player name , value = how many games he played
        HashMap<String,Integer> playerAppearance = new HashMap<>();

        //fill playerAppearance from data
        for (ArrayList<String> players : data.getParticipatedPlayers()) {
            for (String player: players) {
                if(!playerAppearance.containsKey(player)){
                    //add the new player if not exist
                    playerAppearance.put(player,1);
                }else{
                    //increment the player value
                    playerAppearance.put(player,playerAppearance.get(player)+1);
                }
            }
        }

        //sort
        List<String> topPlayers = new ArrayList<>(playerAppearance.keySet());

        Collections.sort(topPlayers,new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(playerAppearance.get(o1)>playerAppearance.get(o2)){
                    return -1;
                }else if(playerAppearance.get(o1)<playerAppearance.get(o2)){
                    return 1;
                }else{
                    return 0;
                }
            }
        });

        int numberOfPlayersToReturn = data.getRequiredTopPlayers();
        if(numberOfPlayersToReturn>topPlayers.size())
            numberOfPlayersToReturn=topPlayers.size();
        String[] players = Arrays.copyOf(Arrays.copyOfRange(topPlayers.toArray(), 0, numberOfPlayersToReturn), numberOfPlayersToReturn, String[].class);

        logger.debug("Helper","exiting method: 'getMostCommonPlayers'"+players);
        return Arrays.asList(players);
    }
}
