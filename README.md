# Syeda

# Overview: What goes up must go down
Syeda is a small game built on Java using linked lists. Syeda is a plate spinner who is using three data 
structures to spin plates (her hands, a bin, and the air). her hands will be modeled with a simple data 
structure that holds a signle plate at a time. The bin will be modeled as a stack data structure which 
can hold any number of items. The air will be modeled as a queue data structure which can hold a specific number
of items. This project was completed in my Data Structures class with Professor Rusell.

# Syeda
![image of syeda](/Desktop/Syeda.png)
There are five plates in the picture above: 2 in the air, 1 in the bin, and 1 in each of Syeda's hands. 
The bin is a stack, new plates are placed on top and plates are taken off the top. The air is a queue, the 
front of the queue in this plate (b) and the back is plate (c). Plates are thrown into the back of the queue
and taken out of the front of the queue. This produces what is known as the "shower trick" in juggling. 

# Input Formats
No file I/O is required for this Project. 

# Implementation
This project will be built using a number of classes representing the component peices of the project. 
Here I provide a description of these classes. Each class has comments explaining the functionality of each 
method and class in further detail.

## Completed Classes and Interfaces (Completed by Instructors)
1. **The plate Class (Plate.java)** This class creates plates with letters. 
1. **The Stack Interface (Stack.java)** This interface outlines the required methods for the Bin class.
1. **The Queue Interface (Queue.java)** This interface outlines the required methods for the Air class.
1. **The Simulate Class(Simulate.java)** This class is used to simulate Syeda's movements done in ASCII. 

## Required Classes completed by Me
