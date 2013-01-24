package com.abysshal.wow.calendar.model;

import java.util.List;
import java.util.Map;

public class TeamWeekSchedule {
	private Map<String, WeekSchedule> userSchedules;
	private long weekStartDate;
	private List<DayScheduleCount> dayCounts;

	public long getWeekStartDate() {
		return weekStartDate;
	}

	public void setWeekStartDate(long weekStartDate) {
		this.weekStartDate = weekStartDate;
	}

	public List<DayScheduleCount> getDayCounts() {
		return dayCounts;
	}

	public void setDayCounts(List<DayScheduleCount> dayCounts) {
		this.dayCounts = dayCounts;
	}

	public Map<String, WeekSchedule> getUserSchedules() {
		return userSchedules;
	}

	public void setUserSchedules(Map<String, WeekSchedule> userSchedules) {
		this.userSchedules = userSchedules;
	}

}
