#include "hetman.h"

Hetman::Hetman(QWidget *parent, int x, int y, int player, int id) : Figura(parent, x, y, player, id)
{
    this->nazwa = "Hetman";

    if(player == 1) this->setPixmap(QPixmap(":/biale/PNG/hetman_b.png"));
    else this->setPixmap(QPixmap(":/czarne/PNG/hetman_c.png"));
}

bool Hetman::sprawdzRuch(int x, int y)
{
    if(x-this->x == y-this->y || x-this->x == (y-this->y)*(-1) ||
       x == this->x || y == this->y) return true;
    else return false;
}

