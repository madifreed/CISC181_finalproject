package pkgHelper;

import java.time.LocalDate;

public class Payment {
	private int iPaymentId;
	private LocalDate dueDate;
	private double dInterestPayment;
	private double dPrinciplePayment;
	private double dBalance;
	
	
	public Payment(int iPaymentId, LocalDate dueDate, double dInterestPayment, double dPrinciplePayment,
			double dBalance) {
		super();
		this.iPaymentId = iPaymentId;
		this.dueDate = dueDate;
		this.dInterestPayment = dInterestPayment;
		this.dPrinciplePayment = dPrinciplePayment;
		this.dBalance = dBalance;
	}


	public int getiPaymentId() {
		return iPaymentId;
	}


	public void setiPaymentId(int iPaymentId) {
		this.iPaymentId = iPaymentId;
	}


	public LocalDate getDueDate() {
		return dueDate;
	}


	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}


	public double getdInterestPayment() {
		return dInterestPayment;
	}


	public void setdInterestPayment(double dInterestPayment) {
		this.dInterestPayment = dInterestPayment;
	}


	public double getdPrinciplePayment() {
		return dPrinciplePayment;
	}


	public void setdPrinciplePayment(double dPrinciplePayment) {
		this.dPrinciplePayment = dPrinciplePayment;
	}


	public double getdBalance() {
		return dBalance;
	}


	public void setdBalance(double dBalance) {
		this.dBalance = dBalance;
	}
	
	
	public double getMonthlyPayment() {
		return dInterestPayment + dPrinciplePayment;
	}
	

}
