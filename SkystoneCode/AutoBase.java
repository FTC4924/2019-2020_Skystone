package org.firstinspires.ftc.teamcode.SkystoneCode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import java.util.ArrayList;

public abstract class AutoBase extends OpMode {

    ArrayList<Command> commands;
    Command currentCommand;
    int commandIndex;

    DcMotor leftMotor;
    DcMotor rightMotor;

    public enum CommandType {
        TURN,
        MOVE
    }

    @Override
    public void init() {
        rightMotor = hardwareMap.get(DcMotor.class, "rightMotor");
        leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");
        rightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        commands = getCommands();
        currentCommand = commands.get(0);
        resetStartTime();
        commandIndex = 0;
    }

    @Override
    public void loop() {

        switch (currentCommand.commandType) {

            case MOVE:

                if (time > currentCommand.distance) {
                    startNextCommand();
                } else {
                    rightMotor.setPower(currentCommand.power);
                    leftMotor.setPower(currentCommand.power);
                }

                break;

            case TURN:

                if (time > currentCommand.angleTarget) {
                    startNextCommand();
                } else {
                    rightMotor.setPower(currentCommand.power);
                    leftMotor.setPower(-currentCommand.power);

                }

                break;
        }
    }

    public void stopMotors() {
        rightMotor.setPower(0.00);
        leftMotor.setPower(0.00);
    }

    public void startNextCommand() {
        stopMotors();
        commandIndex ++;
        if (commandIndex < commands.size()) {
            currentCommand = commands.get(commandIndex);
            resetStartTime();
        }
    }

    public abstract ArrayList<Command> getCommands();
}