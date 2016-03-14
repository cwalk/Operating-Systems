import java.util.Random;

public class CarbonAtomGenerator implements Runnable {

	private Random random = new Random();
	int count = 1;
	private ChemicalBondingCreator cbc;

	public CarbonAtomGenerator(ChemicalBondingCreator cbc) {
		this.cbc = cbc;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep((long) (5000.0 * random.nextDouble()));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			CarbonAtom ca = new CarbonAtom(cbc, count++);
			Thread thread = new Thread(ca);
			thread.start();
		}
	}
}//end CarbonAtomGenerator Class