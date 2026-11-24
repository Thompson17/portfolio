//
// Created by Thomas on 15.06.2021.
//

#ifndef KAPITEL3_BALL_H
#define KAPITEL3_BALL_H

#include "Punkt3D.h"
#include "GeoObjekt.h"
#include <string>

using namespace std;

class Ball : public GeoObjekt {
    double radius;
    Punkt3D zentrum;

public:
    Ball(Punkt3D z, double r);

    void setzeZentrum(Punkt3D const &p);

    void setzeRadius(double r);

    string toString();

    double inhalt();

    GeoObjekt *clone() const;

    Ball &operator=(const Ball &rhs);

    Ball &assign(const GeoObjekt &rhs);
};

#endif //KAPITEL3_BALL_H
