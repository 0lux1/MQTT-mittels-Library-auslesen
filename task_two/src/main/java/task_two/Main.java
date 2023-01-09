package task_two;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.persistence.*;

public class Main {

	static EntityManagerFactory emf;

	static Scanner src = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean quit=true;
		do {
			System.out.println("-init = initialize Database\n" +
					"-s = search \n" +
					"q = quit");

			String temp = src.nextLine();
			if (temp.equals("-init")) {
				createTableAndInsertUsers("task_two/passwd.txt");
			} else if (temp.equals("-s")) {
				System.out.println("What user do you want to search");
				getUserData(src.nextLine());
			} else if (temp.equals("q")) {
				quit = false;
			}
		}while(quit);
	}

	public static void createTableAndInsertUsers(String textFile) {
		List<String> contents = new ArrayList<>();
		List<Person> users = new ArrayList<>();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("init-db");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			contents = Files.lines(Paths.get(textFile)).collect(Collectors.toList());
			for(String content: contents) {
				String[] fields = content.split(":");
				Person user = new Person(fields[0], fields[1], Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), fields[4], fields[5], fields[6]);
				manager.persist(user);
				users.add(user);
			}
			for (Person user: users) {
				manager.persist(user);
			}
			transaction.commit();

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void getUserData(String userName) {
		List<Person> users = new ArrayList<>();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("validate-db");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("Select p From Person as p Where p.username LIKE ?1");
		query.setParameter(1,"%" + userName + "%");
		users = query.getResultList();
		for(Person user: users){
			System.out.println(user.getFullname()+"\n"
					+user.getUsername()+"\n"
					+user.getHomeDirectory()+"\n"
					+user.getPassword()+"\n"
					+user.getShell()+"\n"
					+user.getGid()+"\n"
					+user.getId()+"\n"
					+user.getUid()+"\n---");
		}
	}
	

}
