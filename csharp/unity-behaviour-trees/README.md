# Unity Behaviour Trees – C# Workshop

## Overview

This code sample was developed as the reference solution for a Unity workshop that I prepared during my Computer Science studies.

The workshop introduced behaviour trees as an approach to implementing autonomous non-player character (NPC) behaviour using C# and Panda BT.

## Demonstrated Concepts

- Behaviour tree design
- Separation of decision-making and action implementation
- Object-oriented programming
- State and resource management
- Navigation using Unity's NavMesh system
- Vector calculations and raycasting
- Component-based game development

## Behaviour Examples

### Bee Behaviour

Autonomous bees search for available flowers, collect nectar and return to their hive. A central manager maintains the list of available flowers and controls nectar replenishment.

The behaviour tree defines the decision-making process, while the C# scripts implement the individual conditions and actions.

### Enemy Behaviour

An enemy patrols a predefined route and reacts to the player's presence based on distance, viewing angle and line of sight.

Its behaviour tree controls the transitions between patrolling, pursuing and attacking the player.

## Technologies

- C#
- Unity
- Panda BT
- Unity NavMesh

## Authorship

I prepared the original workshop and developed this reference solution to demonstrate the concepts covered by the assignment.

Minor technical corrections and formatting improvements were made during portfolio preparation in November 2026: the flower reset timestamp, flower initialisation order and Unity-specific null checks were corrected.

## Scope

This code sample contains the C# scripts and textual behaviour tree definitions rather than a complete Unity project.

Unity scenes, assets and external dependencies are not included. The sample is intended for code review and illustration and has not been compiled or runtime-tested as part of the portfolio preparation.
