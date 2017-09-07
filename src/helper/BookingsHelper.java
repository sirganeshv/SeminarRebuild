package helper;

import java.util.Map;

public class BookingsHelper {
	private Map<Integer,String> hallBookings = null;
	private int currentStaffId;
	
	public int getCurrentStaffId() {
		return currentStaffId;
	}

	public void setCurrentStaffId(int currentStaffId) {
		this.currentStaffId = currentStaffId;
	}

	public Map<Integer, String> getHallBookings() {
		return hallBookings;
	}

	public void setHallBookings(Map<Integer, String> hallBookings) {
		this.hallBookings = hallBookings;
	}
	
	public String getStatus(int period) {
		String staffName = hallBookings.get(period);
	    if(staffName != null) return "Booked by "+staffName;
	    else return "Available";
	}

}
