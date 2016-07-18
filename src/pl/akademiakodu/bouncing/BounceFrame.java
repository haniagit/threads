package pl.akademiakodu.bouncing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BounceFrame extends JFrame {

	public static final int WIDTH = 450;
	public static final int HEIGHT = 350;
	private BallPanel ballPanel;

	public BounceFrame() {
		setSize(WIDTH, HEIGHT);
		setTitle("Wątki piłeczka");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new BorderLayout());
		JPanel buttonsPanel = new JPanel();
		ballPanel = new BallPanel();
		buttonsPanel.setVisible(true);
		add(ballPanel, BorderLayout.CENTER);

		addButton(buttonsPanel, "Start", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				printBall();
			}
		});
		addButton(buttonsPanel, "Close", new CloseListener());
		add(buttonsPanel, BorderLayout.SOUTH);
	}

	public void addButton(JPanel panel, String buttonTitle, ActionListener listener) {
		JButton button = new JButton(buttonTitle);
		panel.add(button);
		button.addActionListener(listener);
	}

	private void printBall() {
		Ball ball = new Ball();
		ballPanel.add(ball);
		int max = 1000;
		int sleepTime = 4;
		for (int i = 1; i <= max; i++) {
			ball.move(ballPanel.getBounds());
			ballPanel.paint(ballPanel.getGraphics());
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				System.out.println("Prablem z spaniem!");
			}
		}
	}

}
