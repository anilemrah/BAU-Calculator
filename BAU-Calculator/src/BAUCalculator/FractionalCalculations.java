package BAUCalculator;

public class FractionalCalculations extends Fraction {

	public FractionalCalculations(int num, int denom) {
		super(num, denom);
		// TODO Auto-generated constructor stub
	}
	
	public Fraction add(Fraction num) {
		
		int numer = (this.getNumerator()*num.getDenominator() + 
				 this.getDenominator()*num.getNumerator());
		
		int denom = (this.getDenominator()+num.getDenominator());
				
	    return new Fraction(numer,denom); 
	}
	
	public Fraction minus(Fraction num) {
		
		int numer = (this.getNumerator()*num.getDenominator() - 
				 this.getDenominator()*num.getNumerator());
		
		int denom = (this.getDenominator()+num.getDenominator());
				
	    return new Fraction(numer,denom); 
	}
	
	public Fraction multiply(Fraction num) {
		
		int numer = this.getNumerator()*num.getNumerator();
		
		int denom = this.getDenominator()*num.getDenominator();
				
	    return new Fraction(numer,denom); 
	}
	
	public Fraction divide(Fraction num) {
		
		int numer = this.getNumerator()*num.getDenominator();
		
		int denom = this.getDenominator()*num.getNumerator();
				
	    return new Fraction(numer,denom); 
	}
	
	public float FracToDec(Fraction fr) {
		
		int num = fr.getNumerator();
		int denom = fr.getDenominator();
		float dec = (float)(num/denom);
		
		return dec;
	}
	
}
