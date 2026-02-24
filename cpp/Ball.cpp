//
// Created by Thomas on 15.06.2021.
//

#include "Ball.h"
#include <cmath>

using namespace std;

Ball::Ball(Punkt3D p, double r) {
    this->zentrum = std::move(p);
    this->radius = r;
}


void Ball::setzeZentrum(const Punkt3D &p) {
    this->zentrum = p;
}

void Ball::setzeRadius(double r) {
    this->radius = r;
}

string Ball::toString() {
    return "Ball: [" + zentrum.toString() + ", " + to_string((int) radius) + "]";
}

double Ball::inhalt() {
    return M_PI * radius * radius * radius * 4.0 / 3.0;
}

GeoObjekt *Ball::clone() const {
    return new Ball(*this);
}

Ball &Ball::operator=(const Ball &rhs) {
    if (this == &rhs) return *this;
    return assign(rhs);
}

Ball &Ball::assign(const GeoObjekt &rhs) {
    const Ball *pB = dynamic_cast<const Ball *>(&rhs);
    if (!pB) {
        throw OperandenPassenNicht();
    }
    GeoObjekt::assign(rhs);
    zentrum = pB->zentrum;
    radius = pB->radius;
    return *this;
}