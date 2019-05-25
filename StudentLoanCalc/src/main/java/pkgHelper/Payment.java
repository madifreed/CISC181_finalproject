package pkgHelper;

import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Payment {
	private int iPaymentId;
	private LocalDate dueDate;
	private double dMonthlyPayment;
	private double dInterestPayment;
	private double dPrinciplePayment;
	private double dExtraPayment;
	private double dBalance;
	
	
	public Payment(int iPaymentId, LocalDate dueDate, double dMonthlyPayment, double dInterestPayment, 
			double dPrinciplePayment, double dExtraPayment, double dBalance) {
		super();
		this.iPaymentId = iPaymentId;
		this.dueDate = dueDate;
		this.dMonthlyPayment = Math.round(dMonthlyPayment * 100.0) / 100.0;
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


	public double getdMonthlyPayment() {
		return dMonthlyPayment;
	}


	public void setdMonthlyPayment(double dMonthlyPayment) {
		this.dMonthlyPayment = dMonthlyPayment;
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
	

	
    public IntegerProperty iPaymentIdProperty() {
        IntegerProperty ip = new SimpleIntegerProperty();
        ip.setValue(iPaymentId);
        return ip;
    }
    
    public DoubleProperty dMonthlyPaymentProperty() {
    	DoubleProperty dp = new SimpleDoubleProperty();
    	dp.setValue(dMonthlyPayment);
    	return dp;
    }
	
    public DoubleProperty dInterestPaymentProperty() {
    	DoubleProperty dp = new SimpleDoubleProperty();
    	dp.setValue(dInterestPayment);
    	return dp;
    }
    
    public DoubleProperty dPrinciplePaymentProperty() {
    	DoubleProperty dp = new SimpleDoubleProperty();
    	dp.setValue(dPrinciplePayment);
    	return dp;
    }
    
    public DoubleProperty dExtraPaymentProperty() {
    	DoubleProperty dp = new SimpleDoubleProperty();
    	dp.setValue(dExtraPayment);
    	return dp;
    }
    
    public DoubleProperty dBalanceProperty() {
    	DoubleProperty dp = new SimpleDoubleProperty();
    	dp.setValue(dBalance);
    	return dp;
    }
    
}
