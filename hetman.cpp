#include "hetman.h"

Hetman::Hetman(QWidget *parent, int x, int y, int player) : Figura(parent, x, y, player)
{
    this->nazwa = "Hetman";

    if(player == 1) this->setPixmap(QPixmap(":/biale/PNG/hetman_b.png"));
    else this->setPixmap(QPixmap(":/czarne/PNG/hetman_c.png"));
}

