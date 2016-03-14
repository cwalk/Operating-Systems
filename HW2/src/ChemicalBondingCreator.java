import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class ChemicalBondingCreator implements Runnable {

	//Initializing Semaphore to 1 helps solve mutual exclusion
	public Semaphore waiton = new Semaphore(1);
	public List<HydrogenAtom> haList = new ArrayList<>();
	public List<CarbonAtom> caList = new ArrayList<>();
	
	public int numMethaneMolecules = 0;
	public Semaphore methaneSwitch = new Semaphore(1);

	@Override
	public void run() {
		while (true) {
		
			try {
					Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//we have enough of the correct atoms to create a methan molecule
			if (haList.size() >= 4 && caList.size() >= 1) {
				System.out.println("Chemical bonding creator: enough atoms to create a methane molecule");
				
				for (int i = 0; i != 5; i++) {
					waiton.release(1);
				}
				
				System.out.println("Number of Hydrogen atoms before process: " + haList.size());
				System.out.println("Number of Carbon atoms before process: " + caList.size());
				System.out.println("Number of Methane Molecules  before process: " + numMethaneMolecules);
				
				/**These can be uncommented to see the whole array list containing 4 Hydrogen
				 * and 1 Carbon atom if desired. There will only be 4 Hydrogen and 1 Carbon 
				 * atoms in the array lists at once.
				 */
				//System.out.println( "Whole HA list = " + haList);
				//System.out.println( "Whole CA list = " + caList);
				
				//removes 4 hydrogens and 1 carbons from the haList and caList respectively
				for (int i=0;i<4;i++) {
					haList.remove(0);
				}
				caList.remove(0);
				
				//Announces successful creation of Methane Molecule after removing atoms from their array lists.
				System.out.println("Chemical bonding creator: methane molecule successfully created!");
				//increments amount of methane molecules made
				numMethaneMolecules++;
				
				System.out.println("Number of Hydrogen atoms after creation: " + haList.size());
				System.out.println("Number of Carbon atoms after creation : " + caList.size());
				System.out.println("Number of Methane Molecules after creation: " + numMethaneMolecules);
				continue;
			}
			//redundant print that came with sample source code
			if (haList.size() >= 4) {
				System.out.println("Chemical bonding creator: enough H atoms, but no C atom");
				continue;
			}
		}
	}
}//end ChemicalBondingCreator class
