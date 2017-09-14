INTRODUCTION
* This is an elevtor simulator project that drops all the passengers in the elevator and in the waitin area lobbiees to their destination with efficient number of cycles per customer trip.

INPUTS TO SYSTEM LAUNCHER
* number of floors in building
* number of elevators in building
* elevator capacity
* number of cycles required to load elevator
* class that generates new passengers 
* your class that controls elevators
* last time cycle with new arriving passengers

SIMULATOR NOTES
* The simulator operates in some unit of time called a cycle.
* The simulator generates new passengers each cycle.
* In 1 cycle, an elevator can move 1 floor.
* It takes the same number of cycles for an elevator to open and close, no matter how many people are getting on or off. The actual number is one of the launcher's inputs.
* For each time cycle that passes, the controller can issue an instruction for each elevator. An instruction consists of a floor number to which you are sending the elevator for its next stop AND an indicator of which arrow (the up or the down) the elevator is answering. This last is what communicates to the passengers in a waiting area which way the elevator will go next and therefore whether or not they should get on.
* The simulation ends when all passengers have reached their destinations. Note that this will take longer than the number of cycles the system is launched with since it will take extra cycles for the elevators to get to all the passengers.
* The simulator is single-threaded and sequential, meaning that the elevators' behaviors and actions are processed one at a time in the same order during each cycle.
* The visibility in the operations package is intentional. Your implementation should only interact with the four interfaces in the com.nodalexchange.elevator package. You are certainly free to examine the com.nodalexchange.elevator.operation package code but it may be more of a distraction than a help.
* The output below is produced by the simulator after every cycle. The numbers are a count of the passengers on the elevators and in the waiting areas (as well as their intended direction). The hyphens on an elevator mean that it is currently loading and thus may be in the same place for several cycles.
* Elevators WILL NOT STOP unless you instruct them to. Elevator buttons and lobby buttons do not themselves control stops. Your controller must respond to those inputs and decide where to stop.

Example status output after n cycles:

Status after n cycles:

[FLOOR 9]  XXXXX  XXXXX  XXXXX  XXXXX     000         008 
[FLOOR 8]  XXXXX  XXXXX  XXXXX  XXXXX     000         005 
[FLOOR 7]  XXXXX  XXXXX  XXXXX  XXXXX     002         005 
[FLOOR 6]  XXXXX  XXXXX  XXXXX  XXXXX     003         002 
[FLOOR 5]  XXXXX  XXXXX  XXXXX  XXXXX     005         002 
[FLOOR 4]  XXXXX  XXXXX  XXXXX  XXXXX     006         001 
[FLOOR 3]  XXXXX  XXXXX  XXXXX  XXXXX     009         000 
[FLOOR 2]  XXXXX  XXXXX  XXXXX  XXXXX     005         000 
[FLOOR 1]   001    000    010    009      000         000 
[FLOOR 0]  XXXXX  XXXXX  XXXXX  XXXXX     000         000 
           ------------------------------------------------
           ELEV0  ELEV1  ELEV2  ELEV3   WAITING     WAITING
                                        TO GO UP   TO GO DOWN

Interior buttons currently selected:
ELEVATOR 0: 5 
ELEVATOR 1: 
ELEVATOR 2: 2 3 4 5 6 7 
ELEVATOR 3: 2 6 8 9 
