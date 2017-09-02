package DB;
import DB.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DatabaseHelper implements DBHelper {
	
	private Connection DBConnection;
	private ResultSet result;
	private Map<Integer,Integer> bookings;
	private PreparedStatement displayStatement;
	private String displayString = "Select period,staff_id from " + DatabaseContract.Bookings.table_name + " where " +
		    DatabaseContract.Bookings.column_date + " = ? and " +
		    DatabaseContract.Bookings.column_hallNumber + " in (select " +
		    DatabaseContract.SeminarHall.column_hallNumber + " from " + 
		    DatabaseContract.SeminarHall.table_name + " where " + 
		    DatabaseContract.SeminarHall.column_branch + " = ? )";
	
	public DatabaseHelper() {
		try {
			DBConnection = DatabaseConnector.getConnection();
			displayStatement = DBConnection.prepareStatement(displayString);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Map<Integer,Integer> display(Date date,String hall) {
		try {
			SimpleDateFormat dateFormatter = new SimpleDateFormat("yy-MM-dd");
			String booking_date = dateFormatter.format(date);
			bookings = new HashMap<Integer,Integer>();
			System.out.println(booking_date);
			displayStatement.setString(1, booking_date);
			displayStatement.setString(2, hall);
			result = displayStatement.executeQuery();
			while(result.next()) {
				bookings.put(result.getInt(1),result.getInt(2));
			}
			return bookings;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookings;
	}
}
