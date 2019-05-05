package BAUCalculator;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class UI implements ActionListener {
	private final JFrame frame;
	private final JPanel panel;
	private final JTextArea text;
	private final JButton but[], buttonAdd, buttonMinus, buttonMultiply, buttonDivide, buttonEqual, buttonCancel,
			buttonSquareRoot, buttonSquare, buttonOneDevidedBy, buttonCos, buttonSin, buttonTan, buttonxpowerofy,
			buttonlog, buttonrate;
	private final Calculator calc;

	private final String[] buttonValue = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

	public UI() {
		frame = new JFrame("Calculator PH");
		frame.setResizable(false);
		panel = new JPanel(new FlowLayout());

		text = new JTextArea(2, 25);
		but = new JButton[10];
		for (int i = 0; i < 10; i++) {
			but[i] = new JButton(String.valueOf(i));
		}

		buttonAdd = new JButton("+");
		buttonMinus = new JButton("-");
		buttonMultiply = new JButton("*");
		buttonDivide = new JButton("/");
		buttonEqual = new JButton("=");
		buttonSquareRoot = new JButton("√");
		buttonSquare = new JButton("x*x");
		buttonOneDevidedBy = new JButton("1/x");
		buttonCos = new JButton("Cos");
		buttonSin = new JButton("Sin");
		buttonTan = new JButton("Tan");
		buttonxpowerofy = new JButton("x^y");
		buttonlog = new JButton("log10(x)");
		buttonrate = new JButton("x%");

		buttonCancel = new JButton("C");

		calc = Calculator.getInstance();
	}

	public void init() {
		frame.setVisible(true);
		frame.setSize(330, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);

		panel.add(text);

		for (int i = 1; i < 10; i++) {
			panel.add(but[i]);
			but[i].addActionListener(this);
		}
		panel.add(but[0]);
		but[0].addActionListener(this);

		panel.add(buttonAdd);
		panel.add(buttonMinus);
		panel.add(buttonMultiply);
		panel.add(buttonDivide);
		panel.add(buttonSquare);
		panel.add(buttonSquareRoot);
		panel.add(buttonOneDevidedBy);
		panel.add(buttonCos);
		panel.add(buttonSin);
		panel.add(buttonTan);
		panel.add(buttonxpowerofy);
		panel.add(buttonlog);
		panel.add(buttonrate);

		panel.add(buttonEqual);
		panel.add(buttonCancel);

		buttonAdd.addActionListener(this);
		buttonMinus.addActionListener(this);
		buttonMultiply.addActionListener(this);
		buttonDivide.addActionListener(this);
		buttonSquare.addActionListener(this);
		buttonSquareRoot.addActionListener(this);
		buttonOneDevidedBy.addActionListener(this);
		buttonCos.addActionListener(this);
		buttonSin.addActionListener(this);
		buttonTan.addActionListener(this);
		buttonxpowerofy.addActionListener(this);
		buttonlog.addActionListener(this);
		buttonrate.addActionListener(this);

		buttonEqual.addActionListener(this);
		buttonCancel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		final Object source = e.getSource();

		for (int i = 0; i < 10; i++) {
			if (source == but[i]) {
				text.replaceSelection(buttonValue[i]);
				return;
			}
		}

		if (source == buttonAdd) {
			writer(calc.calculateBi(Calculator.getInstance().addState, reader()));
		}

		if (source == buttonMinus) {
			writer(calc.calculateBi(Calculator.getInstance().minusState, reader()));
		}

		if (source == buttonMultiply) {
			writer(calc.calculateBi(Calculator.getInstance().multiplyState, reader()));
		}

		if (source == buttonDivide) {
			writer(calc.calculateBi(Calculator.getInstance().divideState, reader()));
		}
		if (source == buttonxpowerofy) {
			writer(calc.calculateBi(Calculator.getInstance().powerOfState, reader()));
		}

		if (source == buttonSquare) {
			writer(calc.calculateMono(Calculator.AdvancedCalculations.SQUARE, reader()));
		}

		if (source == buttonSquareRoot) {
			writer(calc.calculateMono(Calculator.AdvancedCalculations.SQUAREROOT, reader()));
		}

		if (source == buttonOneDevidedBy) {
			writer(calc.calculateMono(Calculator.AdvancedCalculations.ONEDIVIDEDBY, reader()));
		}

		if (source == buttonCos) {
			writer(calc.calculateMono(Calculator.AdvancedCalculations.COS, reader()));
		}

		if (source == buttonSin) {
			writer(calc.calculateMono(Calculator.AdvancedCalculations.SIN, reader()));
		}

		if (source == buttonTan) {
			writer(calc.calculateMono(Calculator.AdvancedCalculations.TAN, reader()));
		}
		if (source == buttonlog) {
			writer(calc.calculateMono(Calculator.AdvancedCalculations.LOG, reader()));
		}
		if (source == buttonrate) {
			writer(calc.calculateMono(Calculator.AdvancedCalculations.RATE, reader()));
		}

		if (source == buttonEqual) {
			writer(calc.calculateEqual(reader()));
		}

		if (source == buttonCancel) {
			writer(calc.reset());
		}

		text.selectAll();
	}

	public Double reader() {
		Double num;
		String str;
		str = text.getText();
		num = Double.valueOf(str);

		return num;
	}

	public void writer(final Double num) {
		if (Double.isNaN(num)) {
			text.setText("");
		} else {
			text.setText(Double.toString(num));
		}
	}
}
