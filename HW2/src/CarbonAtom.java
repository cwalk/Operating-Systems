public class CarbonAtom implements Runnable {

	private ChemicalBondingCreator cbc;
	private int count;

	public CarbonAtom(ChemicalBondingCreator cbc, int count) {
		this.cbc = cbc;
		this.count = count;
	}

	@Override
	public void run() {
		//check for methaneMolecule
		methaneCheck();
		
		//if array list has 1 carbon atom, don't create a new one
		if (cbc.caList.size() < 1) {
			
			//adds newly created CarbonAtom to array list caList in ChemicalBondingCreator
			System.out.println("Carbon atom no: " + count + " created.");
			cbc.caList.add(this);
			
			methaneCheck();
		
			try {
				synchronized (cbc.waiton) {
					cbc.waiton.acquire();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//method to check if there are 4 hydrogen atoms and 1 carbon atom available from the 
	//array lists inside ChemicalBondingCreator
	public void methaneCheck() {
		if (cbc.haList.size() == 4 && cbc.caList.size() == 1)
			cbc.run();
	}
}//end CarbonAtom class
