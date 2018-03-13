#include "krol.h"

Krol::Krol(QWidget *parent, int x, int y, int player, int id) : Figura(parent, x, y, player, id)
{
    this->nazwa = "Krol";

    if(player == 1) this->setPixmap(QPixmap(":/biale/PNG/krol_b.png"));
    else this->setPixmap(QPixmap(":/czarne/PNG/krol_c.png"));
}
