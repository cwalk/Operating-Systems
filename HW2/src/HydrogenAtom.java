public class HydrogenAtom implements Runnable {

	private ChemicalBondingCreator cbc;
	private int count;
	
	public HydrogenAtom(ChemicalBondingCreator cbc, int count) {
		this.cbc = cbc;
		this.count = count;
	}

	@Override
	public void run() {
		//check for methaneMolecule
		methaneCheck();
		
		//if array list has 4 hydrogen atoms, don't create a new one
		if (cbc.haList.size() < 4) {
			
			//adds newly created HydrogenAtom to array list haList in ChemicalBondingCreator
			System.out.println("Hydrogen atom no: " + count + " created.");
			cbc.haList.add(this);

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
}//end HydrogenAtom class
