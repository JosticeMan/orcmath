package myStuff;

import guiTeacher.GUIApplication;

public class SimonGameJustin extends GUIApplication {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static SimonGameJustin theGame;
	public SimonScreenJustin theScreen;
	
	public SimonGameJustin(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		theScreen = new SimonScreenJustin(getWidth(), getHeight());
		setScreen(theScreen);
	}
	
	public static void main(String[] args) {
		theGame = new SimonGameJustin(1000,750);
		Thread go = new Thread(theGame);
		go.start();
	}

}
