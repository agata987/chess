package szachy_java;

import com.trolltech.qt.gui.*;
import com.trolltech.qt.core.*;
import java.util.Vector;    // brak klasy qvector
import com.trolltech.qt.gui.QMouseEvent;

public class Figura extends Pole{
	private
	QPoint offset;
	static QLabel im_aktualnyRuch;
	static QLabel t_aktualnyRuch;
	
	protected
	static Vector wszystkieFigury;
	static boolean czyKoniec = false;
	QWidget w;
	int player;
	int id;
	String nazwa;
	boolean czyRuszamy;
	
	public
	Figura(int x, int y, int player){
		super(x,y);
		czyRuszamy = false;
		this.player = player;
		wszystkieFigury.push_back(this);
		
		this.id = wszystkieFigury.size()-1;
		
		if(this.logi == NULL) this.logi = new Logi(parent);
		if(t_aktualnyRuch == NULL){
			t_aktualnyRuch = new QLabel(parent);
			t_aktualnyRuch.setText("AKTUALNY RUCH");
			t_aktualnyRuch.setStyleSheet("font-size: 14px; color: black; font-weight: 400");
		    t_aktualnyRuch.setGeometry(690, 20, 120, 30);
		}
		 if(im_aktualnyRuch == NULL) {
		        im_aktualnyRuch = new QLabel(parent);    // trzeba poprawiæ grafiki
		        im_aktualnyRuch.setPixmap(QPixmap(":/gracze/PNG/player1.png"));
		        im_aktualnyRuch.setStyleSheet("border: 1px solid black;");
		        im_aktualnyRuch.setGeometry(820, 20, 30, 30);
		    }
		}
	
    ~Figura(){
    	wszystkieFigury.remove(this.id);
        for(int i=this.id; i<wszystkieFigury.size(); i++) {
            wszystkieFigury[i].setId(i);}
    };
    
    static wsklogi;
    static int aktualnyRuch = 1;
    
    boolean sprawdzRuch(int x, int y){};  // w javie w domysle wszystkie metody sa wirtualne
    
    int getX(){
    	return this.x;
    };
    int getY(){
    	return this.y;
    };
    int getPlayer(){
    	return this.player;
    };
    int getId(){
    	return this.id;
    };
    String getNazwa(){
    	return this.nazwa;
    };
    boolean getCzyRuszamy(){
    	return this.czyRuszamy;
    };
    
    void setX(int x){
    	this.x=x;
    };
    void setY(int y){
    	this.y=y;
    };
    void setId(int id){
    	this.id=id;
    };
                              // mousePressEvent moze byc protected?
    void mousePressEvent(QMouseEvent ev){
    	if(this.player == aktualnyRuch && !czyKoniec) offset = ev.pos()
    };
    void mousePressEvent(QMouseEvent ev){
    	if(this.player == aktualnyRuch && !czyKoniec) this.move(mapToParent(ev.pos()) - offset);
    };
    void mouseReleaseEvent(QMouseEvent ev){
        
        if(this.player == aktualnyRuch && !czyKoniec) {
            int x = (mapToParent(ev.pos()).x() - offset.x() + 40)/80;
            int y = (mapToParent(ev.pos()).y() - offset.y() + 40)/80;

            if(x>=0 && x<=7 && y>=0 && y<=7) {
                if(this.sprawdzRuch(x, y)) {
                    boolean czysto = true;

                    //SPRAWDZANIE ZBIJANIA
                    for(int i=0; i<wszystkieFigury.size(); i++) {
                        if((wszystkieFigury[i].getX() == x) && (wszystkieFigury[i].getY() == y)
                                && (i != this.id)) {
                            czysto = false;

                            if(this.player == wszystkieFigury[i].getPlayer()) {
                                this.move(this.x*80, this.y*80);
                            } else {
                                if(wszystkieFigury[i].getNazwa() != "Krol") {
                                    int staryX = this.x;
                                    int staryY = this.y;
                                    this.x = x;
                                    this.y = y;

                                    if(szach(x, y)) {
                                        this.x = staryX;
                                        this.y = staryY;
                                        this.move(this.x*80, this.y*80);
                                        qDebug() << "Nie mozesz tu isc bo bêdzie szach ;(";
                                    } else {
                                        qDebug() << "Ok, tu mozesz";
                                        int testX = wszystkieFigury[i].getX();
                                        int testY = wszystkieFigury[i].getY();

                                        

                                        wszystkieFigury[i].setX(-5);
                                        wszystkieFigury[i].setY(-5);

                                        if(szach(-1, -1)) {
                                            qDebug() << "a jednak drugi szach :(";
                                            this.x = staryX;
                                            this.y = staryY;
                                            this.move(staryX*80, staryY*80);
                                            wszystkieFigury[i].setX(testX);
                                            wszystkieFigury[i].setY(testY);
                                            break;
                                        }

                                        wszystkieFigury[i].setX(testX);
                                        wszystkieFigury[i].setY(testY);

                                        if(!szach(x, y)){
                                            qDebug() << "brak szacha przy zbijaniu";   //brak klasy qdebug
                                            zbijanie(wszystkieFigury[i]);
                                            this.move(x*80, y*80);

                                            if(this.czyRuszany == false) this.czyRuszany = true;

                                            if(aktualnyRuch == 1) {      // brak klasy qPixmap
                                                aktualnyRuch = 2;
                                                im_aktualnyRuch.setPixmap(QPixmap(":/gracze/PNG/player2.png"));
                                            } else {
                                                aktualnyRuch = 1;
                                                im_aktualnyRuch.setPixmap(QPixmap(":/gracze/PNG/player1.png"));
                                            }

                                            if(mat()) koniec(parentWidget());
                                        }
                                    }
                                } else {
                                    this.move(this.x*80, this.y*80);
                                }
                            }
                            break;
                        }
                    }
                    //--------------------

                    if(czysto) {
                        int staryX = this.x;
                        int staryY = this.y;

                        //MOZLIWOSC ROSZADY
                        if(this.nazwa == "Krol" && y-this.y == 0 && this.czyRuszany == false
                                && (x-this.x == 2 || x-this.x == -2)) {
                            boolean czyRoszada = true;

                            if(x-this.x == 2) {
                                for(int i=0; i<wszystkieFigury.size(); i++) {
                                    if(wszystkieFigury[i].getX() == 7 && wszystkieFigury[i].getY() == this.y
                                            && wszystkieFigury[i].getCzyRuszany() == false && wszystkieFigury[i].getNazwa() == "Wieza") {
                                        for(int j=0; j<wszystkieFigury.size(); j++) {
                                            if(wszystkieFigury[j].getX() > this.x && wszystkieFigury[j].getX() < 7
                                                    && wszystkieFigury[j].getY() == this.y && i != this.id) {
                                                czyRoszada = false;
                                                break;
                                            }
                                        }

                                        if(czyRoszada && !szach(-1, -1)) {
                                            int testX = wszystkieFigury[i].getX();

                                            this.x = x;
                                            this.y = y;
                                            wszystkieFigury[i].setX(x-1);

                                            if(!szach(-1, -1)) {
                                                qDebug() << "Lecimy z roszadka";
                                                wszystkieFigury[i].move(wszystkieFigury[i].getX()*80, wszystkieFigury[i].getY()*80);

                                                if(this.czyRuszany == false) this.czyRuszany = true;
                                                this.move(x*80, y*80);

                                                if(aktualnyRuch == 1) {
                                                    wsklogi << "Bia³e robi¹ roszadê\n";
                                                    aktualnyRuch = 2;
                                                    im_aktualnyRuch.setPixmap(QPixmap(":/gracze/PNG/player2.png"));
                                                } else {
                                                    wsklogi << "Czarne robi¹ roszadê\n";
                                                    aktualnyRuch = 1;
                                                    im_aktualnyRuch.setPixmap(QPixmap(":/gracze/PNG/player1.png"));
                                                }
                                            } else {
                                                this.x = staryX;
                                                this.y = staryY;
                                                wszystkieFigury[i].setX(testX);
                                            }
                                        } else {
                                            this.move(staryX*80, staryY*80);
                                        }
                                        break;
                                    } else {
                                        this.move(staryX*80, staryY*80);
                                    }
                                }
                            } else if(x-this.x == -2) {
                                for(int i=0; i<wszystkieFigury.size(); i++) {
                                    if(wszystkieFigury[i].getX() == 0 && wszystkieFigury[i].getY() == this.y
                                            && wszystkieFigury[i].getCzyRuszany() == false && wszystkieFigury[i].getNazwa() == "Wieza") {
                                        for(int i=0; i<wszystkieFigury.size(); i++) {
                                            if(wszystkieFigury[i].getX() > 0 && wszystkieFigury[i].getX() < this.x
                                                    && wszystkieFigury[i].getY() == this.y && i != this.id) {
                                                czyRoszada = false;
                                                break;
                                            }
                                        }

                                        if(czyRoszada && !szach(-1, -1)) {
                                            int testX = wszystkieFigury[i].getX();

                                            this.x = x;
                                            this.y = y;
                                            wszystkieFigury[i].setX(x+1);

                                            if(!szach(-1, -1)) {
                                                //qDebug() << "Lecimy z roszadka";
                                                wszystkieFigury[i].move(wszystkieFigury[i].getX()*80, wszystkieFigury[i].getY()*80);

                                                if(this.czyRuszany == false) this.czyRuszany = true;
                                                this.move(x*80, y*80);

                                                if(aktualnyRuch == 1) {
                                                    wsklogi << "Bia³e robi¹ roszadê\n";
                                                    aktualnyRuch = 2;
                                                    im_aktualnyRuch.setPixmap(QPixmap(":/gracze/PNG/player2.png"));
                                                } else {
                                                    wsklogi << "Czarne robi¹ roszadê\n";
                                                    aktualnyRuch = 1;
                                                    im_aktualnyRuch.setPixmap(QPixmap(":/gracze/PNG/player1.png"));
                                                }
                                            } else {
                                                this.x = staryX;
                                                this.y = staryY;
                                                wszystkieFigury[i].setX(testX);
                                            }
                                        } else {
                                            this.move(staryX*80, staryY*80);
                                        }
                                        break;
                                    } else {
                                        this.move(staryX*80, staryY*80);
                                    }
                                }
                            } //-----------------------------------------
                        } else {
                            int staryX = this.x;
                            int staryY = this.y;
                            this.x = x;
                            this.y = y;

                            if(szach(-1, -1)) {
                                this.x = staryX;
                                this.y = staryY;
                                this.move(this.x*80, this.y*80);
                                qDebug() << "Nie mozesz tu isc bo bêdzie szach ;(";
                            } else {
                                qDebug() << "Ok, tu mozesz";

                                if(this->czyRuszany == false) this->czyRuszany = true;
                                this->move(x*80, y*80);

                                if(aktualnyRuch == 1) {
                                    aktualnyRuch = 2;
                                    im_aktualnyRuch->setPixmap(QPixmap(":/gracze/PNG/player2.png"));
                                } else {
                                    aktualnyRuch = 1;
                                    im_aktualnyRuch->setPixmap(QPixmap(":/gracze/PNG/player1.png"));
                                }

                                if(mat()) koniec(parentWidget());
                            }
                        }
                    }
                } else {
                    this.move(this.x*80, this.y*80);
                }
            } else {
                this.move(this.x*80, this.y*80);
            }
        }
    };
    
    void zbijanie(Figura f){
    	logi<<this<<" zbija "<< f << "\n";
    	f.~Figura();
    	
    	if(this.czyRuszamy == false) this.czyRuszamy = true;
    	
    	this.x = f.getX();
    	this.y = f.getY();
    	this.move(f.getX()*80, f.getY()*80);
    }
    
    boolean szach(int x, int y)
    {
    	int idKrol;
    	for(int i=0; i<wszystkieFigury.size();i++){
    		if(wszystkieFigury[i].getNazwa() == "Krol" && wszystkieFigury[i].getPlayer()== aktualnyRuch){
    		idKrol = i;
    		break;
    		}
    	}
    	
    	int xx = wszystkieFigury[idKrol].getX();
    	int yy = wszystkieFigury[idKrol].getY();
    	
    	for(int i=0; i<wszystkieFigury.size();i++){
    	if(wszystkieFigury[i].getPlayer()!= aktualnyRuch && wszystkieFigury[i].getX() != x && wszystkieFigury[i].getY() != y)
    	{
    		if(wszystkieFigury[i].sprawdzRuch(xx, yy)) {
                return true;
            }
    	}
    	}
    	return false;
    }
    boolean mat(){
    	if(szach(-1, -1)) {
            wsklogi << "SZACH\n";}
    	if(szach(-1, -1)) {
            wsklogi << "SZACH\n";

            for(int i=0; i<wszystkieFigury.size(); i++) {
                if(wszystkieFigury[i].getPlayer() == aktualnyRuch) {
                    int stareX = wszystkieFigury[i].getX();
                    int stareY = wszystkieFigury[i].getY();

                    qDebug() << wszystkieFigury[i].getNazwa() << " " << wszystkieFigury[i].getId();
                    for(int a=0; a<8; a++) {
                        for(int b=0; b<8; b++) {
                            if(wszystkieFigury[i].sprawdzRuch(b, a)) {
                                wszystkieFigury[i].setX(b);
                                wszystkieFigury[i].setY(a);

                                bool czysto1 = true;

                                for(int j=0; j<wszystkieFigury.size(); j++) {
                                    int testX = wszystkieFigury[j].getX();
                                    int testY = wszystkieFigury[j].getY();

                                    if(wszystkieFigury[j]->getX() == b && wszystkieFigury[j]->getY() == a
                                            && i != j && wszystkieFigury[j]->getPlayer() != aktualnyRuch) {
                                        czysto1 = false;

                                        wszystkieFigury[j].setX(-5);
                                        wszystkieFigury[j].setY(-5);

                                        if(!szach(-1, -1)) {
                                            wszystkieFigury[j].setX(testX);
                                            wszystkieFigury[j].setY(testY);
                                            wszystkieFigury[i].setX(stareX);
                                            wszystkieFigury[i].setY(stareY);
                                            return false;
                                        }

                                        wszystkieFigury[j].setX(testX);
                                        wszystkieFigury[j].setY(testY);
                                        break;
                                    }
                                }

                                if(czysto1 == true) {
                                    if(!szach(-1, -1)) {
                                        wszystkieFigury[i].setX(stareX);
                                        wszystkieFigury[i].setY(stareY);
                                        return false;
                                    }
                                }

                                wszystkieFigury[i].setX(stareX);
                                wszystkieFigury[i].setY(stareY);
                            }
                        }
                    }
                    wszystkieFigury[i].setX(stareX);
                    wszystkieFigury[i].setY(stareY);
                    qDebug() << "===============";
                }
            }
            wsklogi << "... I MAT\n";
            if(aktualnyRuch == 2) wsklogi << "KONIEC GRY!!! WYGRYWAJ¥ BIA£E\nGRATULACJE\n";
            else wsklogi << "KONIEC GRY!!! WYGRYWAJ¥ CZARNE\nGRATULACJE\n";

            return true;
        } else return false;
    }
    
   static void koniec (QWidget w)
    {
	   czyKoniec = true;

	    QTextBrowser wynik = new QTextBrowser(w);
	    wynik.setGeometry(220, 300, 200, 40);
	    wynik.setStyleSheet("background-color: red; font-size: 11px; color: white;"
	                         "font-weight: 600; border: 3px solid black;");

	    if(aktualnyRuch == 2) {
	        wynik.setHtml("<p style=\"text-align: center\">KONIEC GRY!!!<br>WYGRYWAJ¥ BIA£E");
	    } else {
	        wynik.setHtml("<p style=\"text-align: center\">KONIEC GRY!!!<br>WYGRYWAJ¥ CZARNE");
	    }

	    wynik.show();
    }
    
    } ; 

   
Logi operator <<(Logi l,Figura f);     // co to?
Logi operator <<(Logi l, String s);