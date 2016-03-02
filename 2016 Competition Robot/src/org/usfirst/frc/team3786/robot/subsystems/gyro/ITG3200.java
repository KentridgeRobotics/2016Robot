package org.usfirst.frc.team3786.robot.subsystems.gyro;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ITG3200 {
	
	//Constants
	private final int WHO_AM_I 		=	0x00;
	private final int SMPLRT_DIV 	=	0x15;
	private final int DLPF_FS 		=	0x16;
	private final int INT_CFG 		=	0x17;
	private final int INT_STATUS 	=	0x1A;
	private final int TEMP_OUT_H 	=	0x1B;
	private final int TEMP_OUT_L 	=	0x1C;
	private final int GYRO_XOUT_H 	=	0x1D;
	private final int GYRO_XOUT_L 	=	0x1E;
	private final int GYRO_YOUT_H 	=	0x1F;
	private final int GYRO_YOUT_L 	=	0x20;
	private final int GYRO_ZOUT_H 	=	0x21;
	private final int GYRO_ZOUT_L 	=	0x22;
	private final int PWR_MGM 		=	0x3E;
	
	private final int DLPF_CFG_0	=	(1<<0);
	private final int DLPF_CFG_1	=	(1<<1);
	private final int DLPF_CFG_2	=	(1<<2);
	private final int DLPF_FS_SEL_0	=	(1<<3);
	private final int DLPF_FS_SEL_1	=	(1<<4);
	
	private final int PWR_MGM_CLK_SEL_0	=	(1<<0);
	private final int PWR_MGM_CLK_SEL_1 =	(1<<1);
	private final int PWR_MGM_CLK_SEL_2 =	(1<<2);
	private final int PWR_MGM_STBY_Z	=	(1<<3);
	private final int PWR_MGM_STBY_Y	=	(1<<4);
	private final int PWR_MGM_STBY_X	=	(1<<5);
	private final int PWR_MGM_SLEEP		=	(1<<6);
	private final int PWR_MGM_H_RESET	=	(1<<7);
	
	private final int INT_CFG_ACTL	=	(1<<7);
	private final int INT_CFG_OPEN	=	(1<<6);
	private final int INT_CFG_LATCH_INT_EN 	= 	(1<<5);
	private final int INT_CFG_INT_ANYRD 	= 	(1<<4);
	private final int INT_CFG_ITG_RDY_EN	=	(1<<2);
	private final int INT_CFG_RAW_RDY_EN	=	(1<<0);
	
	private final double CYCLE_TIME = 0.02;
	
	private int i2c_address;
	private I2C i2c;
	
	private double x;
	private double prevX;
	private double y;
	private double prevY;
	private double z;
	private double prevZ;
	
	private double xr;
	private double yr;
	private double zr;
	
	public ITG3200(int i2cAddress)
	{
		this.i2c_address = i2cAddress;
		i2c = new I2C(Port.kOnboard, i2cAddress);
		
		xr = 0;
		yr = 0;
		zr = 0;
	}
	
	public void begin()
	{
		System.out.println("DLPF_FS: " + (DLPF_FS_SEL_0|DLPF_FS_SEL_1|DLPF_CFG_0));
		i2c.write(DLPF_FS,  30);//DLPF_FS_SEL_0|DLPF_FS_SEL_1|DLPF_CFG_0); Made 30 for reasons
		
		i2c.write(SMPLRT_DIV, 9);
		
		System.out.println("INT_CFG: " + (INT_CFG_RAW_RDY_EN|INT_CFG_ITG_RDY_EN));
		i2c.write(INT_CFG, INT_CFG_RAW_RDY_EN | INT_CFG_ITG_RDY_EN);
		
		System.out.println("PWR_MGM: " + PWR_MGM_CLK_SEL_0);
		i2c.write(PWR_MGM, PWR_MGM_CLK_SEL_0);
		
		byte[] temp = new byte[1];
		
//		SmartDashboard.putBoolean("Address: ", i2c.addressOnly());
		i2c.read(WHO_AM_I, 1, temp);
		
		SmartDashboard.putString("WHO_AM_I: ", "" + temp[0]);
		System.out.println("Who Am I? " + temp[0]);
	}
	
	public boolean update()
	{
		byte[] temp = new byte[1];
		byte[] temp2 = new byte[1];
		
		i2c.read(GYRO_XOUT_H, 1, temp);
		
		i2c.read(GYRO_XOUT_L, 1, temp2);
		
		x = (temp[0]<<8)|temp2[0];
		
		i2c.read(GYRO_YOUT_H, 1, temp);
		
		i2c.read(GYRO_YOUT_L, 1, temp2);
		
		y = (temp[0]<<8)|temp2[0];
		
		i2c.read(GYRO_ZOUT_H, 1, temp);
		
		i2c.read(GYRO_ZOUT_L, 1, temp2);
		
		z = (temp[0]<<8)|temp2[0];
		
		if (Math.abs(x) <= 42)
		{
			x = 0;
		}
		if (Math.abs(y) <= 42)
		{
			y = 0;
		}
		if (Math.abs(z) <= 42)
		{
			z = 0;
		}
		
		xr += ((x + prevX) * CYCLE_TIME) * 0.5;
		yr += ((y + prevY) * CYCLE_TIME) * 0.5;
		zr += ((z + prevZ) * CYCLE_TIME) * 0.5;
		
		
		prevX = x;
		prevY = y;
		prevZ = z;
		
		return true;
	}
	
	private int tick = 0;
	
	public double getX()
	{
		return xr;
	}
	
	public double getY()
	{
		return yr;
	}
	
	public double getZ()
	{
		return zr;
	}
}
