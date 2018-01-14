package testP;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class MainScreen extends ClickableScreen {

	public MainScreen(int width, int height) {
		super(width, height);
		update();
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Button btn = new Button(200,200);
		btn.updateString("Start");
		btn.setAction(new Action() {
			
			@Override
			public void act() {
				MainGUI.app.setScreen(MainGUI.gScreen);
			}
			
		});
		viewObjects.add(btn);
	}

}
