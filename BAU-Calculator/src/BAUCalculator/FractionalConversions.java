package BAUCalculator;
import java.math.*;

public class FractionalConversions extends Fraction {

	public FractionalConversions(int num, int denom) {
		super(num, denom);
		// TODO Auto-generated constructor stub
	}
	
	public float FracToDec(Fraction fr) {
		
		int num = fr.getNumerator();
		int denom = fr.getDenominator();
		float dec = (float)(num/denom);
		
		return dec;
	}
}
