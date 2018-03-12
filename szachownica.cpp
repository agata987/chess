#include "szachownica.h"

Szachownica::Szachownica(QWidget *parent)
{    
    for(int i=0; i<8; i++) {
        for(int j=0; j<8; j++) {
            poleSzach[i][j] = new Pole(parent, i, j);

            if((i+j) % 2 == 0) poleSzach[i][j]->setGrafikaPola(QPixmap(":/pola/PNG/pole2.png"));
            else poleSzach[i][j]->setGrafikaPola(QPixmap(":/pola/PNG/pole1.png"));
        }
    }
}

void Szachownica::rysujFigury(QWidget *parent) {
    for(int i=0; i<8; i++) {

        for(int j=0; j<8; j++) {
            if(i==1) poleFig[i][j] = new Pionek(parent, i, j, 2);
            else if(i==6) poleFig[i][j] = new Pionek(parent, i, j, 1);
            else if(i==0 && (j==0 || j==7)) poleFig[i][j] = new Wieza(parent, i, j, 2);
            else if(i==7 && (j==0 || j==7)) poleFig[i][j] = new Wieza(parent, i, j, 1);
            else if(i==0 && (j==1 || j==6)) poleFig[i][j] = new Kon(parent, i, j, 2);
            else if(i==7 && (j==1 || j==6)) poleFig[i][j] = new Kon(parent, i, j, 1);
            else if(i==0 && (j==2 || j==5)) poleFig[i][j] = new Goniec(parent, i, j, 2);
            else if(i==7 && (j==2 || j==5)) poleFig[i][j] = new Goniec(parent, i, j, 1);
            else if(i==0 && j==3) poleFig[i][j] = new Hetman(parent, i, j, 2);
            else if(i==7 && j==3) poleFig[i][j] = new Hetman(parent, i, j, 1);
            else if(i==0 && j==4) poleFig[i][j] = new Krol(parent, i, j, 2);
            else if(i==7 && j==4) poleFig[i][j] = new Krol(parent, i, j, 1);
            else poleFig[i][j] = 0;
        }

    }
}
