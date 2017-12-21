package justinsunny.christmasCard;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class TheScreen extends FullFunctionScreen {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4016165644473858161L;
	private Button switchScreen;
	
	public TheScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		switchScreen = new Button(40, 40, 140, 40, "Switch Screen", Color.CYAN, null);
		viewObjects.add(switchScreen);
	}

}
