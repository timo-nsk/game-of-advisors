package com.goa;

import org.springframework.boot.SpringApplication;

public class TestGameOfAdvisorsApplication {

	public static void main(String[] args) {
		SpringApplication.from(GameOfAdvisorsApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
