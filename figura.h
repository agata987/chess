#ifndef FIGURA_H
#define FIGURA_H

#include "pole.h"
#include <QMouseEvent>
#include <QPoint>

class Figura : public Pole
{
protected:
    QString nazwa;
    int player;
    QPoint offset;

public:
    Figura(QWidget *parent, int x, int y, int player);

    void mousePressEvent(QMouseEvent *ev);
    void mouseMoveEvent(QMouseEvent *ev);
    void mouseReleaseEvent(QMouseEvent *ev);
};

#endif // FIGURA_H
