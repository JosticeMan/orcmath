package justin.playground;

import guiPlayer.CatalogMaker;
import guiTeacher.GUIApplication;

public class CatalogGUI extends GUIApplication {

	public CatalogGUI(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		CatalogScreen screen = new CatalogScreen(500,500);
		setScreen(screen);
	}

	public static void main(String[] args) {
		CatalogGUI i = new CatalogGUI(100,100);
		
	}

}
