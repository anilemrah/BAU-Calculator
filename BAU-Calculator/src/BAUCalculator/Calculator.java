package BAUCalculator;

public class Calculator {
	
	//Singleton Calculator Object Is Here!
	private static Calculator instance = new Calculator();
	
	public static Calculator getInstance() {
		return instance;
	}
	
	//Basic Calculation Objects
	public Calculation normalState;
	public Calculation addState;
	public Calculation minusState;
	public Calculation divideState;
	public Calculation multiplyState;
	public Calculation powerOfState;
	
	//Advanced Calculation Objects
	public Calculation squareState;
	public Calculation squareRootState;
	public Calculation oneDividedByState;
	public Calculation cosinusState;
	public Calculation sinusState;
	public Calculation tangentState;
	public Calculation logState;
	public Calculation rateState;
	
	public Calculation state1;
	
	int count = 0;
	
    private Double num1, num2;
	
    public Calculation getState() {
		return state1;
	}

	public void setState1(Calculation state1) {
		this.state1 = state1;
	}

	//TO:DO Lazy singleton import is required here
    public Calculator() {
    	//Fill the Basic Calculation Objects
    	normalState = new Normal();
    	addState = new Add();
    	minusState = new Minus();
    	divideState = new Divide();
    	multiplyState = new Multiply();
    	powerOfState = new PowerOf();
    	
    	//Fill the Advanced Calculation Objects
    	squareState = new Square();
    	squareRootState = new SquareRoot();
    	oneDividedByState = new OneDividedBy();
    	cosinusState = new Cosinus();
    	sinusState = new Sinus();
    	tangentState = new Tangent();
    	logState = new Log();
    	rateState = new Rate();

    	setState1(normalState);
    }
    
    public Double calculate(Calculation newState1, Double num) {
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
    /**
     * This method calculates the basic calculations
     * @return result
     */
    private Double calculateBasicCalc() {	
    	// We can use null object pattern for this
    	if (state1 != null) {
    		return state1.makeCalculation(num1, num2);
    	}
    	//Error case
    	return (double) 0;
    }
    
    /**
     * This method calculates the advanced calculations
     * calls the makeCalculation with second input equals zero
     * because this calculations doesn't need second input
     * Can be change with another pattern, because it is different
     * @return result
     */
    public Double calculateAdvancedCalc(Calculation newState1, Double num) {
    	// We can use null object pattern for this
    	if (newState1 != null) {
    		return newState1.makeCalculation(num, 0);
    	}
    	//Error case
    	return (double) 0;
    }

    public Double calculateEqual(Double num) {
        return calculate(normalState, num);
    }

    public Double reset() {
        num2 = 0.0;
        num1 = 0.0;
        setState1(normalState);

        return Double.NaN;
    }
}
