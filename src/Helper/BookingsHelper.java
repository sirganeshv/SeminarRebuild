package Helper;

import java.util.Map;

public class BookingsHelper {
	private Map<Integer,String> hallBookings = null;

	public String getStatus(int period) {
		String staffName = hallBookings.get(period);
	    if(staffName != null) return "Booked by "+staffName;
	    else return "Available";
	}

	public Map<Integer, String> getHallBookings() {
		return hallBookings;
	}

	public void setHallBookings(Map<Integer, String> hallBookings) {
		this.hallBookings = hallBookings;
	}
	
}
