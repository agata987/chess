#include "wieza.h"

Wieza::Wieza(QWidget *parent, int x, int y, int player, int id) : Figura(parent, x, y, player, id)
{
    this->nazwa = "Goniec";

    if(player == 1) this->setPixmap(QPixmap(":/biale/PNG/wieza_b.png"));
    else this->setPixmap(QPixmap(":/czarne/PNG/wieza_c.png"));
}

bool Wieza::sprawdzRuch(int x, int y)
{
    if(x == this->x || y == this->y) {

        for(int i=0; i<wskFigury.size(); i++) {
            if(this->x > x) {
                if(wskFigury[i]->getX() < this->x && wskFigury[i]->getX() > x) return false;
            } else if(x > this->x) {
                if(wskFigury[i]->getX() < x && wskFigury[i]->getX() > this->x) return false;
            } else if(this->y > y) {
                if(wskFigury[i]->getY() < this->y && wskFigury[i]->getY() > y) return false;
            } else if(y > this->y) {
                if(wskFigury[i]->getY() < y && wskFigury[i]->getY() > this->y) return false;
            }
        }

        return true;
    } else return false;
}
