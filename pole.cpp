#include "pole.h"

int Pole::getX() const
{
    return x;
}

int Pole::getY() const
{
    return y;
}

Pole::Pole(QWidget *parent, int x, int y) : QLabel(parent)
{
    this->x = x;
    this->y = y;

    this->setGeometry(x*80 + 40, y*80 + 40, 80, 80);
    this->show();
}

void Pole::setGrafikaPola(QPixmap grafikaPola) {
    this->setPixmap(grafikaPola);
}

