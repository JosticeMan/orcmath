package justinsunny.christmasCard;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class TheBack extends FullFunctionScreen {

	private Button switchScreen;
	
	public TheBack(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		viewObjects.add(new Graphic(0,0,getWidth(), getHeight(), "resources/images.jpg"));
		
		switchScreen = new Button(645, 492, 140, 40, "Switch Screen", Color.RED, new Action() {
			
			@Override
			public void act() {
				TheGUI.card.setScreen(TheGUI.front);
			}
			
		});
		Font font = new Font("IMPACT", Font.BOLD, 16);
		switchScreen.setFont(font);
		switchScreen.setForeground(Color.GREEN);
		viewObjects.add(switchScreen);
	}
}
