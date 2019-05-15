package BAUCalculator;
import java.math.*;

public class ConvertAngle implements Convertion {

	@Override
	public String convert(double data, String from, String to) {
		// TODO Auto-generated method stub
		//degree, radian
		
		if(from.equalsIgnoreCase(Constants.DEGREE)){
			if(to.equalsIgnoreCase(Constants.RADIAN)) {
				data = data*((float)Math.PI/180);				
			}
		}
		else {
			if(to.equalsIgnoreCase(Constants.DEGREE)) {
				data = data*((float)180/Math.PI);
			}
		}
		return Double.toString(data);
	}
}
