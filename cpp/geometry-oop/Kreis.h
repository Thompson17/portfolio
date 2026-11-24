//
// Created by Thomas on 15.06.2021.
//

#ifndef KAPITEL3_KREIS_H
#define KAPITEL3_KREIS_H

#include "Punkt2D.h"
#include "GeoObjekt.h"
#include <string>

using namespace std;

class Kreis : public GeoObjekt {
    double radius;
    Punkt2D zentrum;

public:
    Kreis(Punkt2D z, double r);

    void setzeZentrum(Punkt2D const &p);

    void setzeRadius(double r);

    string toString();

    double inhalt();

    GeoObjekt *clone() const;

    Kreis &operator=(const Kreis &rhs);

    Kreis &assign(const GeoObjekt &rhs);
};

#endif //KAPITEL3_KREIS_H
