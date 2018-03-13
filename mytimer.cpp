#include "mytimer.h"
#include <QtCore>
#include <QDebug>

m_timer::m_timer()
{
   timer = new QTimer(this);
   connect(timer,SIGNAL(timeout()),this,SLOT(m_slot()));

   timer->start(1000);
}

void m_timer::m_slot()
{
    qDebug() <<" minela sekunda";
}
