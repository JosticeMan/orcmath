package myStuff;

import java.awt.Color;

import guiTeacher.interfaces.Clickable;

public interface ButtonInterfaceJustin extends Clickable {

	//Lights the button up
	void highlightButton();
	
	//Unhighlights the button
	void normalizeButton();

	//Sets the color of the button
	void setColor(Color color);

	//Sets the x coordinate of the button
	void setX(double x);

	//Sets the y coordinate of the button
	void setY(double y);
}
