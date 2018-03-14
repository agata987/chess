#include "pionek.h"

Pionek::Pionek(QWidget *parent, int x, int y, int player, int id) : Figura(parent, x, y, player, id)
{
    this->nazwa = "Goniec";

    if(player == 1) this->setPixmap(QPixmap(":/biale/PNG/pionek_b.png"));
    else this->setPixmap(QPixmap(":/czarne/PNG/pionek_c.png"));
}

bool Pionek::sprawdzRuch(int x, int y)
{
    if(player == 1) {
        if(x-this->x == -1 && y == this->y) return true;
        else return false;
    } else {
        if(x-this->x == 1 && y == this->y) return true;
        else return false;
    }
}
