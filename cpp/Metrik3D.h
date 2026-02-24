//
// Created by Thomas on 15.06.2021.
//

#ifndef KAPITEL3_METRIK2D_H
#define KAPITEL3_METRIK2D_H
#include "MetrikVerhalten.h"
#include "Punkt3D.h"
#include <cmath>
using namespace std;

class Metrik3D: public MetrikVerhalten{
    double abstand(Punkt const& lhs, Punkt const& rhs){
        const Punkt3D* p1 = dynamic_cast<const Punkt3D*>(&lhs);
        const Punkt3D* p2 = dynamic_cast<const Punkt3D*>(&rhs);
        double a = p2.x - p1.x;
        double b = p2.y - p1.y;
        double c = p2.z - p1.z;
        double diagonale = sqrt(a * a + b * b);
        return sqrt(diagonale * diagonale + c * c);
    }
};

#endif //KAPITEL3_METRIK2D_H
