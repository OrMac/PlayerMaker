package com.example.playmaker.models;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class TopPlayersRequest {

    @Getter
    @Setter
    private int requiredTopPlayers;

    @Getter
    @Setter
    private ArrayList<ArrayList<String>> participatedPlayers;

    @Override
    public String toString() {
        return "{" +
                "numberOfPlayers=" + requiredTopPlayers +
                ", gamesParticipates=" + participatedPlayers +
                '}';
    }
}
