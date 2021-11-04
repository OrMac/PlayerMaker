package com.example.playmaker.services;

import com.example.playmaker.models.TopPlayersRequest;

import java.util.List;

@org.springframework.stereotype.Service
public interface Service {

    List<String> getTopParticipates(TopPlayersRequest data);

}
