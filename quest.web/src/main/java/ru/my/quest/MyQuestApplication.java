package ru.my.quest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class MyQuestApplication {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		SpringApplication.run(MyQuestApplication.class, args);
	}


}
