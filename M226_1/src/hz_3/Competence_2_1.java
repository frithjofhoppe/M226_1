package hz_3;

public class Competence_2_1 {

	public static void main(String[] args) {
		int firstNumber = 204;
		int secondNumber = 40;
		System.out.println("Print Tower:");
		printTower(8);
		System.out.println("\nGet gcf:");
		System.out.println("The greatest common factor of " + firstNumber + " and " + secondNumber+ " is: " + getGCF(firstNumber,secondNumber));
	}
	
	public static void printTower(int maxValue)
	{
		for(int i = 1; i < maxValue + 1; i++)
		{
			for(int j = 0; j < i; j++)
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
		
		while(a%b != 0)
		{
			temp = a;
			a = b;
			b = temp % a;
		}
		
		return b;
	}
	
	public static void printXO()
	{
//		Auf 10 Zeilen sollen jeweils 10 Zeichen ("X" oder "O") ausgegeben werden. Dabei soll die Anzahl der auszugebenden X durch Zufall bestimmt werden. Die Anzahl X soll zwischen 1 und 4 variieren. Als erstes Zeichen soll immer ein X ausgegeben werden. Die weiteren X sollen möglichst gleichmässig verteilt werden. Ihr Programm soll dazu berechnenen, wieviele O hierzu zwischen zwei X stehen müssen. Am Schluss soll das Programm die Zeile mit O auf 10 Zeichen auffüllen.
//		Um eine Zufallszahl zwischen 1 und 4 einschliesslich zu generieren können Sie folgenden Befehl verwenden:
//		Random  ZUFALL  = new Random();
//		int anzahlX = ZUFALL.nextInt(4)+ 1;
		
		for(int i = 0; i < 10; i++)
		{
			
		}

	}

}
