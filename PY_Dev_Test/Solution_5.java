import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution_5 
{
	public static boolean validate_ipv4(String ip) 
	{
		String[] blocks = ip.split("\\.");
		int [] numBlocks = {0,0,0,0} ;
		if (blocks.length != 4)
			return  false;
		try  
		{  
			for (int i=0 ; i < 4 ; i++ )
			{
				numBlocks[i] = Integer.parseInt(blocks[i]); //ipv4 validation is not done with regex, as for simplicity sake @Istyak  
			}				
		}  
		catch(NumberFormatException nfe)  
		{  
			return false;  
		}
		for (int i=0 ; i < 4 ; i++ )
		{
			if (numBlocks[i] > 255 || numBlocks[i] < 0)
				return false; 
		}
		return  true;
	}	
	public static boolean validate_ipv6(String ip) 
	{
		final String ipv6 = "^[0-9a-f]{1,4}:" + "[0-9a-f]{1,4}:"
				+	"[0-9a-f]{1,4}:" + "[0-9a-f]{1,4}:" 
				+	"[0-9a-f]{1,4}:" + "[0-9a-f]{1,4}:" 
				+	"[0-9a-f]{1,4}:" + "[0-9a-f]{1,4}$"; // Regex is collected from Online @Istyak
		if (ip.indexOf(":")>0)
		{
			try  
			{  
				Pattern patt;
				Matcher match;
				
				patt = Pattern.compile(ipv6);
				match = patt.matcher(ip);
				if(match.matches())
					return  true;
				else
					return  false;
			}  
			catch(Exception  e)  
			{  
				return false;  
			}
		}
		else
			return  false;
	}
	public void show() 
	{
		System.out.println(  "  " );
	}
	private static final Scanner scan = new Scanner(System.in);
	public static void main(String[] args) 
	{
		String[] array = {"2", "This line has junk text",  "121.18.19.20", "121.18.T.20","2001:0db8:0000:0000:00f0:ff00:0042:8329",};
		for (int i=0 ; i < array.length ; i++ )
		{
			String token = array[i].toString();
			if( validate_ipv4(token))
				System.out.println("IPV4");
			else if ( validate_ipv6(token))
				System.out.println("IPV6");
			else
				System.out.println("Neither");
		}
	}
}
