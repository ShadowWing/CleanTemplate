/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    Joystick rightStick, leftStick;
    static final int NUM_JOYSTICK_BUTTONS = 16;
    boolean[] rightStickButtonState = new boolean[(NUM_JOYSTICK_BUTTONS+1)];
    boolean[] leftStickButtonState = new boolean[(NUM_JOYSTICK_BUTTONS+1)];
            // Define joysticks being used at USB port #1 and USB port #2 on the Drivers Station
    
    DriverStationLCD lcd = DriverStationLCD.getInstance();
    
    RobotDrive robotDrive;
        // drive mode selection
    static final int UNINITIALIZED_DRIVE = 0;
    static final int ARCADE_DRIVE = 1;
    static final int TANK_DRIVE = 2;
    int driveMode;
    long counter = 0;
    Relay R1 = new Relay(1);
    Relay R2 = new Relay(2);
    Relay R3 = new Relay(3);
    
    
    String blank = "                     ";
    DigitalInput button1, button2;
    int autonSwitch1Port = 4, autonSwitch2Port = 5;
    public void robotInit() {
//        rightStick = new Joystick(1);
//        leftStick  = new Joystick(2);
//                // Iterate over all the buttons on each joystick, setting state to false for each
//        // start counting buttons at button 1
//        for (int buttonNum = 1; buttonNum <= NUM_JOYSTICK_BUTTONS; buttonNum++) {
//            rightStickButtonState[buttonNum] = false;
//            leftStickButtonState[buttonNum] = false;
//        }
//        robotDrive = new RobotDrive(1, 3, 2, 4);//you MUST have that 
        lcd.println(DriverStationLCD.Line.kUser6, 1, "Robot init running..");
        lcd.updateLCD();
//        R2D2 = new Relay(1);
//        R4P17 = new Relay(4);
        
        //LEDs on the digital sidecar should light up when the relay is enabled
        
        button1 = new DigitalInput(1, autonSwitch1Port);
        button2 = new DigitalInput(1, autonSwitch2Port);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {}
    
    public void printToLCD(String s, DriverStationLCD.Line n) {
        lcd.println(n, 1, s);
        lcd.updateLCD();
    }
    
    public void teleopPeriodic(){
        R1.set(Relay.Value.kOff);
        R2.set(Relay.Value.kForward);
        R3.set(Relay.Value.kReverse);
        printToLCD("teleop periodic", DriverStationLCD.Line.kUser1);
        printToLCD("switch 1: " + button1.get(), DriverStationLCD.Line.kUser2);
        printToLCD("switch 2: " + button2.get(), DriverStationLCD.Line.kUser3);
        counter++;
        if (counter % 1000 == 0){
             printToLCD("" + counter*20/1000 + " sec", DriverStationLCD.Line.kUser4);        
        }
    }
    /**
     * This function is called periodically during operator control
     */
//    public void teleopPeriodic() {
//         if (rightStick.getZ() <= 0) {    // Logitech Attack3 has z-polarity reversed; up is negative
//            // use arcade drive
//            robotDrive.arcadeDrive(leftStick, false);
//            lcd.println(DriverStationLCD.Line.kUser1, 1, blank);
//            lcd.println(DriverStationLCD.Line.kUser1, 1, "Using Arcade Drive");// drive with arcade style (use right stick)
//            lcd.updateLCD();
//            if (driveMode != ARCADE_DRIVE) {
//                // if newly entered arcade drive, print out a message
//                lcd.println(DriverStationLCD.Line.kUser1, 1, blank);
//                lcd.println(DriverStationLCD.Line.kUser1, 1, "Entered Arcade Drive");
//                lcd.updateLCD();
//                
//                driveMode = ARCADE_DRIVE;
//            }
//        } else {
//            // use tank drive
//            robotDrive.tankDrive(leftStick, rightStick);	// drive with tank style
//            lcd.println(DriverStationLCD.Line.kUser1, 1, blank);
//            lcd.println(DriverStationLCD.Line.kUser1, 1, "Using Tank Drive");
//            lcd.updateLCD();
//            if (driveMode != TANK_DRIVE) {
//                // if newly entered tank drive, print out a message
//                lcd.println(DriverStationLCD.Line.kUser1, 1, blank);
//                lcd.println(DriverStationLCD.Line.kUser1, 1, "Tank Drive");
//                lcd.updateLCD();
//                driveMode = TANK_DRIVE;
//            }
//        }
//    }
//    
//    /**
//     * This function is called periodically during test mode
//     */
//    public void testPeriodic() {
//    
//    }   
}
//***/Written by Jaidev Bapat, of FIRST FRC Team 3501 (Fremont High School), from Sunnyvale, California
/**Visit us at: https://http://fremontrobotics.com/
 *
 * /*/
