package com.abysshal.wow.calendar.business;

import org.apache.mina.util.Base64;

import com.abysshal.wow.calendar.model.User;
import com.abysshal.wow.calendar.model.UserAuthToken;
import com.abysshal.wow.calendar.model.WeekSchedule;
import com.abysshal.wow.calendar.util.Utils;

public class AppBusiness {

	public static boolean regUser(User user) {
		if (UserManager.getInstant().getUserByUsername(user.getUsername()) != null) {
			return false;
		}
		UserManager.getInstant().createOrUpdate(user);
		return (UserManager.getInstant().getUserByUsername(user.getUsername()) != null);
	}

	public static void updateUser(User user) {
		UserManager.getInstant().createOrUpdate(user);
		return;
	}

	public static String authUserByPassword(String username, String password) {
		User user = UserManager.getInstant().getUserByUsername(username);
		if (user == null) {
			return null;
		}
		if (user.getPassword().equals(Utils.encodeBase64(password))) {
			return Utils.encodeAuthToken(new UserAuthToken(user.getUsername(),
					user.getPassword()));
		} else {
			return null;
		}
	}

	public static boolean authUserByToken(String token) {
		UserAuthToken uat = Utils.decodeAuthToken(token);
		if (uat == null) {
			return false;
		} else {
			User user = UserManager.getInstant().getUserByUsername(uat.getU());
			if (user == null) {
				return false;
			} else if (!user.getPassword().equals(uat.getP())) {
				return false;
			} else {
				return true;
			}
		}
	}

	public static void updateUserWeekSchedule(WeekSchedule weekSchedule) {
		return;
	}

	public static void checkTeamWeekSchedule() {

	}

}
