//
// Created by Thomas on 15.06.2021.
//

#include "Rechteck.h"
#include <cmath>

using namespace std;


Rechteck::Rechteck(Punkt2D lu, Punkt2D ro) {
    this->lu = std::move(lu);
    this->ro = std::move(ro);
}

void Rechteck::setzePunktLu(const Punkt2D &p) {
    this->lu = p;
}

void Rechteck::setzePunktRo(const Punkt2D &p) {
    this->ro = p;
}

string Rechteck::toString() {
    return "Rechteck: [" + lu.toString() + ", " + ro.toString() + "]";
}

double Rechteck::inhalt() {
    return std::abs((ro.x - lu.x) * (ro.y - lu.y));
}

GeoObjekt *Rechteck::clone() const {
    return new Rechteck(*this);
}

Rechteck &Rechteck::operator=(const Rechteck &rhs) {
    if (this == &rhs) return *this;
    return assign(rhs);
}

Rechteck &Rechteck::assign(const GeoObjekt &rhs) {
    const Rechteck *pR = dynamic_cast<const Rechteck *>(&rhs);
    if (!pR) {
        throw OperandenPassenNicht();
    }
    GeoObjekt::assign(rhs);
    lu = pR->lu;
    ro = pR->ro;
    return *this;
}



