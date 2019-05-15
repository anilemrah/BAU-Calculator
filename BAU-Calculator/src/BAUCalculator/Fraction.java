package BAUCalculator;

public class Fraction {

	private int numerator;
	private int denominator;
	
	public Fraction(int num, int denom) {
		this.setNumerator(num);
		this.setDenominator(denom);
	}

	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
	
}

