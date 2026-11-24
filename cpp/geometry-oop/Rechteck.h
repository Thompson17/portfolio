//
// Created by Thomas on 15.06.2021.
//

#ifndef KAPITEL3_RECHTECK_H
#define KAPITEL3_RECHTECK_H

#include "Punkt2D.h"
#include "GeoObjekt.h"
#include <string>

using namespace std;

class Rechteck : public GeoObjekt {
    Punkt2D lu;
    Punkt2D ro;

public:
    Rechteck(Punkt2D lu, Punkt2D ro);

    void setzePunktLu(Punkt2D const &p);

    void setzePunktRo(Punkt2D const &p);

    string toString();

    double inhalt();

    GeoObjekt *clone() const;

    Rechteck &operator=(const Rechteck &rhs);

    Rechteck &assign(const GeoObjekt &rhs);
};

#endif //KAPITEL3_RECHTECK_H
