package hz_3;

import java.util.Random;

public class Competence_2_1
{

	public static void main(String[] args)
	{
		int firstNumber = 204;
		int secondNumber = 40;
		System.out.println("Print Tower:");
		printTower(8);
		System.out.println("\nGet gcf:");
		System.out.println("The greatest common factor of " + firstNumber + " and " + secondNumber + " is: "
				+ getGCF(firstNumber, secondNumber));
		System.out.println("\nPrint 'X' and 'O':");
		printXO();
	}

	public static void printTower(int maxValue)
	{
		for (int i = 1; i < maxValue + 1; i++)
		{
			for (int j = 0; j < i; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static int getGCF(int number1, int number2)
	{
		int a = number1;
		int b = number2;
		int temp;

		while (a % b != 0)
		{
			temp = a;
			a = b;
			b = temp % a;
		}

		return b;
	}

	public static void printXO()
	{
		Random RANDOM = new Random();

		for (int i = 0; i < 10; i++)
		{
			int amountOfX = RANDOM.nextInt(4) + 1;
			int countChars = 0;
			System.out.print("Zufallszahl: "+amountOfX + "\t");
			for (int j = 0; j < amountOfX; j++)
			{	
				System.out.print("X");
				countChars++;
				int calculated0 = (10 - amountOfX) / amountOfX;

				for (int k = 0; k < calculated0; k++)
				{
					System.out.print("0");
					countChars++;
				}
			}
			while (countChars < 10)
			{
				System.out.print("0");
				countChars++;
			}
			System.out.println();
		}

	}

}
