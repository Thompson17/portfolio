//
// Created by Thomas on 15.06.2021.
//


#include "Quader.h"

using namespace std;


Quader::Quader(Punkt3D luv, Punkt3D roh) {
    this->luv = std::move(luv);
    this->roh = std::move(roh);
}

void Quader::setzePunktLuv(const Punkt3D &p) {
    this->luv = p;
}

void Quader::setzePunktRoh(const Punkt3D &p) {
    this->roh = p;
}

string Quader::toString() {
    return "Quader: [" + luv.toString() + ", " + roh.toString() + "]";
}

double Quader::inhalt() {
    return abs((roh.x - luv.x) * (roh.y - luv.y) * (roh.z - luv.z));
}

GeoObjekt *Quader::clone() const {
    return new Quader(*this);
}

Quader &Quader::operator=(const Quader &rhs) {
    if (this == &rhs) return *this;
    return assign(rhs);
}

Quader &Quader::assign(const GeoObjekt &rhs) {
    const Quader *pQ = dynamic_cast<const Quader *>(&rhs);
    if (!pQ) {
        throw OperandenPassenNicht();
    }
    GeoObjekt::assign(rhs);
    luv = pQ->luv;
    roh = pQ->roh;
    return *this;
}
