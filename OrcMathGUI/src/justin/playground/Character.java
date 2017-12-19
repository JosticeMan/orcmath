package justin.playground;

import guiTeacher.components.AnimatedComponent;

public class Character extends AnimatedComponent {
	
	String imagepath;
	String type;
	int armorStrength;
	int combatPotential;
	
	public Character(String type, int armorStrength, int combatPotential) {
		super(100, 100, 100, 100);
		this.type = type;
		this.armorStrength = armorStrength;
		this.combatPotential = combatPotential;
		addSequence("resources/goku.png", 250, 40, 40, 10, 10, 9);
		Thread animation = new Thread(this);
		animation.start();
		update();
	}
	
	public String toString() {
		return this.type + "," + this.armorStrength + "," + this.combatPotential;
	}

}
