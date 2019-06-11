package Login;;
public class LoginVAO
{

	private String accountno,password,username;
	int balance;

	public String getUserName()
	{
			return username;
	}
	public void setUserName(String username)
	{
		this.username=username;
	}
	public String getPassword()
	{
		return password;
	}
	public 	void setPassword(String password)
	{
		this.password=password;
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
}