#include "pionek.h"

Pionek::Pionek(QWidget *parent, int x, int y, int player) : Figura(parent, x, y, player)
{
    this->nazwa = "Goniec";

    if(player == 1) this->setPixmap(QPixmap(":/biale/PNG/pionek_b.png"));
    else this->setPixmap(QPixmap(":/czarne/PNG/pionek_c.png"));
}
