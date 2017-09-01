package DB;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import DB.DatabaseHelper;
public class Myclass {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		try {
			DBHelper dbhelper = new DatabaseHelper();
			Date bookingDate;
			String date = sc.next();
			String hall = sc.next();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
			bookingDate = formatter.parse(date);
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
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			sc.close();
		}
	}
}
