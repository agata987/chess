#ifndef GONIEC_H
#define GONIEC_H

#include "figura.h"

class Goniec : public Figura
{
public:
    Goniec(QWidget *parent, int x, int y, int player, int id);
};

#endif // GONIEC_H
