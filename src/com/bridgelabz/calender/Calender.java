package com.bridgelabz.calender;

public class Calender {
	public static int day(int month, int day, int year) {
		int y0 = year - (14 - month) / 12;
		int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
		int m0 = month + 12 * ((14 - month) / 12) - 2;
		int d0 = (day + x + 31 * m0 / 12) % 7;
		return d0;
	}

	public static boolean isLeapYear(int year) {
		if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
			return true;
		}
		return false;

	}

	public static int[][] getCalendar(int month, int year) {

		int[] numberOfDays = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (month == 2 && isLeapYear(year))
			numberOfDays[month] = 29;

		int dayOfWeek = day(month, 1, year);
		int[][] calendar = new int[6][7];
		int week = 0;
		int dayInWeek = dayOfWeek;
		for (int date = 1; date <= numberOfDays[month]; date++) {
			calendar[week][dayInWeek] = date;
			dayInWeek++;
			if (((date + dayOfWeek) % 7 == 0) || (date == numberOfDays[month])) {
				week++;
				dayInWeek = 0;
			}
		}
		return calendar;
	}

	public static void main(String[] args) {
		int month = Integer.parseInt(args[0]);
		int year = Integer.parseInt(args[1]);
		int[][] calendar = getCalendar(month, year);
		System.out.println("Month: " + month + "	Year: " + year);
		System.out.println(" S  M Tu  W Th  F  S");
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.printf("%2d ", calendar[i][j]);
			}
			System.out.println();
		}
	}
}
