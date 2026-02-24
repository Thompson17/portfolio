//
// Created by Thomas on 15.06.2021.
//

#ifndef KAPITEL3_GEOOBJEKT_H
#define KAPITEL3_GEOOBJEKT_H

#include "MetrikVerhalten.h"
#include <string>

using namespace std;

struct OperandenPassenNicht : public exception {
    const char *what() const throw() {
        return "Operanden passen Nicht";
    }
};

class GeoObjekt {
protected:
    MetrikVerhalten* metrik;

public:
    virtual double inhalt() = 0;

    virtual string toString() = 0;

    virtual GeoObjekt *clone() const = 0;

    GeoObjekt &operator=(const GeoObjekt &rhs) {
        if (this == &rhs) return *this;
        return assign(rhs);
    }

    virtual GeoObjekt &assign(const GeoObjekt &rhs) {
        return *this;
    };

};

#endif //KAPITEL3_GEOOBJEKT_H
