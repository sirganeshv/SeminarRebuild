package DB;

public final class DatabaseContract {
	private DatabaseContract() { }
	public static final String database_name = "seminar_hall_booking";
	public static final String password = "seminar";
	
	public static final class Bookings {
		public static final String table_name = "bookings";
		public static final String column_date = "dt";
		public static final String column_hallNumber = "hall_number";
	}
	
	public static final class SeminarHall {
		public static final String table_name = "seminar_hall";
		public static final String column_hallNumber = "hall_number";
		public static final String column_branch = "branch";
	}
}
