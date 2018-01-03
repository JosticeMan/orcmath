package myStuff;

import guiTeacher.interfaces.Clickable;

public interface ButtonInterfaceJustin extends Clickable {

	//Lights the button up if it was clicked, if not, make the button normal
	void updateLight();
	
	//Enables the program to set whether the button has been clicked or not
	void isClicked(boolean clicked);
	
	//Returns whether or not the button has been clicked 
	boolean getClicked();
}
