public class SecondAtom implements Runnable {

	private ChemicalBondingCreator cbc;
	private int count;

	public SecondAtom(ChemicalBondingCreator cbc, int count) {
		this.cbc = cbc;
		this.count = count;
	}

	@Override
	public void run() {
		//check for Molecule
		moleculeCheck();
		
		//if array list has numSecond second atoms, don't create a new one
		if (cbc.saList.size() < Main.numSecond) {
			
			//adds newly created SecondAtom to array list saList in ChemicalBondingCreator
			System.out.println("Second atom no: " + count + " created.");
			cbc.saList.add(this);
			
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
}//end SecondAtom class
