import java.util.Random;

public class FirstAtomGenerator implements Runnable {

	private Random random = new Random();
	int count = 1;
	private ChemicalBondingCreator cbc;

	public FirstAtomGenerator(ChemicalBondingCreator cbc) {
		this.cbc = cbc;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep((long) (3000.0 * random.nextDouble()));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FirstAtom fa = new FirstAtom(cbc, count++);
			Thread thread = new Thread(fa);
			thread.start();
		}
	}
}//end FirstAtomGenerator Class