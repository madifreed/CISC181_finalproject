package app.controller;

import app.StudentCalc;
import pkgHelper.Loan;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;

public class LoanCalcViewController implements Initializable   {

	private StudentCalc SC = null;
	
	
	@FXML
	private TextField LoanAmount;
	
	@FXML
	private TextField InterestRate;
	
	@FXML
	private TextField NbrOfYears;

	@FXML
	private TextField AdditionalPayment;
	
	
	@FXML
	private DatePicker PaymentStartDate;
	
	
	@FXML
	private Label lblLoanAmount;
	
	@FXML
	private Label lblNbrOfYears;
	
	@FXML
	private Label lblPaymentStartDate;	
	
	@FXML
	private Label lblAdditionalPayment;
	
	@FXML
	private Label lblTotalPayments;
	
	@FXML
	private Label lblTotalInterest;

	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void setMainApp(StudentCalc sc) {
		this.SC = sc;
	}
	
	/**
	 * btnCalcLoan - Fire this event when the button clicks
	 * 
	 * @version 1.0
	 * @param event
	 */
	@FXML
	private void btnCalcLoan(ActionEvent event) {

//		System.out.println("Amount: " + LoanAmount.getText());
		double dLoanAmount = Double.parseDouble(LoanAmount.getText());
		System.out.println("Amount: " + dLoanAmount);	

		double dInterestRate = Double.parseDouble(InterestRate.getText());
		System.out.println("Amount: " + dInterestRate);
		
		int iNbrOfYears = Integer.parseInt(NbrOfYears.getText());
		System.out.println("Nbr of Years: " + iNbrOfYears);
		
		double dAdditionalPayment = Double.parseDouble(AdditionalPayment.getText());
		System.out.println("Additional Payment: " + dAdditionalPayment);
		
		LocalDate dueDate = PaymentStartDate.getValue();
		System.out.println(dueDate); 
		
//		final Loan loan = new Loan(dLoanAmount, dInterestRate, iNbrOfYears, 
//				dAdditionalPayment, dueDate);
		
//		String totalInterestPaid = Double.toString(loan.getTotalInterestPaid());
//		lblTotalInterest.setText(totalInterestPaid);;
		
	}
}
