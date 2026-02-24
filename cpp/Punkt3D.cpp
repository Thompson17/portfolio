//
// Created by Thomas on 15.06.2021.
//

#include "Punkt3D.h"

using namespace std;


Punkt3D::Punkt3D() {
    this->x = 0;
    this->y = 0;
    this->z = 0;
}

Punkt3D::Punkt3D(double x, double y, double z) {
    this->x = x;
    this->y = y;
    this->z = z;
}

string Punkt3D::toString() {
    return "(" + to_string((int) x) + ", " + to_string((int) y) + ", " + to_string((int) z) + ")";
}
