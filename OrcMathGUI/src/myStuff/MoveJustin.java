package myStuff;

public class MoveJustin implements MoveInterfaceJustin {

	ButtonInterfaceJustin button;
	public MoveJustin(ButtonInterfaceJustin button) {
		this.button = button;
	}

	@Override
	public ButtonInterfaceJustin getButton() {
		return button;
	}

}
