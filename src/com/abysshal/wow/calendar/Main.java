package com.abysshal.wow.calendar;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.type.TypeReference;

import com.abysshal.wow.calendar.model.DaySchedule;
import com.abysshal.wow.calendar.model.User;
import com.abysshal.wow.calendar.model.WeekSchedule;
import com.abysshal.wow.calendar.util.Utils;

public class Main {

	public static void main(String[] args) {

	}

	public static void test1() {
		User user = new User();
		user.setEmail("aby@gamil.com");
		user.setMobilephone("186");
		user.setNickname("tt");
		user.setPassword("aa");
		user.setSinaWeibo("abysshal");
		user.setUsername("abysshal");

		WeekSchedule userWeekSchedule = new WeekSchedule();
		// userWeekSchedule.setUsername("abysshal");
		userWeekSchedule.setWeekStartDate(100000l);
		List<DaySchedule> days = new ArrayList<DaySchedule>();
		Map<String, DaySchedule> daymap = new HashMap<String, DaySchedule>();
		for (int i = 0; i < 7; i++) {
			DaySchedule daySchedule = new DaySchedule();
			daySchedule.setF9ht12h(true);
			daySchedule.setF13ht16h(false);
			daySchedule.setF20ht23h(true);
			days.add(daySchedule);
			daymap.put(String.valueOf(i), daySchedule);
		}
		userWeekSchedule.setDays(days);

		try {
			Utils.getObjectMapper().writeValue(new File("user.json"), user);
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

		try {
			Utils.getObjectMapper().writeValue(new File("userweek.json"),
					userWeekSchedule);
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

		try {
			Utils.getObjectMapper()
					.writeValue(new File("usermap.json"), daymap);
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

		try {
			Map<String, DaySchedule> readmap = Utils.getObjectMapper()
					.readValue(new File("usermap.json"),
							new TypeReference<Map<String, DaySchedule>>() {
							});
			System.out.println(readmap.size() + "\n"
					+ (readmap.get("1")).isF13ht16h());
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
	}
}
