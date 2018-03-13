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
    /*for(int i=0; i<8; i++) {

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

    }*/

    //BIALE
    figury.append(new Wieza(parent, 7, 0, 1, 0));
    figury.append(new Wieza(parent, 7, 7, 1, 1));
    figury.append(new Kon(parent, 7, 1, 1, 2));
    figury.append(new Kon(parent, 7, 6, 1, 3));
    figury.append(new Goniec(parent, 7, 2, 1, 4));
    figury.append(new Goniec(parent, 7, 5, 1, 5));
    figury.append(new Hetman(parent, 7, 3, 1, 6));
    figury.append(new Krol(parent, 7, 4, 1, 7));
    for(int i=0; i<8; i++) figury.append(new Pionek(parent, 6, i, 1, 8+i));

    //CZARNE
    figury.append(new Wieza(parent, 0, 0, 2, 0));
    figury.append(new Wieza(parent, 0, 7, 2, 1));
    figury.append(new Kon(parent, 0, 1, 2, 2));
    figury.append(new Kon(parent, 0, 6, 2, 3));
    figury.append(new Goniec(parent, 0, 2, 2, 4));
    figury.append(new Goniec(parent, 0, 5, 2, 5));
    figury.append(new Hetman(parent, 0, 3, 2, 6));
    figury.append(new Krol(parent, 0, 4, 2, 7));
    for(int i=0; i<8; i++) figury.append(new Pionek(parent, 1, i, 2, 8+i));
}
