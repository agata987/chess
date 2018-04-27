package szachy_java;

import com.trolltech.qt.gui.*;
import com.trolltech.qt.core.*;

package Ui;   // jak zrobiæ namespace Ui? , interface/package/namespace?

public class MainWindow extends QMainWindow {
	Q_OBJECT   //nie ma macro w javie
public
explicit MainWindow(QWidget parent = 0){
		super(parent);          // ??
		super(Ui::MainWindow);
		
		this.setWindowTitle("Chess by Tomasz Kula & Agata Szczypiñska");
	    this.setFixedSize(900, 640);

	    b_nowaGra = new QPushButton(this);
	    b_nowaGra.setText("Nowa Gra");
	    b_nowaGra.setGeometry(700, 100, 140, 30);

	    b_poddajSie = new QPushButton(this);
	    b_poddajSie.setText("Poddaj Siê");
	    b_poddajSie.setGeometry(700, 180, 140, 30);

	    connect(b_nowaGra, SIGNAL (released()), this, SLOT (nowaGra()));
	    connect(b_poddajSie, SIGNAL (released()), this, SLOT (poddajSie()));

	};
	~MainWindow(){
		   delete ui;   // System.gc()</code> / dispose() ?
	};
	
private slots   
void nowaGra(){
   // ???
    qApp.quit();
    QProcess.startDetached(qApp.arguments()[0], qApp.arguments());
};
void poddajSie(){
	Figura.koniec(this);
};
    
private
Ui::MainWindow ui;      // trzeba jakos poprawic
QVector<Figura> figury;
QPushButton b_nowaGra;
QPushButton b_poddajSie;
	
}
