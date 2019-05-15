package BAUCalculator;

public class ConvertionFactory {
	
	public Convertion getConvertionType(String type) {
		
		if(type.equals(null)){
	         return null;
	      }		
	      if(type.equalsIgnoreCase(Constants.TIME)){
	         return new ConvertTime();
	         
	      } else if(type.equalsIgnoreCase(Constants.LENGTH)){
	         return new ConvertLength();
	         
	      } else if(type.equalsIgnoreCase(Constants.TEMPERATURE)){
	         return new ConvertTemperature();
	         
	      } else if(type.equalsIgnoreCase(Constants.ANGLE)){
	    	 return new ConvertAngle();
          }
	      return null; 
	}

}
