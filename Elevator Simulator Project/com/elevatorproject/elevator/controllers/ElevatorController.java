
package com.nodalexchange.elevator.controllers;

import com.nodalexchange.elevator.Building;
import com.nodalexchange.elevator.Elevator.DirectionEnum;

public class ElevatorController implements com.nodalexchange.elevator.ElevatorController {

	@Override
	public void cycleElapsed(Building building) {

		for (int i = 0; i < building.getNumberOfElevators(); i++) { // for loops iterates through every elevator

			if (building.getElevator(i).getCurrentFloor() == 0) { // checks if the elevator is on the starting floor

				boolean test = checkGoingUp(building, building.getElevator(i).getElevatorNumber());

				if (test == false) {
					checkGoingDowns(building, building.getElevator(i).getElevatorNumber());
				}

			}
			if (building.getElevator(i).getCurrentFloor() != 0
					&& building.getElevator(i).getCurrentFloor() != building.getNumberOfFloors() - 1
					&& building.getElevator(i).getButtonToAnswerAtNextStop() == DirectionEnum.UP) {
				// checks if the elevator between the first and last floor and going up

				boolean test1 = checkGoingUp(building, building.getElevator(i).getElevatorNumber());

				if (test1 == false) {
					checkGoingDowns(building, building.getElevator(i).getElevatorNumber());
				}

			} else if (building.getElevator(i).getCurrentFloor() != 0
					&& building.getElevator(i).getCurrentFloor() != building.getNumberOfFloors() - 1
					&& building.getElevator(i).getButtonToAnswerAtNextStop() == DirectionEnum.DOWN) {
				// checks if the elevator between the first and last floor and going down

				boolean test3 = checkGoingDown(building, building.getElevator(i).getElevatorNumber());

				if (test3 == false)
					checkGoingUps(building, building.getElevator(i).getElevatorNumber());

			} else if (building.getElevator(i).getCurrentFloor() == building.getNumberOfFloors() - 1) {
				// checks if the elevator is on the last floor

				boolean test4 = checkGoingDown(building, building.getElevator(i).getElevatorNumber());

				if (test4 == false)
					checkGoingUps(building, building.getElevator(i).getElevatorNumber());

			}

		}

	}

	public boolean checkGoingUp(Building building, int number) {
		// this function checks for all passengers in elevator going up first and if no
		// passengers it checks all the lobbies for passengers going up returns false if
		// no passenger going up exists

		boolean flag = false;
		int nextStop = 0;

		boolean[] k = building.getElevator(number).getButtonStates();

		int p = building.getElevator(number).getCurrentFloor();

		boolean flag1 = false;

		while (p < k.length) {

			if (k[p] == true) {

				flag1 = true;
				break;

			}

			p++;
		}

		if (flag1) {

			nextStop = p;

			building.getElevator(number).setNewInstruction(nextStop,
					building.getElevator(number).getButtonToAnswerAtNextStop().UP);
			return flag1;

		}

		else if (flag1 == false) {
			for (int j = 0; j < building.getNumberOfFloors(); j++) {

				if (building.getElevatorWaitingAreaInfo(j).isUpButtonPushed()) {
					flag = true;
					nextStop = j;
					break;
				}
			}

			if (flag) {
				building.getElevator(number).setNewInstruction(nextStop,
						building.getElevator(number).getButtonToAnswerAtNextStop().UP);
				return flag;
			}

		}
		return false;

	}

	public void checkGoingDowns(Building building, int number) {
		// this function checks for all passengers in elevator going down first and if
		// no passengers it checks all the lobbies for passengers going down

		boolean trust1 = false;
		int nextStop = 0;

		boolean[] k = building.getElevator(number).getButtonStates();

		int p = building.getElevator(number).getCurrentFloor();

		boolean flag = false;

		while (p >= 0) {

			if (k[p] == true) {

				flag = true;
				break;

			}

			p--;
		}

		if (flag) {

			nextStop = p;
			trust1 = true;
			building.getElevator(number).setNewInstruction(nextStop,
					building.getElevator(number).getButtonToAnswerAtNextStop().DOWN);

		}
		if (trust1 == false) {
			for (int j = building.getNumberOfFloors() - 1; j >= 0; j--) {

				if (building.getElevatorWaitingAreaInfo(j).isDownButtonPushed()) {
					building.getElevator(number).setNewInstruction(j,
							building.getElevator(number).getButtonToAnswerAtNextStop().DOWN);
					trust1 = true;
					break;
				}
			}
		}
	}

	public void checkGoingUps(Building building, int number) {
		// this function checks for all passengers in elevator going up first and if no
		// passengers it checks all the lobbies for passengers going up

		boolean flag = false;
		int nextStop = 0;

		boolean[] k = building.getElevator(number).getButtonStates();

		int p = building.getElevator(number).getCurrentFloor();

		boolean flag1 = false;

		while (p < k.length) {

			if (k[p] == true) {

				flag1 = true;
				break;

			}

			p++;
		}

		if (flag1) {

			nextStop = p;

			building.getElevator(number).setNewInstruction(nextStop,
					building.getElevator(number).getButtonToAnswerAtNextStop().UP);

		}

		else if (flag1 == false) {
			for (int j = 0; j < building.getNumberOfFloors(); j++) {

				if (building.getElevatorWaitingAreaInfo(j).isUpButtonPushed()) {
					flag = true;
					nextStop = j;
					break;
				}
			}

			if (flag) {
				building.getElevator(number).setNewInstruction(nextStop,
						building.getElevator(number).getButtonToAnswerAtNextStop().UP);
			}

		}

	}

	public boolean checkGoingDown(Building building, int number) {
		// this function checks for all passengers in elevator going down first and if
		// no passengers it checks all the lobbies for passengers going down returns
		// false if no passenger going down exists

		boolean trust2 = false;
		int nextStop = 0;

		boolean[] k = building.getElevator(number).getButtonStates();

		int p = building.getElevator(number).getCurrentFloor();

		boolean flag = false;

		while (p >= 0) {

			if (k[p] == true) {

				flag = true;
				break;

			}

			p--;
		}

		if (flag) {

			nextStop = p;
			trust2 = true;
			building.getElevator(number).setNewInstruction(nextStop,
					building.getElevator(number).getButtonToAnswerAtNextStop().DOWN);

		}

		if (trust2 == false) {
			for (int j = building.getNumberOfFloors() - 1; j >= 0; j--) {

				if (building.getElevatorWaitingAreaInfo(j).isDownButtonPushed()) {
					building.getElevator(number).setNewInstruction(j,
							building.getElevator(number).getButtonToAnswerAtNextStop().DOWN);
					nextStop = j;
					trust2 = true;
					break;
				}
			}

			if (trust2) {
				building.getElevator(number).setNewInstruction(nextStop,
						building.getElevator(number).getButtonToAnswerAtNextStop().DOWN);
				return trust2;
			}

		}
		return false;
	}

}
