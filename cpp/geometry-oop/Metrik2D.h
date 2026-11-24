//
// Created by Thomas on 15.06.2021.
//

#ifndef KAPITEL3_METRIK2D_H
#define KAPITEL3_METRIK2D_H
#include "MetrikVerhalten.h"
#include "Punkt2D.h"
#include <cmath>
#include <stdexcept>
using namespace std;

class Metrik2D: public MetrikVerhalten{
    double abstand(Punkt const& lhs, Punkt const& rhs){
        const Punkt2D* p1 = dynamic_cast<const Punkt2D*>(&lhs);
        const Punkt2D* p2 = dynamic_cast<const Punkt2D*>(&rhs);
        if (!p1 || !p2) {
            throw std::invalid_argument("Expected 2D points");
        }

        double a = p2->x - p1->x;
        double b = p2->y - p1->y;
        return sqrt(a * a + b * b);
    }
};
#endif //KAPITEL3_METRIK2D_H
