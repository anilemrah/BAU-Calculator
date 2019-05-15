package BAUCalculator;
import java.text.DateFormat; 
import java.text.SimpleDateFormat; 
import java.util.Date; 

public class ConvertTime implements Convertion {

	@Override
	public String convert(double data,String from, String to) {
		// TODO Auto-generated method stub
		// milliseconds to date  
        long miliSec =(long) data; 
  
        // Creating date format 
        DateFormat simple = new SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z"); 
  
        // Creating date from milliseconds 
        // using Date() constructor 
        Date result = new Date(miliSec); 

        return simple.format(result);

	}

}
