package db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import db.DatabaseConnector;

public class DBHelperImpl implements DBHelper {
	
	private Connection DBConnection;
	private ResultSet result;
	private Map<Integer,Integer> bookings;
	private PreparedStatement statement;
	private String displayStatement = "Select " + 
			DatabaseContract.Bookings.column_period + "," +
			DatabaseContract.Bookings.column_staff_id +" from " + 
			DatabaseContract.Bookings.table_name + " where " +
		    DatabaseContract.Bookings.column_date + " = ? and " +
		    DatabaseContract.Bookings.column_hallNumber + " in (select " +
		    DatabaseContract.SeminarHall.column_hallNumber + " from " + 
		    DatabaseContract.SeminarHall.table_name + " where " + 
		    DatabaseContract.SeminarHall.column_branch + " = ? ) order by period";
	private String bookStatement = "insert into " + 
		    DatabaseContract.Bookings.table_name +"(" + 
		    DatabaseContract.Bookings.column_date + "," + 
		    DatabaseContract.Bookings.column_period + "," + 
		    DatabaseContract.Bookings.column_hallNumber + "," + 
		    DatabaseContract.Bookings.column_staff_id + ") values(?,?,101,?)";
	
	public DBHelperImpl() {
		try {
			DBConnection = DatabaseConnector.getConnection();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Map<Integer,Integer> getBookings(Date date,String hall) {
		try {
			statement = DBConnection.prepareStatement(displayStatement);
			SimpleDateFormat dateFormatter = new SimpleDateFormat("yy-MM-dd");
			String booking_date = dateFormatter.format(date);
			bookings = new HashMap<Integer,Integer>();
			System.out.println(booking_date);
			statement.setString(1, booking_date);
			statement.setString(2, hall);
			result = statement.executeQuery();
			while(result.next()) {
				bookings.put((Integer)result.getInt(1),Integer.parseInt(result.getString(2)));
			}
			return bookings;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookings;
	}
	
	public Boolean book(Date date,String hall,int staffId) {
		try {
			statement = DBConnection.prepareStatement(bookStatement);
			SimpleDateFormat dateFormatter = new SimpleDateFormat("yy-MM-dd");
			String booking_date = dateFormatter.format(date);
			statement.setString(1, booking_date);
			statement.setInt(2, 3);
			statement.setInt(3, staffId);
			statement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
