package testPractice;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonJustin extends Button {

	private String field;
	
	public ButtonJustin(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, "", color, action);
		setCurve(35,25);
		setActiveBorderColor(Color.BLACK);
		update();
	}

	public void updateString1(String string) {
		field = string;
		update();
	}
	
	@Override
	public void drawButton(Graphics2D g, boolean hover){
		g.setColor(Color.RED);
		Rectangle rect = new Rectangle(0,0,300,150);
		g.draw(rect);
		g.fill(rect);
		g.setColor(Color.WHITE);
		Font theFont = new Font("Arial", Font.PLAIN, 40);
		g.setFont(theFont);
		if(field != null) {
			g.drawString(field, 50, 100);
		}
	}
	
}
