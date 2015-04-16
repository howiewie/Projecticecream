package pos;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

import javax.swing.JOptionPane;

public class PosInterface extends Applet implements WindowListener,ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GridBagLayout gbaglayout;
	GridBagConstraints constraints;
    private int icecreamAmt = 0;
    private int decoratorAmt = 0;
    private int totalAmt = 0;
    private int decoratorLimit = 0;
    private String icecreamText = "?";
    private String decoratorText = "";
   
	 public static void main(String args[]) {
		Frame frame = new Frame("PosInterface");
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		PosInterface demo = new PosInterface();
		demo.init();
		frame.setTitle("Ice Cream POS"); 
		frame.add(BorderLayout.NORTH, demo);
		frame.setSize(640, 480);
		frame.setResizable(false);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
//	    iIcecream iiicecream = new MnMDecorator(new StrawberryDecorator(new ChocolateIcecream()));
//	    System.out.println(icecream.makeIcecream());
	 }
	 
		private void makeButton(GridBagLayout gbaglayout, GridBagConstraints constraints, Component component) {
			gbaglayout.setConstraints(component, constraints);
			add(component);
		}
	  
		public PosInterface() {

			gbaglayout = new GridBagLayout();
			constraints = new GridBagConstraints();
			setLayout(gbaglayout);
			
			//Title 01 - Icecream Flavor
			Label lb11 = new Label("ICE-CREAM Flavor");
			constraints.gridx = 0;
			constraints.gridy = 0;
			constraints.fill = GridBagConstraints.HORIZONTAL;
			constraints.anchor = GridBagConstraints.CENTER;
			makeButton(gbaglayout, constraints, lb11);

			//Title 02 - Decorator
			Label lbl2 = new Label("Decorator");
			constraints.gridx = 1;
			constraints.gridy = 0;
			constraints.anchor = GridBagConstraints.CENTER;
			makeButton(gbaglayout, constraints, lbl2);
			
			//Result 01 - Icecream Deatil
			Label lbl3 = new Label("You choosed " + icecreamText + " Ice-cream " + decoratorText);
			constraints.gridx = 0;
			constraints.gridy = 10;
			constraints.gridwidth = 4;
			constraints.anchor = GridBagConstraints.WEST;
			makeButton(gbaglayout, constraints, lbl3);
			
			//Result 02 - Total Amt
			Label lbl4 = new Label("Total: $ " + icecreamAmt);
			constraints.gridx = 0;
			constraints.gridy = 12;
			constraints.gridwidth = 3;
			constraints.anchor = GridBagConstraints.WEST;
			makeButton(gbaglayout, constraints, lbl4);
			
			//Button 01 - Chocolate Icecream
			Button btn1 = new Button("Chocolate,$20");
			constraints.gridx = 0;
			constraints.gridy = 1;
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
			constraints.anchor = GridBagConstraints.CENTER;
			makeButton(gbaglayout, constraints, btn1);
			btn1.addActionListener(new ActionListener() {
		         @Override
		         public void actionPerformed(ActionEvent e) {
		        	 icecreamText = "Chocolate";
		        	 icecreamAmt = 20;
		        	 totalAmt = icecreamAmt + decoratorAmt;
		        	 lbl3.setText("You choosed " + icecreamText + " Ice-cream " + decoratorText);
		        	 lbl4.setText("Total: $ " + totalAmt);
		         }
			});

			
			//Button 02 - Vanilla Icecream
			Button btn2 = new Button("Vanilla, $30");
			constraints.gridx = 0;
			constraints.gridy = 2;
			constraints.weightx = 1;
			constraints.weighty = 1;
			makeButton(gbaglayout, constraints, btn2);
			btn2.addActionListener(new ActionListener() {
		         @Override
		         public void actionPerformed(ActionEvent e) {
		        	 icecreamText = "Vanilla";
		        	 icecreamAmt = 30;
		        	 totalAmt = icecreamAmt + decoratorAmt;
		        	 lbl3.setText("You choosed " + icecreamText + " Ice-cream " + decoratorText);
		        	 lbl4.setText("Total: $ " + totalAmt);
		         }
			});

			//Button 03 - M&M Decorator
			Button btn3 = new Button("M&M, $5");
			constraints.gridx = 1;
			constraints.gridy = 1;
			constraints.weightx = 1;
			constraints.weighty = 1;
			makeButton(gbaglayout, constraints, btn3);
			btn3.addActionListener(new ActionListener() {
		         @Override
		         public void actionPerformed(ActionEvent e) {
		        	 if (decoratorLimit < 5){
		       			 decoratorLimit = decoratorLimit + 1;
			        	 decoratorText = decoratorText + " + M&M";
			        	 decoratorAmt=decoratorAmt + 5;
		        	 } else {
		        		 JOptionPane.showMessageDialog(btn3,"Max 5 Decorator","Error",JOptionPane.ERROR_MESSAGE);
		        	 }
		        	 totalAmt = icecreamAmt + decoratorAmt;
		        	 lbl3.setText("You choosed " + icecreamText + " Ice-cream " + decoratorText);
		        	 lbl4.setText("Total: $ " + totalAmt);
		         }
			});

			//Button 04 - Strawberry Decorator
			Button btn4 = new Button("Strawberry, $4");
			constraints.gridx = 1;
			constraints.gridy = 2;
			constraints.weightx = 1;
			constraints.weighty = 1;
			makeButton(gbaglayout, constraints, btn4);
			btn4.addActionListener(new ActionListener() {
		         @Override
		         public void actionPerformed(ActionEvent e) {
		        	 if (decoratorLimit < 5){
		       			 decoratorLimit = decoratorLimit + 1;
			        	 decoratorText = decoratorText + " + Strawberry";
			        	 decoratorAmt = decoratorAmt+4;
		        	 } else {
		        		 JOptionPane.showMessageDialog(btn4,"Max 5 Decorator","Error",JOptionPane.ERROR_MESSAGE);
		        	 }
		        	 totalAmt = icecreamAmt + decoratorAmt;
		        	 lbl3.setText("You choosed " + icecreamText + " Ice-cream " + decoratorText);
		        	 lbl4.setText("Total: $ " + totalAmt);
		         }
			});
			
			
			//Button 05 - New IceCream
			Button btn5 = new Button("New IceCream");
			constraints.gridx = 3;
			constraints.gridy = 1;
			constraints.weightx = 1;
			constraints.weighty = 1;
			makeButton(gbaglayout, constraints, btn5);
			btn5.addActionListener(new ActionListener() {
		         @Override
		         public void actionPerformed(ActionEvent e) {
		        	 icecreamText = "?";
		        	 decoratorText = "";
		        	 icecreamAmt = 0;
		        	 decoratorAmt = 0;
		        	 decoratorLimit = 0;
		        	 totalAmt = 0;
		        	 lbl3.setText("You choosed " + icecreamText + " Ice-cream " + decoratorText);
		        	 lbl4.setText("Total: $ " + totalAmt);
		         }
			});
			
			//Button 06 - System Maintence
			Button btn6 = new Button("System Maintence");
			constraints.gridx = 3;
			constraints.gridy = 2;
			constraints.weightx = 1;
			constraints.weighty = 1;
			makeButton(gbaglayout, constraints, btn6);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
}
