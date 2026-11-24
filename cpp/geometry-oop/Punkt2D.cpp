//
// Created by Thomas on 15.06.2021.
//

#include "Punkt2D.h"
using namespace std;


Punkt2D::Punkt2D() {
    this->x = 0;
    this->y = 0;
}
Punkt2D::Punkt2D(double x, double y) {
    this->x = x;
    this->y = y;
}

string Punkt2D::toString() {
    return "(" + to_string((int)x) + ", " + to_string((int)y) + ")";
}
