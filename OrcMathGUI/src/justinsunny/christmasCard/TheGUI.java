package justinsunny.christmasCard;

import guiTeacher.GUIApplication;

public class TheGUI extends GUIApplication {

	public TheGUI(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		TheScreen screen = new TheScreen(getWidth(),getHeight());
		setScreen(screen);
	}
	
	public static void main(String[] args) {
		TheGUI i = new TheGUI(800,550);
		Thread go = new Thread(i);
		go.start();
	}

}
