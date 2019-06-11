package Fund;
public class FundVAO
{
		int balance,transamount;
		String accountno,toaccountno;

		public String getToAccNo()
		{
			return toaccountno;
		}
		public void setToAccNo(String toaccountno)
		{
			this.toaccountno=toaccountno;
		}
		
		public String getAccountNo()
		{
			return accountno;
		}
		public void setAccountNo(String accountno)
		{
				this.accountno=accountno;
		}	
		public int getBalance()
				{
			return balance;
		}
		public void setBalance(int balance)
		{
			this.balance=balance;
		}
		public int getTransamount()
		{
			return transamount;
		}
		public void setTransamount(int transamount)
		{
			this.transamount=transamount;
		}
		

}