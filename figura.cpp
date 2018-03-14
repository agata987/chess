#include "figura.h"
#include <QDebug>
//test
Figura::Figura(QWidget *parent, int x, int y, int player, int id) : Pole(parent, x, y)
{
    this->player = player;
    this->id = id;

    wskFigury.append(this);
    //qDebug() << "TEST " << wskFigury.size();
}

QVector<Figura *> Figura::wskFigury;

void Figura::mousePressEvent(QMouseEvent *ev)
{
    offset = ev->pos();
    //qDebug() << "OFFSET : " << offset.x() << ", " << offset.y();
    qDebug() << "POCZATEK x = " << this->x << ", y = " << this->y;
}

void Figura::mouseMoveEvent(QMouseEvent *ev)
{
    this->move(mapToParent(ev->pos()) - offset);
    //qDebug() << "POZYCJA : " << mapToParent(ev->pos()) - offset;
}

void Figura::mouseReleaseEvent(QMouseEvent *ev)
{
    int x = (mapToParent(ev->pos()).x() - offset.x())/80;
    int y = (mapToParent(ev->pos()).y() - offset.y())/80;
    //qDebug() << "x = " << x << ", y = " << y;

    if(x>=0 && x<=7 && y>=0 && y<=7) {

        if(this->sprawdzRuch(x, y)) {
            this->x = x;
            this->y = y;
            this->move(x*80 + 40, y*80 + 40);
        } else {
            this->move(this->x*80 + 40, this->y*80 + 40);
        }

    } else {
        this->move(this->x*80 + 40, this->y*80 + 40);
    }
    qDebug() << "x = " << this->x << ", y = " << this->y;
}
