package org.usfirst.frc.team3786.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;

public class CamSwitch {
	
	private DigitalInput[] camSwitch;
	
	public CamSwitch(int[] port) {
		camSwitch[0] = new DigitalInput(port[0]);
		camSwitch[1] = new DigitalInput(port[1]);
		camSwitch[2] = new DigitalInput(port[2]);
	}
	
	public boolean areWeThereYet() {
		return camSwitch[0].get();
	}
	
	public boolean areWeClose() {
		return camSwitch[1].get();
	}
	
	public boolean didWeOverShoot() {
		return camSwitch[2].get();
	}
	
}
