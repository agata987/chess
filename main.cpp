#include "mainwindow.h"
#include "szachownica.h"

#include <QApplication>
#include <QWidget>

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    QWidget *w = new QWidget;

    Szachownica *s1 = new Szachownica(w);
    s1->rozpocznijGre(w);


    w->show();
    return a.exec();
}
