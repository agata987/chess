#ifndef SZACHOWNICA_H
#define SZACHOWNICA_H

#include <QVector>

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
    QVector<Pole*> figury;

public:
    Szachownica(QWidget *parent);
    void rozpocznijGre(QWidget *parent);
};

#endif // SZACHOWNICA_H
