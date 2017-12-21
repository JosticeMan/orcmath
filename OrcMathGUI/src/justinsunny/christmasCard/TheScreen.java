package justinsunny.christmasCard;

import java.awt.Color;
import java.awt.Font;
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
		
		TextArea area = new TextArea(40, 40, 100, 100, Integer.toString((int) (Math.random() * 10)));
		viewObjects.add(area);
		
		switchScreen = new Button(645, 492, 140, 40, "Switch Screen", Color.RED, new Action() {
			
			@Override
			public void act() {
				TheScreen temp = TheGUI.card.screen1;
				TheGUI.card.setScreen(TheGUI.screen2);
				TheGUI.card.screen1 = TheGUI.card.screen2;
				TheGUI.card.screen2 = temp;
			}
			
		});
		Font font = new Font("IMPACT", Font.BOLD, 16);
		switchScreen.setFont(font);
		switchScreen.setForeground(Color.GREEN);
		viewObjects.add(switchScreen);
	}

	
}
