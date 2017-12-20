package justin.playground;

import java.awt.Color;
import java.io.File;
import java.util.List;

import javax.swing.JFrame;

import guiTeacher.components.*;
import guiTeacher.interfaces.FileRequester;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen implements FileRequester {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5752051210820284699L;
	
	private TextField theField;
	private TextField theField1;
	private TextField theField2;
	private Button theButton;
	private TextArea text;
	private TextArea text1;
	private Button addButton;
	private Button deleteButton;
	private Button saveButton;
	private FileOpenButton openButton;
	private CharacterSelection c = new CharacterSelection();
	
	public CatalogScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		text = new TextArea(40, 160, 150, 50, "Alert: ");
		viewObjects.add(text);
		
		text1 = new TextArea(40, 225, 150, 50, "Catalog: \n");
		viewObjects.add(text1);
		
		theField = new TextField(40, 50, 150, 50, "Enter Character Name", "Type");
		viewObjects.add(theField);
		
		theField1 = new TextField(200, 50, 150, 50, "Enter Armor Points", "Armor Points");
		theField1.setInputType(TextField.INPUT_TYPE_NUMERIC);
		viewObjects.add(theField1);
		
		theField2 = new TextField(360, 50, 150, 50, "Enter Combat Points", "Combat Points");
		theField2.setInputType(TextField.INPUT_TYPE_NUMERIC);
		viewObjects.add(theField2);;
		
		//add , saving, deleting, save file
		
		addButton = new Button(100, 110, 50, 40, "Add", new Action() {
			
			@Override
			public void act() {
				addClicked();
			}
			
		});
		viewObjects.add(addButton);
		
		saveButton = new Button(160, 110, 50, 40, "Save", null);
		viewObjects.add(saveButton);
		
		deleteButton = new Button(220, 110, 50, 40, "Delete", null);
		viewObjects.add(deleteButton);
		
		openButton = new FileOpenButton(280, 110, 50, 40, null, this);
		viewObjects.add(openButton);
		
	}

	protected void addClicked() {
		//Verifies for duplicates and empty fields
		if(theField.getText().length() == 0 || theField1.getText().length() == 0 || theField2.getText().length() == 0) {
			text.setText("Alert: Put in some data for me to process!");
		}
		else if(text1.getText().contains(theField.getText()) && text1.getText().contains(theField1.getText()) && text1.getText().contains(theField2.getText())) {
			text.setText("Alert: No dupes!");
			theField.setText("");
			theField1.setText("");
			theField2.setText("");
		}
		else {
			c.addCharacter(new Character(theField.getText(), Integer.parseInt(theField1.getText()), Integer.parseInt(theField2.getText())));
			text.setText("Alert: Success");
			text1.setText(text1.getText() + theField.getText() + Integer.parseInt(theField1.getText()) + Integer.parseInt(theField2.getText()) + "\n");
			theField.setText("");
			theField1.setText("");
			theField2.setText("");
		}
	}

	@Override
	public void setFile(File f) {
		
	}

	@Override
	public JFrame getWindow() {
		// TODO Auto-generated method stub
		return null;
	}

}
