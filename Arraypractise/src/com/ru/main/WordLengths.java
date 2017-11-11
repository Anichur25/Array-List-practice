package com.ru.main;
import edu.duke.*;

public class WordLengths {

	int maxsofar = 31;

	public void countWordLengths(FileResource resource,int counts[])
	{


		for(String a : resource.lines())
		{
			String s ="";


			for(char ch : a.toCharArray())
			{
				if(Character.isLetter(ch) || ( (ch == '-'  || ch == 39 ) && s.length()!=0))
				{
					s+=ch;
				}

				else
				{
					int len = s.length();

					if(len!=0)
					{
						if(len > 30)
						{
							maxsofar = Math.max(maxsofar, len);
						}

						else
						{
							counts[len] = counts[len] + 1;

						}
					}

					s = "";
				}
			}

			if(s.length()!=0)
			{
				if(s.length() > 30)
				{
					maxsofar = Math.max(maxsofar, s.length());
				}

				else
				{
					counts[s.length()] = counts[s.length()] + 1;

				}
			}
		}
	}


	public void testCountWordLengths()
	{
		FileResource fr = new FileResource();
		int counts[] = new int[31];

		for(int i = 0; i < counts.length ; i++)
		{
			counts[i] = 0;
		}

		countWordLengths(fr,counts);

		for(int i = 1; i < counts.length ; i++)
		{
			System.out.println(i + " : " + counts[i]);
		}

		System.out.println("Most common word length is : " + indexOfMax(counts));
		System.out.println("The maximum size of array is : " + maxsofar);

	}


	/*public int indexOfMax(int values[])
	{
		int max = values[0];

		for(int len : values)
		{
			max = Math.max(max, len);
		}

		return
				max;

	}*/


	public static void main(String args[])
	{
		WordLengths ob = new WordLengths();
		//ob.testCountWordLengths();

	}
}
