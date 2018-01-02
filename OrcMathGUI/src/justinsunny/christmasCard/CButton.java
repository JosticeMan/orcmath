package justinsunny.christmasCard;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class CButton extends Button {

	private String field;
	private String field1;
	private Color theColor;

	public CButton(int x, int y) {
		super(x, y, 30, 30, "", null);
		update();
	}
	
	public void drawButton(Graphics2D g, boolean hover){
		g.setColor(Color.BLACK);
		g.drawString(field, getWidth() / 2, getHeight() / 2);
		g.drawString(field1, getWidth() / 2, getHeight() / 2);
		g.setColor(theColor);
		Rectangle rect = new Rectangle(0,0,10,10);
		g.draw(rect);
		g.fill(rect);
	}
	
	public void updateString1(String string) {
		this.field = string;
	}

	public void updateString2(String string) {
		this.field1 = string;
	}

	public void setIconColor(Color color) {
		this.theColor = color;
	}

}
