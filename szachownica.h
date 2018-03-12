#ifndef SZACHOWNICA_H
#define SZACHOWNICA_H

#include "pole.h"
#include "pionek.h"
#include "wieza.h"
#include "kon.h"
#include "goniec.h"
#include "hetman.h"
#include "krol.h"

class Szachownica
{
private:
    Pole *poleSzach[8][8];
    Pole *poleFig[8][8];

public:
    Szachownica(QWidget *parent);
    void rysujFigury(QWidget *parent);
};

#endif // SZACHOWNICA_H
