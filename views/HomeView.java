
package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class HomeView extends JFrame {
    private JLabel lblNewLabel, firstLabel, secondLabel, resultLabel;
	private JTextField  firstField, secondField, resultField;
	private JButton additionButton, substractionButton, multiplicationButton, divisionButton, derivativeButton, integrationButton;


	public HomeView() {
		this.setBounds(100, 100, 450, 530);
		this.setTitle("Polynomial Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);

		lblNewLabel = new JLabel("Polynomial Calculator");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(139, 29, 180, 35);
		this.getContentPane().add(lblNewLabel);

		firstLabel = new JLabel("First Polynomial");
		firstLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		firstLabel.setBounds(41, 121, 127, 14);
		this.getContentPane().add(firstLabel);

		secondLabel = new JLabel("Second Polynomial");
		secondLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		secondLabel.setBounds(41, 146, 144, 14);
		this.getContentPane().add(secondLabel);

		firstField = new JTextField();
		firstField.setBounds(196, 119, 170, 20);
		this.getContentPane().add(firstField);
		firstField.setColumns(10);

		secondField = new JTextField();
		secondField.setBounds(196, 144, 170, 20);
		this.getContentPane().add(secondField);
		secondField.setColumns(10);

		resultLabel = new JLabel("Result");
		resultLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		resultLabel.setBounds(41, 177, 46, 14);
		this.getContentPane().add(resultLabel);

		resultField = new JTextField();
		resultField.setBounds(196, 171, 170, 20);
		this.getContentPane().add(resultField);
		resultField.setColumns(10);

		additionButton = new JButton("ADDITION");
		additionButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		additionButton.setBounds(37, 250, 160, 50);
		this.getContentPane().add(additionButton);

		substractionButton = new JButton("SUBSTRACTION");
		substractionButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		substractionButton.setBounds(230, 250, 160, 50);
		this.getContentPane().add(substractionButton);

		multiplicationButton = new JButton("MULTIPLICATION");
		multiplicationButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		multiplicationButton.setBounds(37, 310, 160, 50);
		this.getContentPane().add(multiplicationButton);

		divisionButton = new JButton("DIVISION");
		divisionButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		divisionButton.setBounds(230, 310, 160, 50);
		this.getContentPane().add(divisionButton);

		derivativeButton = new JButton("DERIVATIVE");
		derivativeButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		derivativeButton.setBounds(37, 370, 160, 50);
		this.getContentPane().add(derivativeButton);

		integrationButton = new JButton("INTEGRATION");
		integrationButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		integrationButton.setBounds(230, 370, 160, 50);
		this.getContentPane().add(integrationButton);

		this.setVisible(true);
	}

	   public void showMessage (String message){
		JOptionPane.showMessageDialog(this, message);}

		public String getFirstField() {
			return firstField.getText();
		}

		public String getSecondField() {
			return secondField.getText();
		}
		//
		public void setResultField(String result){
		     this.resultField.setText(result);
		}

	    public JTextField getResultField() {
		    return resultField;
	}

	public void addAdditionListener(ActionListener action){
				additionButton.addActionListener(action);
			}

		public void addSubstractionListener(ActionListener action){
			substractionButton.addActionListener(action);
		}

		public void addMultiplicationListener(ActionListener action){
			multiplicationButton.addActionListener(action);
		}

		public void addDivisionListener(ActionListener action){
			divisionButton.addActionListener(action);
		}

		public void addDerivativeListener(ActionListener action){
			derivativeButton.addActionListener(action);
		}

		public void addIntegrationListener(ActionListener action){
			integrationButton.addActionListener(action);
		}

}
