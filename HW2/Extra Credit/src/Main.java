import java.util.Scanner;

public class Main {

	public static int numFirst;
	public static int numSecond;

	@SuppressWarnings("resource")
	public static final void main(String args[]) {
		System.out.println("Project 2 Extra Credit");
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("How many atoms for the First atom are needed to create the molecule?");
		numFirst = in.nextInt();
		System.out.println("How many atoms for the Second atom are needed to create the molecule?");
		numSecond = in.nextInt();
		
		//create the bonding
		ChemicalBondingCreator cbc = new ChemicalBondingCreator();
		Thread thread = new Thread(cbc);
		thread.start();
		//create the first atom generator
		FirstAtomGenerator fag = new FirstAtomGenerator(cbc);
		thread = new Thread(fag);
		thread.start();
		//create the second atom generator
		SecondAtomGenerator sag = new SecondAtomGenerator(cbc);
		thread = new Thread(sag);
		thread.start();
	}
}//end Main class
