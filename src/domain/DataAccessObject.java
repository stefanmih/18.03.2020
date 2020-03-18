package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DataAccessObject {
	public List<User> usersList = new ArrayList<User>();
	private static DataAccessObject instance = null;
	public List<User> loggedUsers = new ArrayList<User>();

	private DataAccessObject() {
		super();
		usersList.add(new User("ime1", "prezime1", "admin", "admin"));
		usersList.add(new User("ime2", "prezime2", "user1", "user1"));
	}

	public void add(User p) {
		usersList.add(p);
	}

	public String getAll() {
		String html = "<th>Ime</th><th>Prezime</th>";
		for (User u : usersList) {
			html += "<tr>";
			html += "<td>" + u.getIme() + "</td>" + "<td>" + u.getPrezime() + "</td>" ;
			html += "</tr>";
		}
		return html;
	}

	public String getAllLogged() {
		String html = "<th>Ime</th><th>Prezime</th>";
		for (User p : loggedUsers) {
			if (p != null) {
				html += "<tr>";
				html += "<td>" + p.getIme() + "</td>" + "<td>" + p.getPrezime() + "</td>";
				html += "</tr>";
			}
		}
		return html;
	}

	public boolean delete(String ime) {
		User found = null;
		for (User p : usersList) {
			if (p.getIme().equals(ime))
				found = p;
		}
		if (found == null) {
			return false;
		} else {
			usersList.remove(found);
			return true;
		}
	}

	public User findLogged(String ime) {
		if (ime == null)
			return null;
		User found = null;
		for (User p : loggedUsers) {
			if (p.getUsername() != null)
				if (p.getUsername().equals(ime))
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

	public boolean findUser(String username, String password) {
		if (username != null && password != null) {
			for (User z : usersList) {
				if (z.getUsername().equals(username) && z.getPassword().equals(password)) {
					return true;
				}

			}
		}
		return false;
	}

	public boolean isLogged(String parameter) {
		return (findLogged(parameter) != null);
	}

	public void addLoggedUser(String parameter) {
		User u = usersList.get(usersList.indexOf(this.find(parameter)));
		loggedUsers.add(u);

	}

	private User find(String parameter) {
		for (User u : usersList) {
			if (u.getUsername().equals(parameter))
				return u;
		}
		return null;
	}

}
