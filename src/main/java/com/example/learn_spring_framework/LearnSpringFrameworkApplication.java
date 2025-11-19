package com.example.learn_spring_framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.learn_spring_framework")
public class LearnSpringFrameworkApplication {

	private static final Logger log = LoggerFactory.getLogger(LearnSpringFrameworkApplication.class);

	public static void main(String[] args) {

		//log.info("testing info log ...");
		//ConfigurableApplicationContext applicationContext = SpringApplication.run(LearnSpringFrameworkApplication.class, args);
		//MarioGame game = new MarioGame();
		//TankGame game = new TankGame();
		//AircraftGame aircraftGame = applicationContext.getBean(AircraftGame.class);
		//GameRunner gameRunner = applicationContext.getBean(GameRunner.class);
		//gameRunner.run();
//		AircraftGame game = new AircraftGame();
//		GameRunner runner = new GameRunner(game);
//		runner.run();
		SpringApplication.run(LearnSpringFrameworkApplication.class, args);
	}

}
