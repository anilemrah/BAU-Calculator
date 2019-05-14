package BAUCalculator;

public class Rate implements Calculation {

	@Override
	public double makeCalculation(double x, double y) {
        return x / 100;
	}

}
