//
// Created by Thomas on 15.06.2021.
//

#ifndef KAPITEL3_PUNKT3D_H
#define KAPITEL3_PUNKT3D_H

#include "Punkt.h"
#include <string>

using namespace std;

class Punkt3D : public Punkt {
public:
    double x;
    double y;
    double z;

    Punkt3D();

    Punkt3D(double x, double y, double z);

    string toString();
};

#endif //KAPITEL3_PUNKT3D_H
