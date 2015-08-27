import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame {
    private JButton add = new JButton("+");
    private JButton sub = new JButton("-");
    private JButton mul = new JButton("*");
    private JButton div = new JButton("/");
    private JButton ok  = new JButton("OK");
    private JTextField num1 = new JTextField("");
    private JTextField op = new JTextField("");
    private JTextField num2 = new JTextField("");
    private JTextField equal = new JTextField("=");
    private JTextField Result = new JTextField("");
    
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    
    private GridLayout gridLayout = new GridLayout(1,5);
    private void initP2() {
        gridLayout.setVgap(5);
        panel2.setLayout(gridLayout);
   	panel2.add(num1);
   	num1.setHorizontalAlignment(JTextField.CENTER);
        panel2.add(op);
	op.setEditable(false);
	op.setHorizontalAlignment(JTextField.CENTER);
	panel2.add(num2);
	num2.setHorizontalAlignment(JTextField.CENTER);
	panel2.add(equal);
	equal.setEditable(false);
	equal.setHorizontalAlignment(JTextField.CENTER);
	panel2.add(Result);
	Result.setHorizontalAlignment(JTextField.CENTER);
    }
    private void initP3() {
        gridLayout.setHgap(5);
	panel3.setLayout(gridLayout);
	panel3.add(add);
	panel3.add(sub);
	panel3.add(mul);
	panel3.add(div);
	panel3.add(ok);
    }
    class ActionHandler implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		boolean right = true;
    		if (e.getSource() == add) op.setText("+");
    		if (e.getSource() == sub) op.setText("-");
    		if (e.getSource() == mul) op.setText("*");
    		if (e.getSource() == div) op.setText("/");
    		if (e.getSource() == ok) {
    			if (num1.getText() != "" && num2.getText() != "" && op.getText() != "") {
    				int number1 = Integer.valueOf(num1.getText());
    				int number2 = Integer.valueOf(num2.getText());
    				String s = op.getText();
    				int result = 0;
    				switch(s) {
    					case "+":
    						result = number1+number2;
    						break;
    					case "-":
    						result = number1-number2;
    						break;
    					case "*":
    						result = number1*number2;
    						break;
    					case "/":
    						if (number2 != 0)
    							result = number1/number2;
    						else 
    							right = false;
    						break;
    					default: break;
    				}
    				if (right)
    				Result.setText(String.valueOf(result));
    				else
    				Result.setText("Wrong!");
    			} else {
    				System.exit(0);
    			}
    		}
    	}
    }
    private void addActionListeners() {
    	ActionHandler actionHandler = new ActionHandler();
    	add.addActionListener(actionHandler);
    	sub.addActionListener(actionHandler);
    	mul.addActionListener(actionHandler);
    	div.addActionListener(actionHandler);
    	ok.addActionListener(actionHandler);
    }
    public Calculator() {
    GridLayout gridlayout = new GridLayout(2,1);
	panel1.setLayout(gridlayout);
	initP2();
	initP3();
	panel1.add(panel2);
	panel1.add(panel3);
	gridlayout.setVgap(5);
	getContentPane().add(panel1);
	setSize(300,160);
	setLocation(0,0);
	setVisible(true);
	addActionListeners();
	setDefaultCloseOperation(Calculator.EXIT_ON_CLOSE);
	this.setTitle("Easy Calculator");
    }
    public static void main(String[] args) {
	Calculator c = new Calculator();
    }
}
