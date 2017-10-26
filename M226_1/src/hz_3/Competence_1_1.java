package hz_3;

public class Competence_1_1 {

	public static void main(String[] args) {
		byte numberOfStudents = 21;
		boolean isLightSwitchOn = true;
		double saldoOfBankAccount = 6723.93;
		char nameOfChessLine = 'C';
		
		numberOfStudents += 2;
		isLightSwitchOn = false;
		saldoOfBankAccount = 45621.12;
		nameOfChessLine = 'F';
		
		System.out.println("Number of students: " + numberOfStudents + "\nIs light switch on? " + isLightSwitchOn + 
				"\nBank account saldo: " + saldoOfBankAccount + "\ncurrent chess line name: " + nameOfChessLine);
	}

}
