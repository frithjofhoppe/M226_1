package testPackage;

public class Main
{

	public static void main(String[] args)
	{
		Person p = new Person("Thomas");
		Person q = new Person("Maria");
		Person y = p;
		Person[] pArray = new Person[3];
		pArray[0] = p;
		pArray[1] = y;
		pArray[2] = q;
		//p = new Person("Josef");
		p.name = "Josef";
		System.out.println(pArray[0].name);
		System.out.println(pArray[1].name);
		System.out.println(p.name);
		System.out.println(y.name);
	}

}
