package testP;

import guiTeacher.GUIApplication;

public class MainGUI extends GUIApplication {

	public static MainGUI app;
	public static MainScreen mScreen;
	public static GameScreen gScreen;
	
	public MainGUI(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public void newGame() {
		gScreen = new GameScreen(getWidth(), getHeight());
	}
	
	@Override
	public void initScreen() {
		mScreen = new MainScreen(getWidth(), getHeight());
		gScreen = new GameScreen(getWidth(), getHeight());
		setScreen(mScreen);
	}

	public static void main(String[] args) {
		app = new MainGUI(1000,1000);
		Thread run = new Thread(app);
		run.start();
	}

}
