import java.util.Random;

public class SecondAtomGenerator implements Runnable {

	private Random random = new Random();
	int count = 1;
	private ChemicalBondingCreator cbc;

	public SecondAtomGenerator(ChemicalBondingCreator cbc) {
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
			SecondAtom sa = new SecondAtom(cbc, count++);
			Thread thread = new Thread(sa);
			thread.start();
		}
	}
}//end SecondAtomGenerator Class