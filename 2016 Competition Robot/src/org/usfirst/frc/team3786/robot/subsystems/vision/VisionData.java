package org.usfirst.frc.team3786.robot.subsystems.vision;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class VisionData {
	
	private NetworkTable table;
	
	private double[] defaultValue = new double[0];
	private double[] centerX, centerY, areas, height, width;
	
	public VisionData(String address) {
		table = NetworkTable.getTable(address);
	}
	
	/**
	 * Update the current values coming over 
	 */
	public void updateValues() {
		centerX = table.getNumberArray("centerX", defaultValue);
		centerY = table.getNumberArray("centerY", defaultValue);
		areas = table.getNumberArray("area", defaultValue);
		height = table.getNumberArray("height", defaultValue);
		width = table.getNumberArray("width", defaultValue);
	}
	
	public double[] getCenterX() {
		return centerX;
	}
	
	public double[] getCenterY() {
		return centerY;
	}
	
	public double[] getAreas() {
		return areas;
	}
	
	public double[] getHeight() {
		return height;
	}
	
	public double[] getWidth() {
		return width;
	}
}
