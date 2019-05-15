package BAUCalculator;

import static java.lang.Math.log10;

public class Log implements Calculation {

	@Override
	public double makeCalculation(double x, double y) {
        return log10(x);
	}

}
