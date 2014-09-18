package co.za.ngwane.epms.helper;

public class ValidationBean
{
	private int errorCode;
	private String errorMessage;
	
	public ValidationBean(){
		
	}
	
	public int getErrorCode()
	{
		return errorCode;
	}
	public void setErrorCode(int errorCode)
	{
		this.errorCode = errorCode;
	}
	public String getErrorMessage()
	{
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage)
	{
		this.errorMessage = errorMessage;
	}
	

}
