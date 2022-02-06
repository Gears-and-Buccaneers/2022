// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class DriveConstants {
        public static final int kLeftParent = 0;
        public static final int kLeftChild = 1;
        public static final int kRightParent = 2;
        public static final int kRightChild = 3;
        public static final int SPEED = 50;

        public static final int kVoltageCompLevel = 11;     // this is what the old code has this value as
        public static final double kRampCoefficient = 0.1;  // this is also in the code so i am transfering it. i dont kknow if we need it but i am putting it in anyway

        public static final double kDriveCoefficient = 1;
        public static final double kTurnCoefficient = .5; // this shoud slow the turing of the bot more than the speed. this is how we can tune the speed
    }

    public static final class Controller {
        public static final int kDriverControllerPort = 0; // this is the port were the controler is conected.
        //public static final int ControllerType = -- need to think how to do this one. i am not going to do this now.
    }
}
