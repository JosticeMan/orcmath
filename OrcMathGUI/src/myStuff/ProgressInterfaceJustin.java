package myStuff;

import guiTeacher.interfaces.Visible;

public interface ProgressInterfaceJustin extends Visible {

	//Updates round number in the display
	void updateRoundNumber(int num);
	
	//Updates sequence count 
	void updateSequenceCount(int count);

	//Displays game over message
	void gameOver();
	
}
