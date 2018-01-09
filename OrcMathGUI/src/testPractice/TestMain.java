package testPractice;

import guiTeacher.GUIApplication;

public class TestMain extends GUIApplication {

	public static TestMain app;
	public static GameScreen game;
	public static TestButtonScreen buttonScreen;
	
	public TestMain(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public void newGame() {
		game = new GameScreen(getWidth(), getHeight());
	}
	
	@Override
	public void initScreen() {
		game = new GameScreen(getWidth(), getHeight());
		buttonScreen = new TestButtonScreen(getWidth(), getHeight());
		setScreen(buttonScreen);
	}

	public static void main(String[] args) {
		app = new TestMain(1000,1000);
		Thread run = new Thread(app);
		run.start();
	}

}
