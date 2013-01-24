package com.abysshal.wow.calendar.business;

import java.io.File;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.abysshal.wow.calendar.model.TeamWeekSchedule;
import com.abysshal.wow.calendar.util.Utils;

public class TeamWeekScheduleManager {

	public static final String DEFAULT_USER_SCHEDULE_DB = "./db/schedule/default.json";

	private static TeamWeekScheduleManager teamScheduleManager;

	private TeamWeekSchedule teamWeekSchedule;
	private String userScheduleDB = DEFAULT_USER_SCHEDULE_DB;

	private TeamWeekScheduleManager() {
	}

	public static TeamWeekScheduleManager getInstant() {
		if (teamScheduleManager == null) {
			teamScheduleManager = new TeamWeekScheduleManager();
		}
		return teamScheduleManager;
	}

	public static TeamWeekSchedule load(String dbPath) {
		TeamWeekSchedule team = null;
		try {
			team = Utils.getObjectMapper().readValue(new File(dbPath),
					TeamWeekSchedule.class);
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
		return team;
	}

	public static boolean store(String dbPath, TeamWeekSchedule team) {
		try {
			Utils.getObjectMapper().writeValue(new File(dbPath), team);
			return true;
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
		return false;
	}

	public void loadCurrentWeek(String dbPath) {
		if (dbPath != null) {
			userScheduleDB = dbPath;
		}
		teamWeekSchedule = load(userScheduleDB);

		if (teamWeekSchedule == null) {
			teamWeekSchedule = new TeamWeekSchedule();
		}
	}

	public void storeCurrentWeek(String dbPath) {
		if (dbPath != null) {
			userScheduleDB = dbPath;
		}
		store(userScheduleDB, teamWeekSchedule);
	}

	public TeamWeekSchedule getTeamWeekSchedule() {
		return teamWeekSchedule;
	}

	public void setTeamWeekSchedule(TeamWeekSchedule teamWeekSchedule) {
		this.teamWeekSchedule = teamWeekSchedule;
	}

}
