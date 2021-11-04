package com.example.playmaker;

import com.example.playmaker.helper.Helper;
import com.example.playmaker.models.TopPlayersRequest;
import com.example.playmaker.services.ServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class PlaymakerApplicationTests {

	ServiceImpl service;
	Helper helper;

	@BeforeEach
	void init(){
		service = new ServiceImpl();
		helper = new Helper();

		service.setHelper(helper);
	}

	@Test
	void test() {
		TopPlayersRequest topPlayersRequest = new TopPlayersRequest();
		topPlayersRequest.setRequiredTopPlayers(2);
		ArrayList<ArrayList<String>> games = new ArrayList<>();
		ArrayList<String> playersInGame1 = new ArrayList<>();
		playersInGame1.add("Or");
		playersInGame1.add("Yaniv");
		playersInGame1.add("Eli");
		playersInGame1.add("Tal");
		games.add(playersInGame1);
		ArrayList<String> playersInGame2 = new ArrayList<>();
		playersInGame2.add("Or");
		playersInGame2.add("Yaniv");
		playersInGame2.add("Tal");
		games.add(playersInGame1);
		ArrayList<String> playersInGame3 = new ArrayList<>();
		playersInGame3.add("Or");
		playersInGame3.add("Eli");
		playersInGame3.add("Tal");
		games.add(playersInGame1);
		ArrayList<String> playersInGame4 = new ArrayList<>();
		playersInGame4.add("Or");
		playersInGame4.add("Tal");
		games.add(playersInGame4);

		topPlayersRequest.setParticipatedPlayers(games);

		service = new ServiceImpl();
		helper = new Helper();
		service.setHelper(helper);
		List<String> answer = service.getTopParticipates(topPlayersRequest);
		System.out.println("response: "+ answer);
		Assert.isTrue(answer.size()==topPlayersRequest.getRequiredTopPlayers(),"test failed, requested amount didn't matched by the answer");
	}

}
