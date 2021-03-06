package szachy_java;

import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QWidget;
import com.trolltech.qt.gui.*;
import com.trolltech.qt.core.*;
import java.util.Vector;

public class main {

	public static void main(String[] args) {
		QApplication.initialize(args);
		MainWindow w;

	    Pole[][] poleSzach = new Pole [8][8];
	    for(int i=0; i<8; i++) {
	        for(int j=0; j<8; j++) {
	            poleSzach[i][j] = new Pole(w, j, i);
	        }
	    }

	    Vector<Figura> figury = null;

	    //BIA�E
	    figury.add(new Wieza(w, 0, 7, 1));
	    figury.add(new Wieza(w, 7, 7, 1));
	    figury.add(new Kon(w, 1, 7, 1));
	    figury.add(new Kon(w, 6, 7, 1));
	    figury.add(new Goniecc(w, 2, 7, 1));
	    figury.add(new Goniecc(w, 5, 7, 1));
	    figury.add(new Hetman(w, 3, 7, 1));
	    figury.add(new Krol(w, 4, 7, 1));
	    for(int i=0; i<8; i++) {
	        figury.add(new Pionek(w, i, 6, 1));
	    }

	    //CZARNE
	    figury.add(new Wieza(w, 0, 0, 2));
	    figury.add(new Wieza(w, 7, 0, 2));
	    figury.add(new Kon(w, 1, 0, 2));
	    figury.add(new Kon(w, 6, 0, 2));
	    figury.add(new Goniecc(w, 2, 0, 2));
	    figury.add(new Goniecc(w, 5, 0, 2));
	    figury.add(new Hetman(w, 3, 0, 2));
	    figury.add(new Krol(w, 4, 0, 2));
	    for(int i=0; i<8; i++) {
	        figury.add(new Pionek(w, i, 1, 2));
	    }

	    w.show();
		
		QApplication.execStatic();
		QApplication.shutdown();
	}

}
