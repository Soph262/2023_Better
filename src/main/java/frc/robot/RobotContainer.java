package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.autos.*;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    /* Controllers */
    private final Joystick driver = new Joystick(0);
    private final Joystick REMOVE = new Joystick(2);

    /* Drive Controls */
    private final int translationAxis = XboxController.Axis.kLeftY.value;
    private final int strafeAxis = XboxController.Axis.kLeftX.value;
    private final int rotationAxis = XboxController.Axis.kRightX.value;

    /* Driver Buttons */
    private final JoystickButton zeroGyro = new JoystickButton(driver, XboxController.Button.kBack.value);
    private final JoystickButton robotCentric = new JoystickButton(driver, XboxController.Button.kLeftBumper.value);
    private final JoystickButton clawToggle = new JoystickButton(driver, XboxController.Button.kRightBumper.value);
    private final JoystickButton armUp = new JoystickButton(driver, XboxController.Button.kB.value);
    private final JoystickButton armDown = new JoystickButton(driver, XboxController.Button.kA.value);
    private final JoystickButton armOffset = new JoystickButton(driver, XboxController.Button.kStart.value);
    private final JoystickButton wristLeft = new JoystickButton(driver, XboxController.Button.kX.value);
    private final JoystickButton wristRight = new JoystickButton(driver, XboxController.Button.kY.value);



    /* Subsystems */
    private final Swerve s_Swerve = new Swerve();
    //private final PnuematicSubsystem s_PneumaticsHub = new PnuematicSubsystem();
    private final theCLAAAWWW s_Claaawww = new theCLAAAWWW();

    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {
        s_Swerve.setDefaultCommand(
            new TeleopSwerve(
                s_Swerve, 
                () -> Math.pow(-driver.getRawAxis(translationAxis), 3), 
                () -> Math.pow(-driver.getRawAxis(strafeAxis), 3), 
                () -> -driver.getRawAxis(rotationAxis), 
                () -> robotCentric.getAsBoolean()
            )
        );


   //     s_Claaawww.setDefaultCommand(new InstantCommand(() -> s_Claaawww.stop(),s_Claaawww));

        // Configure the button bindings

    }

    /**
     * Use this method to define your button->command mappings. Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        /* Driver Buttons */
        zeroGyro.onTrue(new InstantCommand(() -> s_Swerve.zeroGyro()));
        // clawToggle.onTrue(new InstantCommand(() ->
        // s_PneumaticsHub.toggleClawSolenoid()));

        // when up button is pressed, start moving claw up
        // when down button is pressed, start moving the claw down
        // armUp.onTrue(new InstantCommand(() -> s_Claaawww.armUp()));
        // armDown.onTrue(new InstantCommand(() -> s_Claaawww.armDown()));
        // wristLeft.onTrue(new InstantCommand(() -> s_Claaawww.wristLeft()));
        // wristRight.onTrue(new InstantCommand(() -> s_Claaawww.wristRight()));


        // when up or down button is unpressed, stop moving the claw
        // when stop button is pressed, stop moving the claw
        // armUp.onFalse(new InstantCommand(() -> s_Claaawww.armStop()));
        // armDown.onFalse(new InstantCommand(() -> s_Claaawww.armStop()));
        // armOffset.onTrue(new InstantCommand(() -> s_Claaawww.setArmOffsets())); 
        // wristLeft.onFalse(new InstantCommand(() -> s_Claaawww.wristStop()));
        // wristRight.onFalse(new InstantCommand(() -> s_Claaawww.wristStop()));
    }

    /**
     * Use this to pass the autonomous c
     * command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // An ExampleCommand will run in autonomous
        return new exampleAuto(s_Swerve);
    }
}
