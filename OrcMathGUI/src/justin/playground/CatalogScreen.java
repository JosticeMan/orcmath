package justin.playground;

import java.util.List;

import guiTeacher.components.Button;
import guiTeacher.components.TextBox;
import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5752051210820284699L;
	
	private TextBox theField;
	private Button theButton;
	
	public CatalogScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		theField = new TextBox(40, 50, 150, 50, "Title");
		viewObjects.add(theField);
		
		theField = new TextBox(200, 50, 150, 50, "Author");
		viewObjects.add(theField);
		
		theField = new TextBox(360, 50, 150, 50, "Number of pages");
		viewObjects.add(theField);
		
		theButton = new Button(40, 110, 50, 40, "Create", null);
		viewObjects.add(theButton);
	}

}
