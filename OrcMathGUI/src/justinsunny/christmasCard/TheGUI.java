package justinsunny.christmasCard;

import guiTeacher.GUIApplication;

public class TheGUI extends GUIApplication {

	public static TheGUI card;
	public static TheScreen front;
	public static TheBack back;
	
	public TheGUI(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public void setSVisible(boolean value) {
		this.setVisible(value);
	}
	
	@Override
	public void initScreen() {
		front = new TheScreen(getWidth(),getHeight());
		back = new TheBack(getWidth(),getHeight());
		setScreen(front);
	}
	
	public static void main(String[] args) {
		card = new TheGUI(800,550);
		Thread go = new Thread(card);
		go.start();
	}

}
