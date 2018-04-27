package szachy_java;

import com.trolltech.qt.gui.*;
import com.trolltech.qt.core.*;

public class Krol extends Figura {
public
Krol(QWidget parent, int x, int y, int player){
	 
	    super(parent, x, y, player);
	    this.nazwa = "Krol";

	    if(player == 1) this.setPixmap(QPixmap(":/biale/PNG/krol_b.png"));
	    else this.setPixmap(QPixmap(":/czarne/PNG/krol_c.png"));

	    this.setGeometry(x*80, y*80, 80, 80);
};
boolean sprawdzRuch(int x, int y){
	 for(int i=0; i<wszystkieFigury.size(); i++) {
	        if(wszystkieFigury[i].getX() == x && wszystkieFigury[i].getY() == y
	                && wszystkieFigury[i].getPlayer() == this.player) return false;
	    }

	    if(this.x == x && this.y == y) return false;
	    else if(x-this.x < 2 && x-this.x > -2 && y-this.y < 2 && y-this.y > -2) return true;
	    else if(this.czyRuszamy == false && y-this.y == 0 && (x-this.x == 2 || x-this.x == -2)) {
	        return true;
	    } else return false;
};
}
