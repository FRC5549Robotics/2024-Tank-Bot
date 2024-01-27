package frc.robot;

import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final double ROTATION_TO_METERS = ((0.1524 * Math.PI) / (7.29 * 60)); // Not to be trusted.
    public static final double POSITION_TO_METERS = ((0.1524 * Math.PI) / 7.29);

    // DriveTrain Motor Set Up
    public static final int RIGHT_MOTOR1 = 3;//1
    public static final int RIGHT_MOTOR2 = 2;//4
    public static final int LEFT_MOTOR1 = 1;//3
    public static final int LEFT_MOTOR2 = 4;//2

    // Drivetrain Scaling Factors
    public static final double FORWARD_SCALING_FACTOR = 1;
    public static final double ROTATION_SCALING_FACTOR = 1;

    // Drivetrain Feedforward Values
    public static final double DRIVE_kS = 0.33049;
    public static final double DRIVE_kV = 0.35435;
    public static final double DRIVE_kA = 0.23814;

    // Drivetrain PID Values
    public static final double DRIVE_kP = 0.1; // 0.54511;
    public static final double DRIVE_kI = 0;
    public static final double DRIVE_kD = 0;

    // Joystick and Xbox Declaration
    public static final int XBOX_CONTROLLER = 0;

    // Differential Drive Kinematics
    public static final double trackwidth = 0.6858; // In Meters
    public static final DifferentialDriveKinematics kDriveKinematics = new DifferentialDriveKinematics(trackwidth);
    public static final double kMaxSpeedMetersPerSecond = 3;
    public static final double kMaxAccelerationMetersPerSecondSquared = 1.5;

    //shooter
    public static final int SHOOT_MOTOR_LEFT = 10;
    public static final int SHOOT_MOTOR_RIGHT = 11;
    public static final int SHOOT_TRIGGER = 3;
    public static final int SHOOTER_INTAKE_BUTTON = 1;
    public static final double SHOOTER_DEADBAND = 0.1;
    public static final double SHOOTER_SCALING_FACTOR = 1;
    public static final double SHOOTER_INTAKE_SPEED = 0.75;

    //Intooter and Pivot
    public static final int LEFT_PIVOT_MOTOR = 12;
    public static final int RIGHT_PIVOT_MOTOR = 13;
    public static final int PIVOT_JOYSTICK = 1;
    public static final double PIVOT_DEADBAND = 0.06;
    public static final double PIVOT_SCALING_FACTOR = 0.5;
    public static final int INTAKE_MOTOR = 14; 
    public static final int INTAKE_TRIGGER = 2;
    public static final double INTAKE_DEADBAND = 0.08;
    public static final double INTAKE_SCALING_FACTOR = 1;
    public static final int INTAKE_SHOOTER_BUTTON = 2;
    public static final double INTAKE_OUTTAKE_SPEED = 1;

    //Indexer
    public static final int INDEXER_MOTOR = 15;
    public static final int INDEXER_BUTTON = 3;
    public static final double INDEXER_SPEED = -0.8;
}   
