package BAUCalculator;

public class Sinus implements Calculation {

	@Override
	public double makeCalculation(double x, double y) {
        return Math.sin(x);
	}

}
