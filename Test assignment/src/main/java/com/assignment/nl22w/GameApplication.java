package com.assignment.nl22w;

import com.assignment.nl22w.game.impl.GameImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;

@SpringBootApplication
public class GameApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameApplication.class, args);
		Resource resource = new ClassPathResource("map3.txt");
		GameImpl game = new GameImpl();
		try {
			game.escapeFromTheWoods(resource);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}
}
