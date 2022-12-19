package task_two;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

	public Person(String username, String password, int uid, int gid, String fullname, String homeDirectory,
				String shell) {
		super();
		this.username = username;
		this.password = password;
		this.uid = uid;
		this.gid = gid;
		this.fullname = fullname;
		this.homeDirectory = homeDirectory;
		this.shell = shell;
	}
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private String username;
	private String password;
	private int uid;
	private int gid;
	private String fullname;
	private String homeDirectory;
	private String shell;

	public Person() {

	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getHomeDirectory() {
		return homeDirectory;
	}
	public void setHomeDirectory(String homeDirectory) {
		this.homeDirectory = homeDirectory;
	}
	public String getShell() {
		return shell;
	}
	public void setShell(String shell) {
		this.shell = shell;
	}



}