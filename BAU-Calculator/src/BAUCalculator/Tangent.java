package BAUCalculator;

public class Tangent implements Calculation {

	@Override
	public double makeCalculation(double x, double y) {
        return Math.tan(x);
	}

}
