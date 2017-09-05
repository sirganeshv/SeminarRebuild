package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBHelper;
import db.DatabaseHelper;

public class Book extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		DBHelper dbhelper = new DatabaseHelper();
		String date = request.getParameter("booking-date");
		String hall = request.getParameter("hall");
		int staffId = Integer.parseInt(request.getParameter("staffId"));
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
		try {
			Date bookingDate = formatter.parse(date); 
			Boolean status = dbhelper.book(bookingDate,hall,staffId);
			if(status) {
				System.out.println("Successs");
			}
			else {
				System.out.println("Failure");
			}
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		//System.out.println("The date is "+ request.getParameter("booking-date") + request.getParameter("staffId"));
	}

}
