package myStuff;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonJustin extends Button implements ButtonInterfaceJustin {

	private Color baseColor;
	private double xPos;
	private double yPos;
	
	public ButtonJustin(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text, color, action);
		update();
	}

	public ButtonJustin(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text, action);
		update();
	}

	@Override
	public void highlightButton() {
		this.setColor(Color.white);
		update();
	}

	@Override
	public void normalizeButton() {
		this.setColor(baseColor);
		update();
	}

	@Override
	public void setColor(Color color) {
		baseColor = color;
		update();
	}

	@Override
	public void setX(double x) {
		xPos = x;
	}

	@Override
	public void setY(double y) {
		yPos = y;
	}
	
	public void drawButton(Graphics2D g, boolean hover) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		drawShape(g, hover);
		g.setColor(getForeground());
	}

}
