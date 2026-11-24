//
// Created by Thomas on 15.06.2021.
//

#ifndef KAPITEL3_PUNKT_H
#define KAPITEL3_PUNKT_H

#include <string>

using namespace std;

class Punkt {
public:
    virtual ~Punkt() = default;
    virtual string toString() = 0;
};

#endif //KAPITEL3_PUNKT_H
