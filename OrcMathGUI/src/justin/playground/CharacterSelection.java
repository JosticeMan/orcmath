package justin.playground;

import java.util.ArrayList;

public class CharacterSelection {
	
	ArrayList<Character> animatedCharacters;

	public CharacterSelection() {
		
		animatedCharacters = new ArrayList<Character>();
		animatedCharacters.add(new Character(40, 40, 55, 69, "Mario", 3, 50, 40));
		animatedCharacters.add(new Character(100, 40, 55, 69, "Link", 3, 50, 40));
		animatedCharacters.add(new Character(160, 40, 55, 69, "Goku", 3, 50, 40));
	}

	public static void main(String[] args) {
		CharacterSelection cs = new CharacterSelection();
		System.out.println(cs.getCSVContent());
	}

	public String getCSVContent() {
		String data = "";
		for(Character c: animatedCharacters) {
			data += c;
			data += "\n";
		}
		return data;
	}
	
}
