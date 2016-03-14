Clayton Walker
COP 4600 Fall 13
Homework 2
Due: 12/2/13

For this homework, what I do is every time a new atom is made, it is added into its respective Array list inside the ChemicalBondingCreator class. CarbonAtoms are added in caList, and HydrogenAtoms are added in haList. The Semaphore is initialized to 1, and not 0, to help with mutual exclusion. 

There is a content check for if the size of the Array lists are of a specific size needed to create a methane molecule. If the caList.size() is at least 1, and the haList.size() is at least 4, then there are 4 available Hydrogen atoms and 1 available Carbon atom. 

When this happens I create a new “methane molecules”  and print this out that it was successfully created. When I create this “methane molecules,”  I remove the 1st CarbonAtom from the caList and the first 4 HydrogenAtoms from the haList in the ChemicalBondingCreator class. I then increment a counter that keeps track of how many “methane molecules” have been created, called numMethaneMolecules.

*I took out some of the prints provided and added new ones that made tracing through the code easier for me. I also changed the count variable so that it starts at 1 and not zero, to make it easier to see that for every 4 Hydrogen atoms made, and 1 Carbon atom made, there would be 1 “methane molecule” made.

The output prints out when each kind of atom is created. When there are enough atoms of each kind, there will be a print statement announcing so. After that, the sizes of the array lists for both atoms will be printed out, showing that there are that many number of atoms available for chemical bonding. It will then print the current number of methane molecules made. Then when the atoms are successfully removed and the methane molecule created, there will be a print statement announcing so. After that, the size of both array lists is printed out again, showing that the atoms were used up in the chemical bonding process and that new ones are needed to continue making more molecules. Then the current number of methane molecules is updated and printed out. The program will continue after like this until the user stops. A known bug is that sometimes the Carbon atom # created is a little off.

An example of the output would look like: 

Project 2
Hydrogen atom no: 1 created. 
Carbon atom no: 1 created.
Hydrogen atom no: 2 created.
Hydrogen atom no: 3 created.
Hydrogen atom no: 4 created.
Chemical bonding creator: enough atoms to create a methane molecule
Number of Hydrogen atoms before process: 4
Number of Carbon atoms before process: 1
Number of Methane Molecules  before process: 0
Chemical bonding creator: methane molecule successfully created!
Number of Hydrogen atoms after creation: 0
Number of Carbon atoms after creation : 0
Number of Methane Molecules after creation: 1