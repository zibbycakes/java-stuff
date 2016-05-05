import java.io.*;
import java.util.*;

public class JQuizMaker
{
	public JQuizMaker()
	{
	}

	public static void main(String args[])
	{
		Scanner file = null;
		try
		{
			Scanner file = new Scanner(new File("quiz.txt"));
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}

		if(file != null)
		{
			while(file.hasNextLine())
			{

			}
		}	
	}
}
