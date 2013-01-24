package com.abysshal.wow.calendar.model;

import java.util.List;

public class WeekSchedule {
	private long weekStartDate;
	private List<DaySchedule> days;

	public long getWeekStartDate() {
		return weekStartDate;
	}

	public void setWeekStartDate(long weekStartDate) {
		this.weekStartDate = weekStartDate;
	}

	public List<DaySchedule> getDays() {
		return days;
	}

	public void setDays(List<DaySchedule> days) {
		this.days = days;
	}
}
