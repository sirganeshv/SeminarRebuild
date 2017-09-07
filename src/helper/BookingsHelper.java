package helper;

import java.util.Map;

public class BookingsHelper {
	private Map<Integer,Integer> hallBookings = null;
	private int currentStaffId;
	
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
		Integer staffName = hallBookings.get(period);
	    if(staffName != null) return "Booked by "+staffName;
	    else return "Available";
	}

}
