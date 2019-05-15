package BAUCalculator;

public class ConvertTemperature implements Convertion {

	@Override
	public String convert(double data,String from, String to) {
		// TODO Auto-generated method stub
		//celcius, kelvin, fahrenheit 
		
		if(from.equalsIgnoreCase(Constants.CELCIUS)) {
			if(to.equalsIgnoreCase(Constants.FAHRENHEIT)) {
				
				//Fahrenheit = (9/5) * Celsius + 32
				data = ((float)9/5)*(data + 32);
				
			}
			else if(to.equalsIgnoreCase(Constants.KELVIN)){
				
				//Kelvin = ( °C + 273 )
				data = data + 273 ;
			}
		}
		else if(from.equalsIgnoreCase(Constants.FAHRENHEIT)) {
			if(to.equalsIgnoreCase(Constants.CELCIUS)) {
				
				//Celsius = (5/9) * (Fahrenheit – 32)
				data = ((float)5/9)*(data - 32);
			}
			else if(to.equalsIgnoreCase(Constants.KELVIN)) {
				
				//Kelvin = (Fahrenheit + 459)*(5/9)
				data = (data + 459)*((float)5/9);
			}
		}
		else if(from.equalsIgnoreCase(Constants.KELVIN)) {
			if(to.equalsIgnoreCase(Constants.CELCIUS)) {
				
				//Celcius = ( Kelvin - 273 )
				data = data - 273 ;
			}
			else if(to.equalsIgnoreCase(Constants.FAHRENHEIT)) {
				
				//Fahrenheit = Kelvin*(9/5) - 459
				data = data*((float)9/5) - 459 ;
			}
		}
		
		return Double.toString(data);
		
	}

}
