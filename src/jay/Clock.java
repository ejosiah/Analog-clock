package jay;
import static java.lang.Math.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Date;

import javax.swing.JPanel;

@SuppressWarnings("all")
public class Clock extends JPanel {
	private static final int WIDTH = 300;
	private static final int HEIGHT = 300;
	private static final int RADIUS = 150;
	private static final int MINUTE_HAND = 100;
	private static final int HOUR_HAND = 70;
	private static final int SECOND_HAND = 110;
	private static final int ANGLE_OFFSET = 270;
	private static final float HOUR_MULTIPLIER = 0.5F;
	private static final float RAD = 0.0174532925f;

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		drawClock(g);
	}

	private void drawClock(Graphics g) {
		g.setColor(Color.GREEN);
		int xOffset = getWidth() / 2;
		int yOffset = getHeight() / 2;
		drawPoints(g, xOffset, yOffset);
		drawSecondHand(g, xOffset, yOffset);
		drawMinuteHand(g, xOffset, yOffset);
		drawHourHand(g, xOffset, yOffset);
	}

	private void drawPoints(Graphics g, int xOffset, int yOffset) {
		for (int i = 0; i < 360; i += 6) {
			int xPoint = (int) round(RADIUS * cos(i * RAD));
			int yPoint = (int) round(RADIUS * sin(i * RAD));
			if (i % 30 == 0) {
			//	Integer num = i/30 + 3;
			///	num = num <= 12 ? num : num % 12; 
				g.fillRect(xPoint + xOffset, yPoint + yOffset, 5, 5);
			//	g.drawString(num.toString(), xPoint + xOffset, yPoint + yOffset);
			} else {
				g.fillRect(xPoint + xOffset, yPoint + yOffset, 2, 2);
			}
		}
	}

	private void drawSecondHand(Graphics g, int xCenter, int yCenter) {
		int angle = ANGLE_OFFSET + new Date().getSeconds() * 6;
		drawLine(g, xCenter, yCenter, SECOND_HAND, angle);
	}

	private void drawMinuteHand(Graphics g, int xCenter, int yCenter) {
		int angle = ANGLE_OFFSET + new Date().getMinutes() * 6;
		drawLine(g, xCenter, yCenter, MINUTE_HAND, angle);
	}

	private void drawHourHand(Graphics g, int xCenter, int yCenter) {
		int minute = new Date().getMinutes();
		int angle = (int) ((ANGLE_OFFSET + new Date().getHours() % 12 * 30) + (minute * HOUR_MULTIPLIER));
		drawLine(g, xCenter, yCenter, HOUR_HAND, angle);
	}

	private void drawLine(Graphics g, int xCenter, int yCenter, int size, int angle) {
		int xPoint = (int) round(size * cos(angle * RAD));
		int yPoint = (int) round(size * sin(angle * RAD));
		g.drawLine(xCenter, yCenter, xPoint + xCenter, yPoint + yCenter);
	}

}