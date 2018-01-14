package testP;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class Countdowner extends Component {

	private String time;
	
	public Countdowner(int x, int y, int w, int h) {
		super(x, y, w, h);
		time = "0";
		update();
	}

	public void updateTime(String t) {
		time = t;
		update();
	}
	
	@Override
	public void update(Graphics2D g) {
		super.clear();
		g.setColor(Color.BLACK);
		Font f = new Font("Arial", Font.PLAIN, 12);
		g.setFont(f);
		FontMetrics fm = g.getFontMetrics();
		g.drawString(time, 0, fm.getHeight());
	}

}
