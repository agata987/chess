#include "kon.h"

Kon::Kon(QWidget *parent, int x, int y, int player, int id) : Figura(parent, x, y, player, id)
{
    this->nazwa = "Kon";

    if(player == 1) this->setPixmap(QPixmap(":/biale/PNG/kon_b.png"));
    else this->setPixmap(QPixmap(":/czarne/PNG/kon_c.png"));
}
