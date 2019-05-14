package BAUCalculator;

public class Cosinus implements Calculation {

	@Override
	public double makeCalculation(double x, double y) {
        return Math.cos(x);
	}

}
