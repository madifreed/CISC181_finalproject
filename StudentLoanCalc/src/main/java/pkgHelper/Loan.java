/**
 * 
 */
package pkgHelper;

import java.util.LinkedList;
import java.time.LocalDate;

/**
 * @author mpfre
 *
 */
public class Loan {

	double dLoanAmount = 0.0;
	double dInterestRate = 0.0;
	int iTerm = 0;
//	double dFutureValue;
//	boolean bInterestCalc;
	double dExtraPayment = 0.0;
	
	private double dTotalInterestPaid = 0.0;
	private LocalDate dueDate = LocalDate.now();
	private int iTotalPaymentsMade = 0;
	
	private LinkedList<Payment> loanPayments = new LinkedList<>();

	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Loan(double dLoanAmount, double dInterestRate, int iTerm, 
			double dExtraPayment, LocalDate dueDate) {
		super();
		this.dLoanAmount = dLoanAmount;
		this.dInterestRate = dInterestRate;
		this.iTerm = iTerm;
		this.dExtraPayment = dExtraPayment;
		this.dueDate = dueDate;
		
		calculateLoan();
	}


	private void calculateLoan() {
		int numberOfPayments = 12 * iTerm;
		double monthlyInterestRate = dInterestRate / 12.0;
		double iTerm = Math.pow(1+monthlyInterestRate, numberOfPayments);
		double payment = dLoanAmount * ((monthlyInterestRate * iTerm) / (iTerm -1));
		
		LocalDate paymentDate = dueDate;
		double loanBalance = dLoanAmount;
		int month = 0;
		while ((month < numberOfPayments) && (loanBalance > 0.0)) {
			// Calculate monthly interest
			double monthlyPayment = payment + dExtraPayment;
			double monthlyInterestPayment = monthlyInterestRate * loanBalance;
			double monthlyPrinciplePayment = monthlyPayment - monthlyInterestPayment;
			
			dTotalInterestPaid += monthlyInterestPayment;
			
			//Update loan balance
			if (monthlyPayment > loanBalance)
			{
				monthlyPayment = loanBalance;
				loanBalance = 0;
			}
			else { 
				loanBalance -= monthlyPrinciplePayment;
			}
			
			loanPayments.add(new Payment(month, paymentDate, monthlyInterestPayment, 
					monthlyPrinciplePayment, loanBalance));
			
			//Update payment date 
			paymentDate = paymentDate.plusMonths(1);
			
			month++;
		}
		
		iTotalPaymentsMade = loanPayments.size();
	}
	

	public double getdLoanAmount() {
		return dLoanAmount;
	}

	public void setdLoanAmount(double dLoanAmount) {
		this.dLoanAmount = dLoanAmount;
	}

	public double getdInterestRate() {
		return dInterestRate;
	}

	public void setdInterestRate(double dInterestRate) {
		this.dInterestRate = dInterestRate;
	}

	public int getiTerm() {
		return iTerm;
	}

	public void setiTerm(int iTerm) {
		this.iTerm = iTerm;
	}

	public double getdExtraPayment() {
		return dExtraPayment;
	}

	public void setdExtraPayment(double dExtraPayment) {
		this.dExtraPayment = dExtraPayment;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public double getTotalInterestPaid() {
		return dTotalInterestPaid;
	}

	public void setTotalInterestPaid(double totalInterestPaid) {
		this.dTotalInterestPaid = totalInterestPaid;
	}

	public int getTotalPaymentsMade() {
		return iTotalPaymentsMade;
	}

	public void setTotalPaymentsMade(int totalPaymentsMade) {
		this.iTotalPaymentsMade = totalPaymentsMade;
	}
	
	public LinkedList<Payment> getLoanPayments() {
		return loanPayments;
	}
	
	
}
