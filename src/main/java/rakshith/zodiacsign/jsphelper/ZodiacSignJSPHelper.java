package rakshith.zodiacsign.jsphelper;

import javax.servlet.http.HttpServletRequest;

public class ZodiacSignJSPHelper {


	private String month;
	private String day;
	
	
	public ZodiacSignJSPHelper(HttpServletRequest request) {
		month = request.getParameter("month");
		day = request.getParameter("day");
	}
	public String isSelectedMonth(String month) {
		if(month == null)
			return "";
		return month.equals(this.month)? "selected" : "";
	}
	public String isSelectedDay(String day) {
		if(day == null)
			return "";
		return day.equals(this.day)? "selected" : "";
	}
}
