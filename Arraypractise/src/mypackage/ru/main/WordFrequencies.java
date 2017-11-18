package mypackage.ru.main;

import java.util.*;
import edu.duke.*;

public class WordFrequencies {

	private ArrayList<String> myWords = new ArrayList<String>();
	private ArrayList<Integer> myFreqs = new ArrayList<Integer>();

	WordFrequencies()
	{

		myWords.add("init");
		myFreqs.add(0);
	}

	public void findUnique()
	{
		myWords.clear();
		myFreqs.clear();

		FileResource fr = new FileResource();

		for(String word : fr.lines())
		{
			String temp = "";

			for(int i = 0; i < word.length(); i++)
			{
				char c = word.charAt(i);
				if(Character.isLetter(c) || (c == '-' && temp.length()!=0))
				{
					temp+=c;
				}
				else if(temp.length()!=0)
				{
					int index = myWords.indexOf(temp);
					if(index == -1)
					{
						myWords.add(temp);
						myFreqs.add(1);
					}

					else 
					{
						myFreqs.set(index,myFreqs.get(index)+1);
					}

					temp = "";
				}
			}


			if(temp.length()!=0)
			{
				int index = myWords.indexOf(temp);
				if(index == -1)
				{
					myWords.add(temp);
					myFreqs.add(1);
				}

				else 
				{
					myFreqs.set(index,myFreqs.get(index)+1);
				}
			}
		}
	}

	public void tester()
	{
		findUnique();
		int res = findIndexOfMax();
		System.out.println("Number of unique words: " + myWords.size());
		for(int i = 0; i < myWords.size() ; i++)
		{
			System.out.println(myFreqs.get(i) + "  " + myWords.get(i).toLowerCase());
		}

		System.out.println("The word that occurs most often and its count are: " + myWords.get(res)+" "+myFreqs.get(res));
	}

	public int findIndexOfMax()
	{
		int mxFreq = myFreqs.get(0);
		int index = 0;

		for(int i = 0; i < myFreqs.size(); i++)
		{
			if(myFreqs.get(i) > mxFreq)
			{
				mxFreq = myFreqs.get(i);
				index = i;
			}
		}

		return index;
	}
	
	public static void main(String[] args) {

		WordFrequencies test = new WordFrequencies();
		test.tester();
	}

}
