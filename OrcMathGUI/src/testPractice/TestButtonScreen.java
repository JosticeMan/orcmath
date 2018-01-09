package testPractice;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import guiTeacher.components.Action;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class TestButtonScreen extends ClickableScreen {

	/**
	 * 
	 */
	private static final long serialVersionUID = 263157152027622069L;
	private ButtonJustin btn;
	
	public TestButtonScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {

		btn = new ButtonJustin(350,450,400,300, "", null, null);
		btn.updateString1("Start");
		btn.setAction(new Action() {
			
			@Override
			public void act() {
			
				TestMain.app.setScreen(TestMain.game);
				
			}
		});
		viewObjects.add(btn);

	}
	
}
