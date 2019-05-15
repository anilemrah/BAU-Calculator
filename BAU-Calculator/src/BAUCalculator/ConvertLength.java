package BAUCalculator;
import java.math.*;


public class ConvertLength implements Convertion {

	@Override
	public String convert(double data,String from, String to) {
		// TODO Auto-generated method stub
		//kilometer, meter, mile, feet
		if(from.equalsIgnoreCase(Constants.KM)) {
			if(to.equalsIgnoreCase(Constants.FEET)) {
				//feet = kilometers × 3,280.839895
				data = data*3280;
			}
			else if(to.equalsIgnoreCase(Constants.MILE)) {	
				//mi = km * 0.62137
				data = data*0.62137;
			}
			else if(to.equalsIgnoreCase(Constants.METER)) {
				//m = km * 1000
				data = data*1000;
			}
		}
		else if(from.equalsIgnoreCase(Constants.FEET)) {
			if(to.equalsIgnoreCase(Constants.KM)) {
				data = data/3280;
			}
			else if(to.equalsIgnoreCase(Constants.MILE)) {
				//mi =ft * 0.00018939
				data = data*0.00018939;
			}
			else if(to.equalsIgnoreCase(Constants.METER)) {
				// m = ft / 32808
				data = data/3.2808;
				
			}
		}
		else if(from.equalsIgnoreCase(Constants.MILE)) {
			if(to.equalsIgnoreCase(Constants.KM)) {
				data = data*1.60934;
			}
			else if(to.equalsIgnoreCase(Constants.FEET)) {
				data = data*5280;
				
			}
			else if(to.equalsIgnoreCase(Constants.METER)) {
				data = data*160.934;
			}
		}
		else {
			if(to.equalsIgnoreCase(Constants.KM)) {
				data = data/1000;
			}
			else if(to.equalsIgnoreCase(Constants.FEET)) {
				data = data*3.281;
			}
			else if(to.equalsIgnoreCase(Constants.MILE)) {
				data = data/1609;
			}
			
		}
		return Double.toString(data);
	}

}
