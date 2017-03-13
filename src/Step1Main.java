

import javax.swing.UIManager;
import java.awt.*;
import jpos.util.JposPropertiesConst;

public class Step1Main {
	/**The application program starts from this point.*/
	public Step1Main() {
		Step1Frame frame = new Step1Frame();
		//For center the window on the display.
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frame.getSize();
		frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		frame.setVisible(true);
	}
	/**The method "Main" */
	public static void main(String[] args) {
            System.setProperty(JposPropertiesConst.JPOS_POPULATOR_FILE_PROP_NAME, 
                    "C:\\Program Files\\epson\\JavaPOS\\SetupPOS\\jpos.xml");
            
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		new Step1Main();
	}
}