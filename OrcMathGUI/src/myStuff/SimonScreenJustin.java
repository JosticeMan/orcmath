package myStuff;

import java.util.ArrayList;
import java.util.List;

import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenJustin extends ClickableScreen implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9141981357720287918L;
	
	private ProgressInterfaceJustin progress;
	private ArrayList<MoveInterfaceJustin> computerMoves;
	private ArrayList<MoveInterfaceJustin> moves;
	private int roundNumber = 0;
	private int sequenceLength = 3;
	private boolean acceptingUserInput;
	
	private ButtonJustin AButton;
	private ButtonJustin BButton;
	private ButtonJustin CButton;
	private ButtonJustin DButton;
	
	public SimonScreenJustin(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	public void run() {
		
		randomTextThing.updateRoundNumber(roundNumber);
		randomTextThing.updateSequenceLength(sequenceLength);
		
		//Update the lights for the buttons accordingly utilizing a boolean that determines if they've been clicked
		AButton.updateLight();
		BButton.updateLight();
		CButton.updateLight();
		DButton.updateLight();
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		AButton = new ButtonJustin();
		BButton = new ButtonJustin();
		CButton = new ButtonJustin();
		DButton = new ButtonJustin();
	}

}
