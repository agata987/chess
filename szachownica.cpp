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

void Szachownica::rozpocznijGre(QWidget *parent) {
    //BIALE
    figury.append(new Wieza(parent, 0, 7, 1, 0));
    figury.append(new Wieza(parent, 7, 7, 1, 1));
    figury.append(new Kon(parent, 1, 7, 1, 2));
    figury.append(new Kon(parent, 6, 7, 1, 3));
    figury.append(new Goniec(parent, 2, 7, 1, 4));
    figury.append(new Goniec(parent, 5, 7, 1, 5));
    figury.append(new Hetman(parent, 3, 7, 1, 6));
    figury.append(new Krol(parent, 4, 7, 1, 7));
    for(int i=0; i<8; i++) figury.append(new Pionek(parent, i, 6, 1, 8+i));

    //CZARNE
    figury.append(new Wieza(parent, 0, 0, 2, 16));
    figury.append(new Wieza(parent, 7, 0, 2, 17));
    figury.append(new Kon(parent, 1, 0, 2, 18));
    figury.append(new Kon(parent, 6, 0, 2, 19));
    figury.append(new Goniec(parent, 2, 0, 2, 20));
    figury.append(new Goniec(parent, 5, 0, 2, 21));
    figury.append(new Hetman(parent, 3, 0, 2, 22));
    figury.append(new Krol(parent, 4, 0, 2, 23));
    for(int i=0; i<8; i++) figury.append(new Pionek(parent, i, 1, 2, 24+i));
}
