package szachy_java;

import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QWidget;
import com.trolltech.qt.gui.*;
import com.trolltech.qt.core.*;

public class Logi extends QTextBrowser {
	public
	Logi (QWidget parent){
		this.setGeometry(670, 400, 200, 210);
		this.setText("");
	}
	Logi (Logi wsklogi){
		this.setText(wsklogi.toPlainText());
	}
	
}
