package birthdaybook;

public class BirthDay {
	private int day;
	private int month;

	public BirthDay(int month, int day) {
		if (month < 1 || month > 12 || day < 1 || day > 31) {
			throw new IllegalArgumentException();
		} else {
			this.month = month;
			this.day = day;
		}
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	@Override
	public String toString() {
		String m = "";
		if (month == 1) {
			m = "January";
		} else if (month == 2) {
			m = "February";
		} else if (month == 3) {
			m = "March";
		} else if (month == 4) {
			m = "April";
		} else if (month == 5) {
			m = "May";
		}

		else if (month == 6) {
			m = "June";
		} else if (month == 7) {
			m = "July";
		} else if (month == 8) {
			m = "August";
		} else if (month == 9) {
			m = "September";
		} else if (month == 10) {
			m = "October";
		} else if (month == 11) {
			m = "November";
		} else if (month == 12) {
			m = "December";
		}
		return m + " " + this.day;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BirthDay other = (BirthDay) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		return true;
	}

	// public boolean birthDayEquals(Object o) {
	// return this.day == ((BirthDay)o).day && this.month == ((BirthDay)o).month;
	// }
	/*
	 * @Override public boolean equals(Object obj) { if (this == obj) { return true;
	 * } if (obj == null || this.getClass() != obj.getClass()) { return false; }
	 * BirthDay other = (BirthDay) obj; return this.getMonth() == other.getMonth()
	 * && this.getDay() == other.getDay();
	 */
}


