#ifndef PIONEK_H
#define PIONEK_H

#include "figura.h"

class Pionek : public Figura
{
public:
    Pionek(QWidget *parent, int x, int y, int player, int id);
    bool sprawdzRuch(int x, int y);
};

#endif // PIONEK_H