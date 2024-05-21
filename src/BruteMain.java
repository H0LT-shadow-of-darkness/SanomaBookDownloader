
public class BruteMain {

	public static void main(String[] args) {
		
		for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new BruteCode(i));
            thread.start();
        }

	}

}
