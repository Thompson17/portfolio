//
// Created by Thomas on 15.06.2021.
//

#ifndef KAPITEL3_PUNKT2D_H
#define KAPITEL3_PUNKT2D_H

#include "Punkt.h"
#include <string>

using namespace std;

class Punkt2D : public Punkt {
public:
    double x;
    double y;

    Punkt2D();

    Punkt2D(double x, double y);

    string toString();
};

#endif //KAPITEL3_PUNKT2D_H
