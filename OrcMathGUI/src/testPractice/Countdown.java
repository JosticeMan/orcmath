package testPractice;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class Countdown extends Component {

	private String time;
	
	public Countdown(int x, int y, int w, int h) {
		super(x, y, w, h);
		time = "" + 0;
		update();
	}
	
	public void updateTime(String ti) {
		time = "" + ti;
		update();
	}
	
	@Override
	public void update(Graphics2D g) {
		super.clear();
		Font myFont = new Font("Helvetica", Font.PLAIN, 20);
		g.setFont(myFont);
		g.setColor(Color.BLACK);
		FontMetrics fm = g.getFontMetrics();
		g.drawString(time, 0, fm.getHeight());
	}

}
