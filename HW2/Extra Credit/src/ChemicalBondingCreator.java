import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class ChemicalBondingCreator implements Runnable {

	//Initializing Semaphore to 1 helps solve mutual exclusion
	public Semaphore waiton = new Semaphore(1);
	public List<FirstAtom> faList = new ArrayList<>();
	public List<SecondAtom> saList = new ArrayList<>();
	
	public int numGenericMolecules = 0;
	public Semaphore atomSwitch = new Semaphore(1);

	@Override
	public void run() {
		while (true) {
		
			try {
					Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//we have enough of the correct atoms to create a generic molecule
			if (faList.size() >= Main.numFirst && saList.size() >= Main.numSecond) {
				System.out.println("Chemical bonding creator: enough atoms to create a generic molecule");
				
				//for (int i = 0; i != (Main.numFirst+Main.numSecond); i++) {
				for (int i = 0; i != 2; i++) {	
					waiton.release(1);
				}
				
				System.out.println("Number of first atoms before process: " + faList.size());
				System.out.println("Number of second atoms before process: " + saList.size());
				System.out.println("Number of Generic Molecules before process: " + numGenericMolecules);
                
                //System.out.println( "Whole FA list = " + faList);
				//System.out.println( "Whole SA list = " + saList);
				
				//removes however many molecules from faList and saList respectively
				for (int i=0;i<Main.numFirst;i++) {
					faList.remove(0);
				}
				for (int i=0;i<Main.numSecond;i++) {
					saList.remove(0);
				}
				
				//Announces successful creation of Generic Molecule after removing atoms from their array lists.
				System.out.println("Chemical bonding creator: generic molecule successfully created!");
				//increments amount of generic molecules made
				numGenericMolecules++;
				
				System.out.println("Number of first atoms after creation: " + faList.size());
				System.out.println("Number of of second atoms after creation : " + saList.size());
				System.out.println("Number of Generic Molecules after creation: " + numGenericMolecules);
				continue;
			}
		}
	}
}//end ChemicalBondingCreator class