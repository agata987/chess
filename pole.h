#ifndef POLE_H
#define POLE_H

#include <QLabel>
#include <QPixmap>

class Pole : public QLabel
{
protected:
    int x, y;

public:
    Pole(QWidget *parent, int x, int y);
    void setGrafikaPola(QPixmap);


};

#endif // POLE_H
