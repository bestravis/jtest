package net.voovo.random;

import java.util.Date;
import java.util.UUID;

public class UTCTime {

	public static void main(String[] args) {
		java.util.Calendar cal = java.util.Calendar.getInstance(java.util.Locale.CHINA);
		System.out.println(cal.toInstant());
	}
}
