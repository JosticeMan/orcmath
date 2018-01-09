package testPractice;

import guiTeacher.GUIApplication;

public class TestMain extends GUIApplication {

	public static TestMain app;
	public static TestButtonScreen buttonScreen;
	
	public TestMain(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		buttonScreen = new TestButtonScreen(getWidth(), getHeight());
		setScreen(buttonScreen);
	}

	public static void main(String[] args) {
		app = new TestMain(1000,1000);
		Thread run = new Thread(app);
		run.start();
	}

}
