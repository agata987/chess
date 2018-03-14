#ifndef KROL_H
#define KROL_H

#include "figura.h"

class Krol : public Figura
{
public:
    Krol(QWidget *parent, int x, int y, int player, int id);
    bool sprawdzRuch(int x, int y);
};

#endif // KROL_H
