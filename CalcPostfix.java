import javax.swing.*;

import java.awt.GridLayout;
import java.awt.BorderLayout;

public class CalcPostfix {

    // Declare all calculator's components.
	JPanel windowContent;
	JTextField displayField;
	JTextField displayFieldP;
	JTextField displayFieldRes;
	JButton buttonLb;
	JButton buttonRb;
	JButton buttonClearAll;
	JButton buttonClearOne;
	JButton button0;
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JButton button6;
	JButton button7;
	JButton button8;
	JButton button9;
	JButton buttonPoint;
	JButton buttonEqual;
	JButton buttonMinus;
	JButton buttonAdd;
	JButton buttonMultiply;
	JButton buttonDivide;
	JPanel p1;
	JPanel p2;
	
    public void setDisplayValue(String val){
        displayField.setText(val);
    }

    public String getDisplayValue() {
        return displayField.getText();
    } 
    public void setDisplayValue2(String val){
        displayFieldP.setText(val);
    }
    public void setDisplayValue3(String val){
        displayFieldRes.setText(val);
    }
    public String getDisplayValue2() {
        return displayFieldP.getText();
    }
    // Constructor  creates the components
      // and adds the to the frame using combination of 
      // Borderlayout and Gridlayout

    public CalcPostfix(){

	  windowContent= new JPanel();

	 // Set the layout manager for this panel
	  BorderLayout bl = new BorderLayout(); 
      windowContent.setLayout(bl);

       // Create the display field and place it in the   
       // North area of the window

	  displayField = new JTextField(30);
	  displayFieldP = new JTextField(30);
	  displayFieldRes = new JTextField(30);
	  displayField.setHorizontalAlignment(JTextField.RIGHT);
	  displayFieldP.setHorizontalAlignment(JTextField.RIGHT);
	  displayFieldRes.setHorizontalAlignment(JTextField.LEFT);

     // Create buttons using constructor of the  
     // class JButton that takes the label of the 
     // button as a parameter 
	  buttonLb = new JButton("(");
	  buttonRb = new JButton(")");
	  buttonClearAll = new JButton("C");
	  buttonClearOne = new JButton("<-");
	  buttonLb = new JButton("(");
	  button0=new JButton("0");
	  button1=new JButton("1");
	  button2=new JButton("2");
	  button3=new JButton("3");
	  button4=new JButton("4");
	  button5=new JButton("5");
	  button6=new JButton("6");
      button7=new JButton("7");
      button8=new JButton("8");
	  button9=new JButton("9");
	  buttonPoint = new JButton(".");
	  buttonEqual=new JButton("=");
	  buttonAdd=new JButton("+");
	  buttonMinus=new JButton("-");
	  buttonMultiply=new JButton("*");
	  buttonDivide=new JButton("/");
	 // Create the panel with the GridLayout with  buttons 
          
	  p1 = new JPanel();
	  GridLayout gl =new GridLayout(5,4); 
	  p1.setLayout(gl);

	 //  Add window controls to the panel p1
	  p1.add(buttonLb);
	  p1.add(buttonRb);
	  p1.add(buttonClearAll);
	  p1.add(buttonClearOne);
	  p1.add(button1);
	  p1.add(button2);
	  p1.add(button3);
	  p1.add(buttonAdd);		  
	  p1.add(button4);
	  p1.add(button5);
	  p1.add(button6);
	  p1.add(buttonMinus);
	  p1.add(button7);
	  p1.add(button8);
	  p1.add(button9);
	  p1.add(buttonMultiply);
	  p1.add(button0);
	  p1.add(buttonPoint);
	  p1.add(buttonEqual);
	  p1.add(buttonDivide);
	  
	  buttonDivide.setActionCommand("Divide");
	  buttonPoint.setEnabled(false);
	  // Add the panel p1 to the center of the window				          
      windowContent.add("Center",p1);     
      
	  p2 = new JPanel();
	  GridLayout g2 =new GridLayout(3,1); 
	  p2.setLayout(g2);
	  p2.add(displayField);
	  p2.add(displayFieldP);
	  p2.add(displayFieldRes);
	  windowContent.add("North",p2);
	  //Create the frame and set its content pane	               
	  JFrame frame = new JFrame("Calculator");
      frame.setContentPane(windowContent);

      //engine initialization
	  CalculatorEnginePostfix calcEngine = new CalculatorEnginePostfix(this);
	  buttonLb.addActionListener(calcEngine);
	  buttonRb.addActionListener(calcEngine);
	  buttonClearAll.addActionListener(calcEngine);
	  buttonClearOne.addActionListener(calcEngine);
	  button0.addActionListener(calcEngine);
	  button1.addActionListener(calcEngine);
	  button2.addActionListener(calcEngine);
	  button3.addActionListener(calcEngine);
	  button4.addActionListener(calcEngine);
	  button5.addActionListener(calcEngine);
	  button6.addActionListener(calcEngine);
	  button7.addActionListener(calcEngine);
	  button8.addActionListener(calcEngine);
	  button9.addActionListener(calcEngine);
	  buttonMultiply.addActionListener(calcEngine);
	  buttonAdd.addActionListener(calcEngine);
	  buttonMinus.addActionListener(calcEngine);
	  buttonPoint.addActionListener(calcEngine);
	  buttonEqual.addActionListener(calcEngine);
	  buttonDivide.addActionListener(calcEngine);
	  
	 // Set the size of the window to be big enough to accommodate all controls 		
      frame.pack(); 

	 // Display the window
	  frame.setVisible(true);
     }


     public static void main(String[] args) {

	  new CalcPostfix();
     
     }
}
