package Display;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.DBHelper;
import DB.DatabaseHelper;

public class Display extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException,IOException {
		DBHelper dbhelper = new DatabaseHelper();
		String date = request.getParameter("booking-date");
		String hall = request.getParameter("hall");
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
		try {
			Date bookingDate = formatter.parse(date); 
			ArrayList <String> arrayList = dbhelper.display(bookingDate,hall);
			if(arrayList.isEmpty()) {
				System.out.println("No one has booked yet");
			}
			else {
				Iterator<String> iter = arrayList.iterator();
				for(;iter.hasNext();) {
					System.out.println(arrayList.get(0));
					arrayList.remove(0);
				}
			}
		}
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
