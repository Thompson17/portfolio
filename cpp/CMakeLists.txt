cmake_minimum_required(VERSION 3.19)
project(Kapitel3)

set(CMAKE_CXX_STANDARD 14)

add_executable(Kapitel3 main.cpp GeoObjekt.h Punkt.h Punkt2D.h Rechteck.h Kreis.h Punkt2D.cpp Rechteck.cpp Kreis.cpp MetrikVerhalten.h Metrik2D.h Metrik3D.h Punkt3D.h Punkt3D.cpp Quader.h Quader.cpp Ball.h Ball.cpp)