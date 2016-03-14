Clayton Walker
COP 4600 Fall 13
Homework 2 Extra Credit
Due: 12/2/13

For this homework, I can generically combine 2 different atoms into a molecule. What I do first is, I prompt the user to input a whole number for how many atoms the first atom needs in order to create a molecule, and do the same for the second atom. Every time a new atom is made, it is added into its respective Array list inside the ChemicalBondingCreator class. The first atoms are added in faList, and second atoms are added in saList. The Semaphore is initialized to 1, and not 0, to help with mutual exclusion. 

There is a content check for if the size of the Array lists are of a specific size needed to create a generic molecule. If the faList.size() and the saList.size() is at least what they need to be to create the molecule, then the new generic molecule can be created. 

When this happens I create a new “molecules”  and print this out that it was successfully created. When I create this “generic molecule,”  I remove the correct number of atoms from each respective atoms array list in the ChemicalBondingCreator class. I then increment a counter that keeps track of how many “generic molecules” have been created, called numMoleculesMade.

The output prints out when each kind of atom is created. When there are enough atoms of each kind, there will be a print statement announcing so. After that, the sizes of the array lists for both atoms will be printed out, showing that there are that many number of atoms available for chemical bonding. It will then print the current number of methane molecules made. Then when the atoms are successfully removed and the methane molecule created, there will be a print statement announcing so. After that, the size of both array lists is printed out again, showing that the atoms were used up in the chemical bonding process and that new ones are needed to continue making more molecules. Then the current number of methane molecules is updated and printed out. The program will continue after like this until the user stops. 

An example of the output would look like this:

Project 2 Extra Credit
How many atoms for the First atom are needed to create the molecule?
“2”
How many atoms for the Second atom are needed to create the molecule?
“1”
First atom no: 1 created. 
Second atom no: 1 created.
First atom no: 2 created.
Chemical bonding creator: enough atoms to create a generic molecule
Number of first atoms before process: 2
Number of second atoms before process: 1
Number of Generic Molecules  before process: 0
Chemical bonding creator: generic molecule successfully created!
Number of first atoms after creation: 0
Number of second atoms after creation : 0
Number of Generic Molecules after creation: 1
First atom no: 1 created. 
First atom no: 2 created.
Second atom no: 1 created.
Chemical bonding creator: enough atoms to create a generic molecule
Number of first atoms before process: 2
Number of second atoms before process: 1
Number of Generic Molecules  before process: 1
Chemical bonding creator: generic molecule successfully created!
Number of first atoms after creation: 0
Number of second atoms after creation : 0
Number of Generic Molecules after creation: 2