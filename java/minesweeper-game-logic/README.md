# Minesweeper Game Logic – Java

## Overview

This code sample was developed as part of a university programming assignment during my Computer Science studies.

The original project was an Android implementation of Minesweeper. This sample focuses on the underlying game logic rather than the graphical user interface.

## Demonstrated Concepts

- Object-oriented programming
- Recursive algorithms and flood fill
- Two-dimensional data structures
- Randomised mine placement
- Neighbourhood calculations
- Game state management
- Enumerations
- Separation of game logic and user interface

## Implementation

### GameManager

Manages the game state, randomised mine placement, neighbouring mine counts, recursive discovery of empty areas, flag management and win conditions.

### Minefield

Represents the playing field as a two-dimensional array of square objects.

### Square

Stores the state of an individual square, including whether it contains a mine, has been discovered or has been flagged, as well as the number of neighbouring mines.

### Difficulty

Defines three difficulty configurations with different playing field dimensions and mine counts. The original game initialisation uses the easy difficulty.

## Technologies

- Java
- Java Standard Library
- Originally developed for Android

## Authorship

I developed the game logic independently as part of a university programming assignment. The original assignment may have included supplied starter code, the exact extent of which can no longer be established.

Minor technical corrections and formatting improvements were made during portfolio preparation in November 2026: corrected row and column indices for mine placement, reused a random number generator, protected flagged and discovered squares, guarded board interactions and win conditions after game completion, removed Android-specific diagnostic logging and tidied comments and unused fields.

## Scope

This sample contains the core game logic rather than the complete Android application.

The graphical user interface, Android resources and build configuration are not included. Android-specific diagnostic logging has been removed from the game logic.

The code is intended for review and illustration rather than as a complete, executable application. It has not been compiled or runtime-tested as part of the portfolio preparation.

## Usage Assumptions

The game logic was originally designed to be controlled by the Android user interface.

- Board interaction methods expect valid row and column indices.
- The caller is responsible for invoking `updateWinCondition()` after relevant game actions.
- Timer updates and the running state are controlled externally.
- The three difficulty configurations are defined, but the original initialisation uses the easy difficulty.

These assumptions have been retained to preserve the scope of the original academic implementation.
