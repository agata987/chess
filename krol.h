#ifndef KROL_H
#define KROL_H

#include "figura.h"

class Krol : public Figura
{
public:
    Krol(QWidget *parent, int x, int y, int player);
};

#endif // KROL_H