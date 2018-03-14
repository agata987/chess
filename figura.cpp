#include "figura.h"
#include <QDebug>
//test
Figura::Figura(QWidget *parent, int x, int y, int player, int id) : Pole(parent, x, y)
{
    this->player = player;
    this->id = id;
}

void Figura::mousePressEvent(QMouseEvent *ev)
{
    offset = ev->pos();
    //qDebug() << "OFFSET : " << offset.x() << ", " << offset.y();
}

void Figura::mouseMoveEvent(QMouseEvent *ev)
{
    this->move(mapToParent(ev->pos()) - offset);
    //qDebug() << "POZYCJA : " << mapToParent(ev->pos()) - offset;
}

void Figura::mouseReleaseEvent(QMouseEvent *ev)
{
    int y = (mapToParent(ev->pos()).x() - offset.x())/80;
    int x = (mapToParent(ev->pos()).y() - offset.y())/80;
    //qDebug() << "x = " << x << ", y = " << y;

    if(x>=0 && x<=7 && y>=0 && y<=7) {

        if(this->sprawdzRuch(x, y)) {
            this->x = x;
            this->y = y;
            this->move(y*80 + 40, x*80 + 40);
        } else {
            this->move(this->y*80 + 40, this->x*80 + 40);
        }

    } else {
        this->move(this->y*80 + 40, this->x*80 + 40);
        //qDebug() << "x = " << this->x << ", y = " << this->y;
    }
}
