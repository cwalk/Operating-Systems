public class FirstAtom implements Runnable {

	private ChemicalBondingCreator cbc;
	private int count;
	
	public FirstAtom(ChemicalBondingCreator cbc, int count) {
		this.cbc = cbc;
		this.count = count;
	}

	@Override
	public void run() {
		//check for Molecule
		moleculeCheck();
		
		//if array list has numFirst first atoms, don't create a new one
		if (cbc.faList.size() < Main.numFirst) {
			
			//adds newly created FirstAtom to array list faList in ChemicalBondingCreator
			System.out.println("First atom no: " + count + " created.");
			cbc.faList.add(this);

			moleculeCheck();
			
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
	//method to check if there are numFirst first atoms and numSecond second atoms available from the 
	//array lists inside ChemicalBondingCreator
	public void moleculeCheck() {
		if (cbc.faList.size() == Main.numFirst && cbc.saList.size() == Main.numSecond)
			cbc.run();
	}
}//end FirstAtom class
