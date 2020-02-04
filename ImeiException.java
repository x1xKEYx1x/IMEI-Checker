//@Lesdon Brown
/**
	@Exception
	@param imei
	This method creates a custom exception 
	by being a sub class of the parent class exception
	with a constructor as a parameter.
*/
	
	
public class ImeiException extends Exception
{
	
	public ImeiException(String imei)
	{
		super(imei + " Is an Invalid IMEI number");
	}
}