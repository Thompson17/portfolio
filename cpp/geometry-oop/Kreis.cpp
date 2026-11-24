//
// Created by Thomas on 15.06.2021.
//

#include "Kreis.h"
#include <cmath>

using namespace std;

Kreis::Kreis(Punkt2D p, double r) {
    this->zentrum = std::move(p);
    this->radius = r;
}


void Kreis::setzeZentrum(const Punkt2D &p) {
    this->zentrum = p;
}

void Kreis::setzeRadius(double r) {
    this->radius = r;
}

string Kreis::toString() {
    return "Kreis: [" + zentrum.toString() + ", " + to_string((int) radius) + "]";
}

double Kreis::inhalt() {
    return M_PI * radius * radius;
}

GeoObjekt *Kreis::clone() const {
    return new Kreis(*this);
}

Kreis &Kreis::operator=(const Kreis &rhs) {
    if (this == &rhs) return *this;
    return assign(rhs);
}

Kreis &Kreis::assign(const GeoObjekt &rhs) {
    const Kreis *pK = dynamic_cast<const Kreis *>(&rhs);
    if (!pK) {
        throw OperandenPassenNicht();
    }
    GeoObjekt::assign(rhs);
    zentrum = pK->zentrum;
    radius = pK->radius;
    return *this;
}