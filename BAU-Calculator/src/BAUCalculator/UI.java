package BAUCalculator;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.*;

public class UI implements ActionListener {
	private final JFrame frame;
	private final JPanel panel;
	private final JPanel panel2;
	private final JTextArea text;
	private final JTextArea text2;
	private final JTextArea text3;
	private final JLabel label1;
	private final JLabel label2;
	private final JLabel label3;
	int index = -1;

	private final JButton but[], buttonAdd, buttonMinus, buttonMultiply, buttonDivide, buttonEqual, buttonCancel,
			buttonSquareRoot, buttonSquare, buttonOneDevidedBy, buttonCos, buttonSin, buttonTan, buttonxpowerofy,
			buttonlog, buttonrate, buttonShift, convertButton, buttonFr;
	private final JComboBox combobox1;
	private final JComboBox combobox2;
	private final JComboBox combobox3;
	private final Calculator calc;

	private final String[] buttonValue = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

	public UI() {
		frame = new JFrame("Calculator PH");
		frame.setResizable(false);
		panel = new JPanel(new FlowLayout());
		panel2 = new JPanel(new FlowLayout());

		text = new JTextArea(2, 25);
		text2 = new JTextArea(2, 25);
		text3 = new JTextArea(2, 25);
		label1 = new JLabel("Please select the type of unit you want to convert \n");
		label2 = new JLabel("From                                               \n");
		label3 = new JLabel("To                                                 \n");

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
		buttonShift = new JButton("SHIFT");
		convertButton = new JButton("Convert");
		buttonFr = new JButton("FR");

		combobox1 = new JComboBox();
		combobox2 = new JComboBox();
		combobox3 = new JComboBox();

		combobox1.addItem("Angle");
		combobox1.addItem("Time");
		combobox1.addItem("Temperature");
		combobox1.addItem("Length");

		buttonCancel = new JButton("C");

		calc = Calculator.getInstance();
	}

	public void init() {
		frame.setVisible(true);
		frame.setSize(330, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel2.setVisible(false);
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
		panel.add(buttonShift);
		panel.add(buttonEqual);
		panel.add(buttonCancel);
		panel.add(buttonFr);

		panel2.add(label1);
		panel2.add(combobox1);
		panel2.add(label2);
		panel2.add(text2);
		panel2.add(combobox2);
		panel2.add(label3);
		panel2.add(text3);
		panel2.add(combobox3);
		panel2.add(convertButton);

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
		buttonShift.addActionListener(this);
		buttonEqual.addActionListener(this);
		buttonCancel.addActionListener(this);
		buttonFr.addActionListener(this);

		combobox1.addActionListener(this);
		combobox2.addActionListener(this);
		combobox3.addActionListener(this);
		convertButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		final Object source = e.getSource();
		
		int temp = index;
		index = combobox1.getSelectedIndex();

		if(index != temp) {
			combobox2.removeAllItems();
			combobox3.removeAllItems();
		}
		
		for (int i = 0; i < 10; i++) {
			if (source == but[i]) {
				text.replaceSelection(buttonValue[i]);
				return;
			}
		}

		if (source == buttonAdd) {
			writer(calc.calculate(Calculator.getInstance().addState, reader()));
		}

		if (source == buttonMinus) {
			writer(calc.calculate(Calculator.getInstance().minusState, reader()));
		}

		if (source == buttonMultiply) {
			writer(calc.calculate(Calculator.getInstance().multiplyState, reader()));
		}

		if (source == buttonDivide) {
			writer(calc.calculate(Calculator.getInstance().divideState, reader()));
		}
		if (source == buttonxpowerofy) {
			writer(calc.calculate(Calculator.getInstance().powerOfState, reader()));
		}

		if (source == buttonSquare) {
			writer(calc.calculate(Calculator.getInstance().squareState, reader()));
		}

		if (source == buttonSquareRoot) {
			writer(calc.calculateAdvancedCalc(Calculator.getInstance().squareRootState, reader()));
		}

		if (source == buttonOneDevidedBy) {
			writer(calc.calculateAdvancedCalc(Calculator.getInstance().oneDividedByState, reader()));
		}

		if (source == buttonCos) {
			writer(calc.calculateAdvancedCalc(Calculator.getInstance().cosinusState, reader()));
		}

		if (source == buttonSin) {
			writer(calc.calculateAdvancedCalc(Calculator.getInstance().sinusState, reader()));
		}

		if (source == buttonTan) {
			writer(calc.calculateAdvancedCalc(Calculator.getInstance().tangentState, reader()));
		}
		if (source == buttonlog) {
			writer(calc.calculateAdvancedCalc(Calculator.getInstance().logState, reader()));
		}
		if (source == buttonrate) {
			writer(calc.calculateAdvancedCalc(Calculator.getInstance().rateState, reader()));
		}

		if (source == buttonEqual) {
			writer(calc.calculateEqual(reader()));
		}

		if (source == buttonCancel) {
			writer(calc.reset());
		}

		if (source == buttonShift) {
			panel.setVisible(false);
			panel2.setVisible(true);
			frame.add(panel2);

		}
		if(source == buttonFr) {
			double data = Double.parseDouble(text.getText());
			
		}
	
		
		if (source == convertButton) {

			String type = combobox1.getSelectedItem().toString();
			String from = combobox2.getSelectedItem().toString();
			String to = combobox3.getSelectedItem().toString();

			long data = Long.parseLong(text2.getText());
			ConvertionFactory convertionFactory = new ConvertionFactory();
			Convertion convert1 = convertionFactory.getConvertionType(type);
			String resultText = convert1.convert(data, from, to);
			text3.setText(resultText);

		}
		if (combobox2.getItemCount() == 0 && combobox3.getItemCount() == 0) {
			switch (index) {
			case 0:
				combobox2.addItem("Degree");
				combobox2.addItem("Radian");
				combobox3.addItem("Degree");
				combobox3.addItem("Radian");
				break;
			case 1:
				combobox2.addItem("Hour");
				combobox2.addItem("Minute");
				combobox2.addItem("Second");
				combobox2.addItem("Milisecond");
				combobox3.addItem("Hour");
				combobox3.addItem("Minute");
				combobox3.addItem("Second");
				combobox3.addItem("Milisecond");
				break;
			case 2:
				combobox2.addItem("Celcius");
				combobox2.addItem("Fahrenheit");
				combobox2.addItem("Kelvin");
				combobox3.addItem("Celcius");
				combobox3.addItem("Fahrenheit");
				combobox3.addItem("Kelvin");
				break;
			case 3:
				combobox2.addItem("Kilometer");
				combobox2.addItem("Meter");
				combobox2.addItem("Feet");
				combobox2.addItem("Mile");
				combobox3.addItem("Kilometer");
				combobox3.addItem("Meter");
				combobox3.addItem("Feet");
				combobox3.addItem("Mile");
				break;
			}
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
