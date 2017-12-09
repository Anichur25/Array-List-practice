import java.util.*;
import edu.duke.*;

public class CharactersInPlay {

	private ArrayList<String> name = new ArrayList<String>();
	private ArrayList<Integer> freqs = new ArrayList<Integer>();

	public void update(String person)
	{
		int check = name.indexOf(person);
		if(check == -1)
		{
			name.add(person);
			freqs.add(1);
		}

		else
		{
			freqs.set(check, freqs.get(check) + 1);
		}

	}


	public void findAllCharacters()
	{
		FileResource fr = new FileResource();

		for(String line : fr.lines())
		{
			String str = (String)line;
			String word = "";
			boolean foundstatus = false;

			for(int i = 0; i < str.length(); i++)
			{
				if(str.charAt(i) == '.')
				{
					foundstatus = true;
					break;
				}
				else
				{
					word+=str.charAt(i);
				}
			}

			if(foundstatus)
			{
				update(word);

			}
		}
	}


	public void tester()
	{
		findAllCharacters();

		int mx = freqs.get(0);

		for(int i = 1; i < freqs.size(); i++)
		{
			if(mx == freqs.get(i))
			{
				mx = freqs.get(i);
			}
		}

		for(int i = 0 ; i < freqs.size(); i++)
		{
			if(mx == freqs.get(i))
			{
				System.out.println(name.get(i) + " " + freqs.get(i));
			}
		}

		charactersWithNumParts(2,3);

	}


	public void charactersWithNumParts(int num1 , int num2)
	{

		for(int i = 0; i < freqs.size(); i++)
		{
			int value = freqs.get(i);

			if(value >= num1 && value <= num2)
			{
				System.out.println(name.get(i));
			}
		}
	}


	public static void main(String[] args) {

		CharactersInPlay abc = new CharactersInPlay();
		abc.tester();
	}

}
