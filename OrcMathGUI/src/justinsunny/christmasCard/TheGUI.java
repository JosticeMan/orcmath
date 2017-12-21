package justinsunny.christmasCard;

import guiTeacher.GUIApplication;

public class TheGUI extends GUIApplication {

	static TheGUI card;
	static TheScreen screen1;
	static TheScreen screen2;
	
	public TheGUI(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public void setSVisible(boolean value) {
		this.setVisible(value);
	}
	
	@Override
	public void initScreen() {
		screen1 = new TheScreen(getWidth(),getHeight());
		setScreen(screen1);
	}
	
	public static void main(String[] args) {
		screen2 = new TheScreen(800, 550);
		card = new TheGUI(800,550);
		Thread go = new Thread(card);
		go.start();
	}

}
