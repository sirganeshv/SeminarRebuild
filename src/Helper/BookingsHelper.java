package Helper;

import java.util.Map;

public class BookingsHelper {
	private Map<Integer,Integer> hallBookings = null;

	public String getStaffId(int period) {
		int staffId = hallBookings.getOrDefault(period, -1);
	    if(staffId != -1) return String.valueOf(staffId);
	    else return "Available";
	}

	public Map<Integer, Integer> getHallBookings() {
		return hallBookings;
	}

	public void setHallBookings(Map<Integer, Integer> hallBookings) {
		this.hallBookings = hallBookings;
	}
	
}
