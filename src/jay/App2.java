package jay;

import javax.swing.JFrame;

public class App2 extends JFrame {
	private Clock clock = new Clock();

	public App2() {
		super("clock");
		add(clock);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					while (true) {
						Thread.sleep(500);
						clock.repaint();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	public static void main(String[] args) {
		new App2();
	}
}