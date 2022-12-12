package task_two;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	static EntityManagerFactory emf; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
	}
	
	public static void createTableAndInsertUsers() {
		   List<String> contents = new ArrayList<>();
	        List<User> users = new ArrayList<>();
	        EntityManagerFactory factory = Persistence.createEntityManagerFactory("user");
	        EntityManager manager = factory.createEntityManager();
	        EntityTransaction transaction = manager.getTransaction();

	        try {
	            transaction.begin();
	            contents = Files.lines(Paths.get("passwd.txt")).collect(Collectors.toList());
	            for(String content: contents) {
	                String[] fields = content.split(":");
	                User user = new User(fields[0], fields[1], Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), fields[4], fields[5], fields[6]);
	                users.add(user);
	            }
	            for (User user: users) {
	                manager.persist(user);
	            }
	            transaction.commit();

	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
	}
	
	public static User getUserData(String userName) {
		// implement 
		return null;
	}
	

}
