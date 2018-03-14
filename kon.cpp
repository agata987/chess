#include "kon.h"

Kon::Kon(QWidget *parent, int x, int y, int player, int id) : Figura(parent, x, y, player, id)
{
    this->nazwa = "Kon";

    if(player == 1) this->setPixmap(QPixmap(":/biale/PNG/kon_b.png"));
    else this->setPixmap(QPixmap(":/czarne/PNG/kon_c.png"));
}

bool Kon::sprawdzRuch(int x, int y)
{
    if(((x-this->x == 2 || x-this->x == -2) && (y-this->y == 1 || y-this->y == -1)) ||
      ((y-this->y == 2 || y-this->y == -2) && (x-this->x == 1 || x-this->x == -1))) return true;
    else return false;
}
