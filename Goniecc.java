package szachy_java;

import com.trolltech.qt.gui.*;
import com.trolltech.qt.core.*;

public class Goniecc extends Figura {
	public
	Goniecc(QWidget parent, int x, int y, int player){
		super(parent, x, y, player);
		this.nazwa = "Goniec";                     // QPixmap nie dziala
		if(player == 1) this.setPixmap(QPixmap(":/biale/PNG/goniec_b.png"));
	    else this.setPixmap(QPixmap(":/czarne/PNG/goniec_c.png"));

	    this.setGeometry(x*80, y*80, 80, 80);
	};
	boolean sprawdzRuch(int x, int y){                
		 for(int i=0; i<wszystkieFigury.size(); i++) {   // brak klasy qVector dla wszystkieFigury
		        if(wszystkieFigury[i].getX() == x && wszystkieFigury[i].getY() == y
		                && wszystkieFigury[i].getPlayer() == this.player) return false;
		    }

		    if(this.x == x && this.y == y) return false;
		    else if(x-this.x == y-this.y || x-this.x == (y-this.y)*(-1)) {
		        if(x > this.x) {
		            if(y > this.y) {
		                for(int i=0; i<wszystkieFigury.size(); i++) {
		                    if((wszystkieFigury[i].getX() > this.x) && (wszystkieFigury[i].getX() < x)
		                            && (wszystkieFigury[i].getY() > this.y) && (wszystkieFigury[i].getY() < y)
		                            && (wszystkieFigury[i].getX()-this.x == wszystkieFigury[i]->getY()-this.y)
		                            && (x > this.x) && (y > this.y) && (i != this.id)) {
		                        return false;
		                    }
		                }
		            } else {
		                for(int i=0; i<wszystkieFigury.size(); i++) {
		                    if((wszystkieFigury[i].getX() > this.x) && (wszystkieFigury[i].getX() < x)
		                            && (wszystkieFigury[i].getY() > y) && (wszystkieFigury[i].getY() < this.y)
		                            && (wszystkieFigury[i].getX()-this.x == this.y-wszystkieFigury[i].getY())
		                            && (x > this.x) && (y < this.y) && (i != this.id)) return false;
		                }
		            }
		        } else {
		            if(y > this.y) {
		                for(int i=0; i<wszystkieFigury.size(); i++) {
		                    if((wszystkieFigury[i].getX() > x) && (wszystkieFigury[i].getX() < this.x)
		                            && (wszystkieFigury[i].getY() > this.y) && (wszystkieFigury[i].getY() < y)
		                            && (this.x-wszystkieFigury[i].getX() == wszystkieFigury[i].getY()-this.y)
		                            && (x < this.x) && (y > this.y) && (i != this.id)) return false;
		                }
		            } else {
		                for(int i=0; i<wszystkieFigury.size(); i++) {
		                    if((wszystkieFigury[i].getX() > x) && (wszystkieFigury[i].getX() < this.x)
		                            && (wszystkieFigury[i].getY() > y) && (wszystkieFigury[i].getY() < this.y)
		                            && (this.x-wszystkieFigury[i].getX() == this.y-wszystkieFigury[i].getY())
		                            && (x < this.x) && (y < this.y) && (i != this.id)) return false;
		                }
		            }
		        }
		        return true;
		    } else return false;
	};
}
