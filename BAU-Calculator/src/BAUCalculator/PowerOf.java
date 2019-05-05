package BAUCalculator;

import static java.lang.Math.pow;

public class PowerOf implements Calculation {

	@Override
	public double makeCalculation(double x, double y) {
		return pow(x,y);
	}

}
