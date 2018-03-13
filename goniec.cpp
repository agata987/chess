#include "goniec.h"

Goniec::Goniec(QWidget *parent, int x, int y, int player, int id) : Figura(parent, x, y, player, id)
{
    this->nazwa = "Goniec";

    if(player == 1) this->setPixmap(QPixmap(":/biale/PNG/goniec_b.png"));
    else this->setPixmap(QPixmap(":/czarne/PNG/goniec_c.png"));
}
