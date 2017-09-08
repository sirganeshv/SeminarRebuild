package db;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public interface DBHelper {
	public Map<Integer, Integer> getBookings(Date date,String hall);
	public Boolean book(Date bookingDate, String hall,int staffId);
	public String getStaffByName(int staffId);
	public Map<String,String> getSubjectsAndClasses(int staffId);
}
