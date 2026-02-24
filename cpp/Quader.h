//
// Created by Thomas on 15.06.2021.
//

#ifndef KAPITEL3_QUADER_H
#define KAPITEL3_QUADER_H

#include "Punkt3D.h"
#include "GeoObjekt.h"
#include <string>

using namespace std;

class Quader : public GeoObjekt {
    Punkt3D luv;
    Punkt3D roh;

public:
    Quader(Punkt3D lu, Punkt3D ro);

    void setzePunktLuv(Punkt3D const &p);

    void setzePunktRoh(Punkt3D const &p);

    string toString();

    double inhalt();

    GeoObjekt *clone() const;

    Quader &operator=(const Quader &rhs);

    Quader &assign(const GeoObjekt &rhs);
};

#endif //KAPITEL3_QUADER_H
