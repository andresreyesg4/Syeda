# Syeda

## Overview: What goes up must go down
Syeda is a small game built on Java using linked lists. Syeda is a plate spinner who is using three data 
structures to spin plates (her hands, a bin, and the air). her hands will be modeled with a simple data 
structure that holds a signle plate at a time. The bin will be modeled as a stack data structure which 
can hold any number of items. The air will be modeled as a queue data structure which can hold a specific number
of items. This project was completed in my Data Structures class with Professor Rusell.

## Syeda
![image of syeda](https://github.com/andresreyesg4/Syeda/blob/main/Syeda.png)
There are five plates in the picture above: 2 in the air, 1 in the bin, and 1 in each of Syeda's hands. 
The bin is a stack, new plates are placed on top and plates are taken off the top. The air is a queue, the 
front of the queue in this plate (b) and the back is plate (c). Plates are thrown into the back of the queue
and taken out of the front of the queue. This produces what is known as the "shower trick" in juggling. 

## Input Formats
No file I/O is required for this Project. 

## Implementation
This project will be built using a number of classes representing the component peices of the project. 
Here I provide a description of these classes. Each class has comments explaining the functionality of each 
method and class in further detail.

## Completed Classes and Interfaces (Completed by Instructors)
1. **The plate Class (Plate.java)** 
    This class creates plates with letters. 
1. **The Stack Interface (Stack.java)** 
    This interface outlines the required methods for the Bin class.
1. **The Queue Interface (Queue.java)** 
    This interface outlines the required methods for the Air class.
1. **The Simulate Class(Simulate.java)** 
    This class is used to simulate Syeda's movements done in ASCII. 

## Required Classes completed by Me
1. **The AttachedList<T> Class (AttachedList.java)** This class is a linked list. It implements Java's List Inerface as outlined in the class, there are also some extra methods which are slice(), reversecopy(), pack(), and flat'ten()
    Note: Not all the methods in this class are need for the simulation of Syeda. 
    1. slice():
        This method takes a linked list and cuts a piece off, and returns the rest. For example if we had a Linked list as A->B->C->D->E, and we want to slice B,C & D. 
        Then the method would remove the B, C & D and return what is left of the 
        Linked list which would be A->E. 
    
1. **The Bin Class (Bin.java)** This class implements the interface Stack<Plate>. It keeps an AttachedList
    to use as its internal storage.
    
1. **The Air Class (Air.java)** This class implements the interface Queue<plate>. It keeps an AttachedList to use its internal storage.
    
1. **The Hand Class (Hand.java)** This class can store a single item (a plate).

1. **The Spinner Class (Spinner.java)** This class does handoff between the bin, the air, and Syed's hands.

## Sample Run
1. ![Sample Run 1](https://github.com/andresreyesg4/Syeda/blob/main/SampleRun1.png)
1. ![Sample Run 2](https://github.com/andresreyesg4/Syeda/blob/main/SampleRun2.png)
1. ![Sample Run 3](https://github.com/andresreyesg4/Syeda/blob/main/SampleRun3.png)
1. ![Sample Run 4](https://github.com/andresreyesg4/Syeda/blob/main/SampleRun4.png)
1. ![Sample Run 5](https://github.com/andresreyesg4/Syeda/blob/main/SampleRun5.png)
1. ![Sample Run 6](https://github.com/andresreyesg4/Syeda/blob/main/SampleRun6.png)

