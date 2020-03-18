package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DataAccessObject {
	List<User> list;
	private static DataAccessObject instance = null;
	public static Map<String, String> users = new TreeMap<String, String>();
	public static Map<String, String> loggedUsers = new TreeMap<String, String>();

	private DataAccessObject() {
		super();
		list = new ArrayList<User>();
		list.add(new User("ime1", "prezime1", "user1", "pw1"));
		list.add(new User("ime2", "prezime2", "user2", "pw2"));
		users.put("admin", "admin");
		users.put("user1", "user1");
	}

	public void add(User p) {
		list.add(p);
	}

	public String getAll() {
		String html = "<th>Ime</th><th>Prezime</th>";
		for (User p : list) {
			html += "<tr>";
			html += "<td>" + p.getIme() + "</td>" + "<td>" + p.getPrezime() + "</td>";
			html += "</tr>";
		}
		return html;
	}
	
	public String getAllLogged() {
		String html = "<th>Username</th><th>Password</th>";
		for (Map.Entry<String, String> entry : loggedUsers.entrySet()) {
			html += "<tr>";
			html += "<td>" + entry.getKey() + "</td>" + "<td>" + entry.getValue() + "</td>";
			html += "</tr>";
		}
		return html;
	}

	public boolean delete(String ime) {
		User found = null;
		for (User p : list) {
			if (p.getIme().equals(ime))
				found = p;
		}
		if (found == null) {
			return false;
		} else {
			list.remove(found);
			return true;
		}
	}

	public User find(String ime) {
		User found = null;
		for (User p : list) {
			if (p.getIme().equals(ime))
				found = p;
		}
		if (found == null) {
			return null;
		} else {
			return found;
		}
	}

	public static DataAccessObject getInstance() {
		if (instance == null) {
			instance = new DataAccessObject();
		}
		return instance;
	}

	public static boolean findUser(String username, String password) {
		System.out.println(users.toString());
		if (username != null && password != null) {
			if (users.containsKey(username)) {
				System.out.println("Ima");
				if (users.get(username).equals(password))
					return true;
				else
					return false;
			}

			else
				return false;
		} else
			return false;
	}

	public static boolean isLogged(String parameter) {
		if (parameter != null)
			return loggedUsers.containsKey(parameter);
		else
			return false;
	}

	public static void addLoggedUser(String parameter, String parameter2) {
		loggedUsers.put(parameter, parameter2);

	}

}
