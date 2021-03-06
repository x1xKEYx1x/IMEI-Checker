import java.io.File;
import java.io.IOException;
import java.util.Scanner;
//@Lesdon Brown
public class ImeiChecker
{
	
	/**
		@param String
		@exception ImeiException
		This method splits a string using a delemiter, that stores the tokens into an array. Then it loops through the array and gets the numerical value of char's in the string and adds up the odd positions in the Tokenized Strings and doubles them. Then adds the value of the strings and mods the value by 10.
	*/
	public static void ImeiChecker(String imei)throws ImeiException
	{
		String [] ImeiParts = imei.split("-");
		
		int sum = 0;
		
		
		String str = ImeiParts[0];
		
		for(int i = 0; i < ImeiParts.length && i!= 3; i++)
		{
			str += ImeiParts[i];
			System.out.println(str);
			for(int j = 1; j < str.length(); j += 2)
			{
				int sum1 = 0;
				char currentChar = str.charAt(i);
				int random = Character.getNumericValue(currentChar) * 2;
				
				if(sum1 > 9)
				{
					sum1 -= 9;
				}
				
				sum += sum1;
				System.out.println(str);
			}
		}
		
		for(int i = 0; i < str.length(); i +=2)
		{
			int sum2 = 0;
			char currentChar = str.charAt(i);
			sum2 += Character.getNumericValue(currentChar);
			sum += sum2;
			
			
		}
		
		int total = sum % 10;
		if(total != 0)
		{
			throw new ImeiException(imei);
		}
		
		System.out.println(sum);
		
		
	}
	
	
	/**
		@param ImeiException
		This method reads data from a .txt file and calls the ImeiChecker method to run the Data through. It throws an exception if the data is not a valid IMEI number.
	*/
	public static void main(String[] args)throws IOException
	{
	
		
		File inFile = new File("imei.txt");
		Scanner reader = new Scanner(inFile);
		try
		{
			
			while(reader.hasNextLine())
			{
				System.out.println("Checking IMEI numbers from imei.txt. Please Hold...");
				String line = reader.nextLine();
				ImeiChecker(line);
				System.out.println(line);
				reader.close();
			}
			
		}
		catch(ImeiException e)
		{
			System.out.println(e.getMessage());
		}
		
		
		
		
		
		
		
		
		
	}
}