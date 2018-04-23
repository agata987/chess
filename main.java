package szachy_java;

import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QWidget;
import com.trolltech.qt.gui.*;
import com.trolltech.qt.core.*;

public class main {

	public static void main(String[] args) {
		QApplication.initialize(args);
		MainWindow w;

	    Pole poleSzach[8][8];
	    for(int i=0; i<8; i++) {
	        for(int j=0; j<8; j++) {
	            poleSzach[i][j] = new Pole(w, j, i);
	        }
	    }

	    QVector<Figura*> figury;

	    //BIA£E
	    figury.append(new Wieza(w, 0, 7, 1));
	    figury.append(new Wieza(w, 7, 7, 1));
	    figury.append(new Kon(w, 1, 7, 1));
	    figury.append(new Kon(w, 6, 7, 1));
	    figury.append(new Goniec(w, 2, 7, 1));
	    figury.append(new Goniec(w, 5, 7, 1));
	    figury.append(new Hetman(w, 3, 7, 1));
	    figury.append(new Krol(w, 4, 7, 1));
	    for(int i=0; i<8; i++) {
	        figury.append(new Pionek(w, i, 6, 1));
	    }

	    //CZARNE
	    figury.append(new Wieza(w, 0, 0, 2));
	    figury.append(new Wieza(w, 7, 0, 2));
	    figury.append(new Kon(w, 1, 0, 2));
	    figury.append(new Kon(w, 6, 0, 2));
	    figury.append(new Goniec(w, 2, 0, 2));
	    figury.append(new Goniec(w, 5, 0, 2));
	    figury.append(new Hetman(w, 3, 0, 2));
	    figury.append(new Krol(w, 4, 0, 2));
	    for(int i=0; i<8; i++) {
	        figury.append(new Pionek(w, i, 1, 2));
	    }

	    w.show();
		
		QApplication.execStatic();
		QApplication.shutdown();
	}

}
