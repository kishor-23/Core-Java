package com.chainsys.oops;

public class User {
	
	 private String name;
	    private String accountNumber;
	    private String phoneno;
	    private double savings;
	    
    public User(){
    	
    }
	   
	    public String getPhoneno() {
			return phoneno;
		}

		public void setPhoneno(String phoneno) {
			this.phoneno = phoneno;
		}

		public double getSavings() {
			return savings;
		}

		public void setSavings(double savings) {
			this.savings = savings;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}

		public User(String name,  String accountno, double savings,String phoneno) {
		
			this.name = name;
		this.accountNumber=accountno;
			this.phoneno = phoneno;
			this.savings = savings;
		}

		public String getName() {
	        return name;
	    }

	    public String getAccountNumber() {
	        return accountNumber;
	    }
}
