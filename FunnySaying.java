import java.io.*;
import java.util.*;

public class FunnySaying
{
	public static void main(String[] args)
	{
		String[] majConsonant = {"b","c","ch","d","f","g","k","p","ph","s","sh","t","th","v","w","z"};
		String[] minConsonant = {"l","r"};
		String[] vowel = {"a","e","i","o","u","y"};
		ArrayList<String> consonantsound;
		ArrayList<String> convowpair;
	
		consonantsound = new ArrayList<String>();
		for(int r = 0; r < majConsonant.length; r++)
		{
			for(int c = 0; c < minConsonant.length; c++)
			{
				String combo = majConsonant[r] + minConsonant[c];
				consonantsound.add(combo);
			}
		}
		convowpair = new ArrayList<String>();
		System.out.println(consonantsound.toString());
		convowpair = new ArrayList<String>();
		for(String mcon : majConsonant)
		{
			for(String v : vowel)
			{
				convowpair.add(mcon + v);
			}
		}
		for(String conpair : consonantsound)
		{
			for(String vow: vowel)
			{
				convowpair.add(conpair + vow);
			}
		}
		System.out.println();
		System.out.println(convowpair);

		FunnySaying a = new FunnySaying();
		
		Scanner input = new Scanner(System.in);

		boolean go = true;
		while(go)
		{
			System.out.println("Want a funny sentence?");
			String ans = input.next();
			if(ans.equals("yes"))
			{
				System.out.println("Your funny sentence is " + a.makeSentence(convowpair));
			}
			else
			{
				System.out.println("Okay, bye.");
				go = false;
			}
		}
	}

	public String makeWord(ArrayList<String> convows)
	{
		String word = "";
		int syls = (int)(Math.random()*5 +1);
		for(int x = 0; x<syls; x++)
		{
			int sound = (int)(Math.random()*convows.size());
			word += convows.get(sound);
		}
		return word;
	}

	public String makeSentence(ArrayList<String> convows)
	{
		String sentence = "";
		int numWords = (int)(Math.random()*10 + 1);
		for(int i=0; i< numWords-1; i++)
		{
			sentence += makeWord(convows) + " " ;
		}
		sentence += makeWord(convows);
		return sentence;
	}
}
