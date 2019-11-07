package org.firstinspires.ftc.teamcode.SkystoneCode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import java.util.ArrayList;

public abstract class AutoBase extends OpMode {

    Command command;

    DcMotor frontRightMotor;
    DcMotor frontLeftMotor;
    DcMotor backRightMotor;
    DcMotor backLeftMotor;

    public enum CommandType {
        TURN,
        MOVE
    }

    @Override
    public void init() {
        frontRightMotor = hardwareMap.get(DcMotor.class, "frontRightMotor");
        frontLeftMotor = hardwareMap.get(DcMotor.class, "frontLeftMotor");
        backLeftMotor = hardwareMap.get(DcMotor.class, "backLeftMotor");
        backRightMotor = hardwareMap.get(DcMotor.class, "backRightMotor");
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        // command = getCommand();
    }

    @Override
    public void loop() {

        switch (command.commandType) {

            case MOVE:

                if (time > command.distance) {
                    stopMotors();
                } else {
                    frontRightMotor.setPower(command.power);
                    frontLeftMotor.setPower(command.power);
                    backLeftMotor.setPower(command.power);
                    backRightMotor.setPower(command.power);
                }

                break;

            case TURN:

                if (time > command.angleTarget) {
                    stopMotors();
                } else {
                    frontRightMotor.setPower(command.power);
                    frontLeftMotor.setPower(-command.power);
                    backLeftMotor.setPower(-command.power);
                    backRightMotor.setPower(command.power);
                }

                break;
        }
    }

    public void stopMotors() {
        frontRightMotor.setPower(0.00);
        frontLeftMotor.setPower(0.00);
        backLeftMotor.setPower(0.00);
        backRightMotor.setPower(0.00);
    }

    public abstract ArrayList<Command> getCommands();
}