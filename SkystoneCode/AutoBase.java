package org.firstinspires.ftc.teamcode.SkystoneCode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

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
        frontRightMotor = hardwareMap.get(DcMotor.class,  "frontRightMotor");
        frontLeftMotor = hardwareMap.get(DcMotor.class, "frontLeftMotor");
        backLeftMotor = hardwareMap.get(DcMotor.class, "backLeftMotor");
        backRightMotor = hardwareMap.get(DcMotor.class, "backRightMotor");
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        command = getCommand();
    }

    @Override
    public void loop() {
        frontRightMotor.setPower(command.power);
        frontLeftMotor.setPower(command.power);
        backLeftMotor.setPower(command.power);
        backRightMotor.setPower(command.power);
    }

    public abstract Command getCommand();
}