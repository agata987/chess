package szachy_java;

import com.trolltech.qt.gui.QWidget;
import com.trolltech.qt.gui.*;
import com.trolltech.qt.gui.QPixmap;
import com.trolltech.qt.core.*;


public class Pole extends QLabel {
	
	protected
		int x, y;
	public
	    Pole(QWidget parent, int x, int y){
		this.x=x;
		this.y=y;
		this.setGeometry(y*80, x*80, 80, 80);
		// trzeba ogarn¹æ wyœwietlanie obrazów, brak klasy QPixmap
		if((x+y)%2 == 0) {QImage pole2;  pole2.load(":/pole2.png");
			this.setPixmap(QPixmap(":/pole2.png"));}
		else {this.setPixmap(arg__1);}
		
		this.show();
	};

}
