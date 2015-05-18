import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JButton;

public class CalculatorEnginePostfix implements ActionListener {
	 
	 CalcPostfix parent; // a reference to the Calculator
	 int         action;//0,1
	 char        operation;
	 double      v_number=0,r_number=0;
		
	 // Constructor stores the reference to the 
	 // Calculator window in  the member variable parent
	 CalculatorEnginePostfix(CalcPostfix parent){
	   this.parent = parent;
	 }

	 public void actionPerformed(ActionEvent e){
	   String output;
	   double res;
	   JButton clickedButton =  (JButton) e.getSource();

	   String dispFieldText = parent.getDisplayValue();

	   String clickedButtonLabel = clickedButton.getText();
	   	
       if (clickedButtonLabel == "C" ) {dispFieldText = "";clickedButtonLabel = "";parent.setDisplayValue3("");}
       else if (clickedButtonLabel == "<-" ) {
    	   clickedButtonLabel = "";
    	   
    	   dispFieldText=dispFieldText.substring(0,dispFieldText.length()-1);
       }	   
       else if (clickedButtonLabel == "." )	 
    	   clickedButtonLabel = "";
       else if(clickedButtonLabel == "=") {
    	   //System.out.println("do =");
    	   clickedButtonLabel = "";           

       };
       
	   parent.setDisplayValue(dispFieldText + clickedButtonLabel);
       
	   //translate into polish notation
	   InToPost theTrans = new InToPost(parent.getDisplayValue());
       output = theTrans.doTrans(); // do the translation
       parent.setDisplayValue2(output);
	   ParsePost aParser = new ParsePost(parent.getDisplayValue2());
       
	   // calc result
	   if (clickedButton.getText()=="=") {
			   res = aParser.doParse();  // do the evaluation 
		       //System.out.println(res);
		       parent.setDisplayValue3(Double.valueOf(res).toString()); 
	   }
	 }
	} 