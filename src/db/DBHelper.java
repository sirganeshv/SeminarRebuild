package db;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public interface DBHelper {
	public Map<Integer, String> getBookings(Date date,String hall);

	public Boolean book(Date bookingDate, String hall,int staffId); 
}
