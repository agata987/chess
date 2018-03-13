#include "pole.h"

Pole::Pole(QWidget *parent, int x, int y) : QLabel(parent)
{
    this->x = x;
    this->y = y;

    this->setGeometry(y*80 + 40, x*80 + 40, 80, 80);
    this->show();
}

void Pole::setGrafikaPola(QPixmap grafikaPola) {
    this->setPixmap(grafikaPola);
}

