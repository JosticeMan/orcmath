package justin.playground;

import guiTeacher.components.AnimatedComponent;

public class Character extends AnimatedComponent {
	
	String imagepath;
	String type;
	int armorStrength;
	int combatPotential;
	
	public Character(int x, int y, int w, int h, String type, int numberOfPeople, int armorStrength, int combatPotential) {
		super(x, y, w, h);
		this.type = type;
		this.armorStrength = armorStrength;
		this.combatPotential = combatPotential;
		addSequence("resources/goku.png", 250, 0, 0, w, h, 9);
		Thread animation = new Thread(this);
		animation.start();
		update();
	}
	
	public String toString() {
		return this.type + "," + this.armorStrength + "," + this.combatPotential;
	}

}
