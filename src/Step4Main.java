package printersample_step4;

import javax.swing.UIManager;
import java.awt.*;

public class Step4Main {
	/**The application program starts from this point*/
	public Step4Main() {
		Step4Frame frame = new Step4Frame();
		//For center the window on the display.
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frame.getSize();
		frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		frame.setVisible(true);
	}
	/**The method "Main" */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		new Step4Main();
	}
}