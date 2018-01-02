package justinsunny.christmasCard;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
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
		
		switchScreen = new Button(645, 492, 140, 40, "Switch Screen", Color.RED, new Action() {
			
			@Override
			public void act() {
				TheGUI.card.setScreen(TheGUI.back);
			}
			
		});
		Font font = new Font("IMPACT", Font.BOLD, 16);
		switchScreen.setFont(font);
		switchScreen.setForeground(Color.GREEN);
		viewObjects.add(switchScreen);
		
		CButton theB = new CButton(50, 50);
		theB.updateString1("Hello");
		theB.updateString2("Muahah");
		theB.setIconColor(Color.GREEN);
		viewObjects.add(theB);
		
		viewObjects.add(new Graphic(0, 0, getWidth(), getHeight(), "resources/christmas.jpg"));
		
		for(int i = 0; i < 23; i++) {
			viewObjects.add(new Santa(getWidth(), getHeight()));
		}
	}

	
}
