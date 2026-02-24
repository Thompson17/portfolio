//
// Created by Thomas on 15.06.2021.
//

#ifndef KAPITEL3_METRIKVERHALTEN_H
#define KAPITEL3_METRIKVERHALTEN_H
#include "Punkt.h"
using namespace std;

class MetrikVerhalten{
public:
    virtual double abstand(Punkt const& lhs, Punkt const& rhs) = 0;
};

#endif //KAPITEL3_METRIKVERHALTEN_H
