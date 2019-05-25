package pkgHelper;

import java.time.LocalDate;

public class Payment {
	private int iPaymentId;
	private LocalDate dueDate;
	private double dInterestPayment;
	private double dPrinciplePayment;
	private double dExtraPayment;
	private double dBalance;
	
	
	public Payment(int iPaymentId, LocalDate dueDate, double dInterestPayment, double dPrinciplePayment,
			double dExtraPayment, double dBalance) {
		super();
		this.iPaymentId = iPaymentId;
		this.dueDate = dueDate;
		this.dInterestPayment = Math.round(dInterestPayment * 100.0) / 100.0;
		this.dPrinciplePayment = Math.round(dPrinciplePayment * 100.0) / 100.0;
		this.dExtraPayment = Math.round(dExtraPayment * 100.0) / 100.0;
		this.dBalance = Math.round(dBalance * 100.0) / 100.0;
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


	public double getdExtraPayment() {
		return dExtraPayment;
	}


	public void setdExtraPayment(double dExtraPayment) {
		this.dExtraPayment = dExtraPayment;
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
