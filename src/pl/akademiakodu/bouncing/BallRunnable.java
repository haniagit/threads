package pl.akademiakodu.bouncing;

import javax.swing.JPanel;

public class BallRunnable implements Runnable {
	BallPanel ballPanel;
	private Ball ball;

	public BallRunnable(Ball ball,BallPanel ballPanel) {
		this.ballPanel = ballPanel;
		this.ball = ball;
	}

	@Override
	public void run() {
		int max = 1000;
		int sleepTime = 4;
		for (int i = 1; i <= max; i++) {
			    ball.move(ballPanel.getBounds());
				ballPanel.repaint();
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				System.out.println("Prablem z spaniem!");
			}
		}
	}

}
