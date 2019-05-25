package app.controller;

import app.StudentCalc;
import pkgHelper.Loan;
import pkgHelper.Payment;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

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
	public Label lblTotalInterest;
	
	@FXML
	public Label lblTotalPaymentAmount;
	
	@FXML
	private Label lblTotalInterestAmount;
	
	@FXML
	private TableView<Payment> paymentView;
	
	@FXML
	private TableColumn<Payment, Integer> tcPaymentNbr;

	@FXML
	private TableColumn<Payment, LocalDate> tcDueDate;
	
	@FXML
	private TableColumn<Payment, Double> tcPayment;
	
	@FXML
	private TableColumn<Payment, Double> tcAdditionalPayment;
	
	@FXML
	private TableColumn<Payment, Double> tcInterest;
	
	@FXML
	private TableColumn<Payment, Double> tcPrinciple;
	
	@FXML
	private TableColumn<Payment, Double> tcBalance;
	
	
	private final ObservableList<Payment> payments = FXCollections.observableArrayList();
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lblTotalPaymentAmount.setVisible(false);
		lblTotalInterestAmount.setVisible(false);
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
		
		if ((LoanAmount.getText() == null) || (InterestRate.getText() == null) || 
				(NbrOfYears.getText() == null) || (AdditionalPayment.getText() == null) ||
				(PaymentStartDate.getValue() == null)) {
			return;
		}
		
		double dLoanAmount = Double.parseDouble(LoanAmount.getText());
		System.out.println("Amount: " + dLoanAmount);	

		double dInterestRate = Double.parseDouble(InterestRate.getText()) / 100.0;
		System.out.println("Amount: " + dInterestRate);
		
		int iNbrOfYears = Integer.parseInt(NbrOfYears.getText());
		System.out.println("Nbr of Years: " + iNbrOfYears);
		
		double dAdditionalPayment = Double.parseDouble(AdditionalPayment.getText());
		System.out.println("Additional Payment: " + dAdditionalPayment);
		
		LocalDate dueDate = PaymentStartDate.getValue();
		System.out.println(dueDate);

		
		Loan loan = new Loan(dLoanAmount, dInterestRate, iNbrOfYears, 
				dAdditionalPayment, dueDate);
		
		
		payments.setAll(loan.getLoanPayments());
		
		String totalPayments = Double.toString(loan.getdTotalPayments());
		lblTotalPaymentAmount.setVisible(true);
		lblTotalPaymentAmount.setText(totalPayments);
		
		String totalInterestPaid = Double.toString(loan.getdTotalInterestPaid());
		lblTotalInterestAmount.setVisible(true);
		lblTotalInterestAmount.setText(totalInterestPaid);
		
		
		tcPaymentNbr.setCellValueFactory(
				new PropertyValueFactory<Payment, Integer>("iPaymentId"));
		tcDueDate.setCellValueFactory(
				new PropertyValueFactory<Payment, LocalDate>("dueDate"));
		tcPayment.setCellValueFactory(
				new PropertyValueFactory<Payment, Double>("dMonthlyPayment"));
		tcAdditionalPayment.setCellValueFactory(
				new PropertyValueFactory<Payment, Double>("dExtraPayment"));
		tcInterest.setCellValueFactory(
				new PropertyValueFactory<Payment, Double>("dInterestPayment"));
		tcPrinciple.setCellValueFactory(
				new PropertyValueFactory<Payment, Double>("dPrinciplePayment"));
		tcBalance.setCellValueFactory(
				new PropertyValueFactory<Payment, Double>("dBalance"));
		
		paymentView.setItems(payments);
		
	}
	
}
