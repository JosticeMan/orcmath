package testP;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Button extends guiTeacher.components.Button {

	private String field;
	
	public Button(int x, int y) {
		super(x, y, 300, 300, "", null, null);
		field = "";
	}
	
	public void updateString(String f) {
		field = f;
		update();
	}

	public void drawButton(Graphics2D g, boolean hover) {
		g.setColor(Color.RED);
		Rectangle rect = new Rectangle(0,0,300,300);
		g.draw(rect);
		g.fill(rect);
		g.setColor(Color.white);
		Font f = new Font("Arial", Font.PLAIN, 32);
		g.setFont(f);
		if(field != null) {
			g.drawString(field, 120, 120);
		}
	}
}
