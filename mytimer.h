#ifndef TIMER_H
#define TIMER_H

#include <QtCore>

class m_timer : public QObject
{
    Q_OBJECT

public:
    m_timer();
    QTimer *timer;

  public slots:
    void m_slot();
};

#endif // TIMER_H
