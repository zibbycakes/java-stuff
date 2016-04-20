import java.util.*;
import java.io.*;

public class Billy
{
	TreeMap<String,Integer> items;
	int appetite;
	int ranking;
	int stamina;
	int tacos;
	double rankMult;
	public Billy()
	{
		initItems();
		appetite = 260;
		stamina = 530;
		ranking = 0;     	
		tacos = 0;
		rankMult = 1.0;
	}

	private void initItems()
	{
		//items are ("name", appetite)
		items = new TreeMap<String, Integer>();
		items.put("Golden Potion",100);
		items.put("TACO",60);
		items.put("Silver Elixir",50);
		items.put("ThankYou Potion",0);
	}

	private void eat(String potion)
	{
		if(items.get(potion) == null)
			return;
		if(appetite - items.get(potion) < 0)
		{
			System.out.println("You don't have enough appetite! Appetite remaining: " + appetite);
			return;
		}

		switch(potion)
		{
			case "Golden Potion": stamina += 100; break;
			case "TACO" : stamina+=100+10*tacos++; break;
			case "Silver Elixir" : ranking += 100000; break;
			case "ThankYou Potion" : stamina += 50;  break;
		}

		appetite -= items.get(potion);
	}

	private void eatUntilFull(String potion)
	{
		if(items.get(potion) == null)
			return;
		int times = 0;
		while(appetite - items.get(potion) > 0)
		{
			eat(potion); 
			times++;
		}
		System.out.println(potion + " was eaten " + times + " times.");
	}

	public int getAppetite()
	{
		return appetite;
	}

	public int getRanking()
	{
		return ranking;
	}

	public int getStamina()
	{
		return stamina;
	}

	public int getTacos()
	{
		return tacos;
	}

	public double getMult()
	{
		return rankMult;
	}

	private void setAppetite(int a)
	{
		appetite = a;
	}

	private void setStamina(int s)
	{
		stamina = s;
	}

	private void setRankMult(double m)
	{
		rankMult = m;
	}

	private void missions(String rank, int times)
	{
		for(int i = 0; i < times; i++)
		{
			switch(rank)
			{
				case "A": ranking+=(int)((Math.random()*1000)+3000);break;

			}
			//assuming team of pinky lv2, stalkergirl lv.2, emosuke lv. 3
			//+1 stamina per mission base
			//+1 stamina per mission for stalkergirl
			stamina -= 8;
		}

	}

	private void missionsUntilDone(String rank)
	{
		while(stamina - 10 > 0)
		{
			missions(rank,1);
		}
	}
	
	public static void main(String[] args)
	{
		Billy a = new Billy();
		a.eatUntilFull("TACO");

		System.out.println("Stamina: "+ a.getStamina());
		System.out.println("Appetite: " + a.getAppetite());
		System.out.println("Ranking: " + a.getRanking());
		
		Billy b = new Billy();
		//drinking 12 (limit) appertifs +5 appetite each
		//only 6 is necessary; otherwise 30 leftover appetite
		for(int i = 0; i < 8; i++)
			b.setAppetite(b.getAppetite() + 5);
		//bottomless appetite +30 appetite
		b.setAppetite(b.getAppetite()+20);
		//diet ramen appetite +40
		b.setAppetite(b.getAppetite()+40);

		b.eatUntilFull("Silver Elixir");

		//note rush -50, +10 stamina for bingoing, +20% ranking
		b.setStamina(b.getStamina()-40);
		b.setRankMult(b.getMult() + .20);

		//Arena Favorite
		b.setRankMult(b.getMult() + .15);

		b.missionsUntilDone("A");
		
		//hottie regeneration jutsu +100 stamina
		b.setStamina(b.getStamina()+100);

		b.missionsUntilDone("A");

		System.out.println("Stamina: "+ b.getStamina());
                System.out.println("Appetite: " + b.getAppetite());
	 	System.out.println("Ranking: " + b.getRanking());	
				
	}


}
