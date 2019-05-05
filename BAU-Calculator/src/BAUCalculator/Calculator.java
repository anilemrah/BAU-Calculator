package BAUCalculator;

import static java.lang.Math.log10;
import static java.lang.Math.pow;


public class Calculator {
	
	//Singleton Calculator Object Is Here!
	private static Calculator instance = new Calculator();
	
	public static Calculator getInstance() {
		return instance;
	}
	
	public Calculation normalState;
	public Calculation addState;
	public Calculation minusState;
	public Calculation divideState;
	public Calculation multiplyState;
	public Calculation powerOfState;
	

	public Calculation state1;
	
    public Calculation getState() {
		return state1;
	}

	public void setState1(Calculation state1) {
		this.state1 = state1;
	}

	int count = 0;

    public Calculator() {
    	normalState = new Normal();
    	addState = new Add();
    	minusState = new Minus();
    	divideState = new Divide();
    	multiplyState = new Multiply();
    	powerOfState = new PowerOf();

    	setState1(normalState);
    }

    public enum AdvancedCalculations {
        SQUARE, SQUAREROOT, ONEDIVIDEDBY, COS, SIN, TAN ,LOG, RATE
    }

    private Double num1, num2;

    private Double calculateBasicCalc() {	
    	return state1.makeCalculation(num1, num2);
    }

    public Double calculateBi(Calculation newState1, Double num) {
        if (getState() == normalState) {
            num2 = 0.0;
            num1 = num;
            setState1(newState1);
            return Double.NaN;
        } else {
            num2 = num;
            num1 = calculateBasicCalc();
            setState1(newState1);
            return num1;
        }
    }

    public Double calculateEqual(Double num) {
        return calculateBi(normalState, num);
    }

    public Double reset() {
        num2 = 0.0;
        num1 = 0.0;
        setState1(normalState);

        return Double.NaN;
    }

    public Double calculateMono(AdvancedCalculations newMode, Double num) {
        if (newMode == AdvancedCalculations.SQUARE) {
            return num * num;
        }
        if (newMode == AdvancedCalculations.SQUAREROOT) {
            return Math.sqrt(num);
        }
        if (newMode == AdvancedCalculations.ONEDIVIDEDBY) {
            return 1 / num;
        }
        if (newMode == AdvancedCalculations.COS) {
            return Math.cos(num);
        }
        if (newMode == AdvancedCalculations.SIN) {
            return Math.sin(num);
        }
        if (newMode == AdvancedCalculations.TAN) {
            return Math.tan(num);
        }
        if (newMode == AdvancedCalculations.LOG) {
            return log10(num);
        }
        if (newMode == AdvancedCalculations.RATE) {
           return num / 100;
        }
        


        // never reach
        throw new Error();
    }

}
