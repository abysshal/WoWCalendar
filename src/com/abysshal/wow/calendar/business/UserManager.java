package com.abysshal.wow.calendar.business;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.type.TypeReference;

import com.abysshal.wow.calendar.model.User;
import com.abysshal.wow.calendar.util.Utils;

public class UserManager {

	public static final String DEFAULT_USER_DB = "./db/user.json";

	private static UserManager userManagerInstant;

	private Map<String, User> users;
	private String userDB = DEFAULT_USER_DB;

	private UserManager() {
		users = new HashMap<String, User>();
	}

	public static UserManager getInstant() {
		if (userManagerInstant == null) {
			userManagerInstant = new UserManager();
		}
		return userManagerInstant;
	}

	public void load(String dbPath) {
		if (dbPath != null) {
			userDB = dbPath;
		}
		users.clear();
		try {
			users = Utils.getObjectMapper().readValue(new File(userDB),
					new TypeReference<Map<String, User>>() {
					});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (users == null) {
			users = new HashMap<String, User>();
		}
	}

	public void store(String dbPath) {
		if (dbPath != null) {
			userDB = dbPath;
		}
		try {
			Utils.getObjectMapper().writeValue(new File(userDB), users);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public User getUserByUsername(String username) {
		return users.get(username);
	}

	public void createOrUpdate(User user) {
		if (users.containsKey(user.getUsername())) {
			users.remove(user.getUsername());
		}
		users.put(user.getUsername(), user);

		this.store(userDB);
	}

}
