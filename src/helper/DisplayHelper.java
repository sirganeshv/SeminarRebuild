package helper;

import java.util.Map;

import db.DBHelper;
import db.DBHelperImpl;

public class BookingsHelper {
	private Map<Integer,Integer> hallBookings = null;
	private int currentStaffId;
	private DBHelper dbhelper;
	
	public BookingsHelper() {
		dbhelper = new DBHelperImpl();
	}
	public int getCurrentStaffId() {
		return currentStaffId;
	}

	public void setCurrentStaffId(int currentStaffId) {
		this.currentStaffId = currentStaffId;
	}

	public Map<Integer, Integer> getHallBookings() {
		return hallBookings;
	}

	public void setHallBookings(Map<Integer, Integer> hallBookings) {
		this.hallBookings = hallBookings;
	}
	
	public String getStatus(int period) {
		Integer staffId = hallBookings.get(period);
		if(staffId != null) {
			if (staffId == getCurrentStaffId()) return "Booked by you";
			else if(staffId != null) return "Booked by " + dbhelper.getStaffByName(staffId);
		}
	    else return "Available";
		return null;
	}

}
