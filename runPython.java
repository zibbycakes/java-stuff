import java.io.*;
import java.util.*;

public class runPython
{
	public static void run(String exec)
	{
		String s = null;
		try
		{
			Process p = Runtime.getRuntime().exec("python "+ exec);
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			//read output from command
			while((s = input.readLine()) != null)
			{
				System.out.println(s);
			}
		} catch(Exception e)
		{
			System.out.println("There was an error! " + e.toString());
		}
	}

	public static void main(String args[])
	{
		run("test.py");
	}

}
