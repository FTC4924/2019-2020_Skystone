package org.firstinspires.ftc.teamcode.SkystoneCode;

import static org.firstinspires.ftc.teamcode.SkystoneCode.AutoBase.CommandType;

public class Command {

    public double power;
    public double angleTarget;
    public double distance;
    public CommandType commandType;

    public Command(CommandType moveType, double target, double power) {

        commandType = moveType;

        if (moveType == CommandType.TURN) {

            angleTarget = target;

        } else {

            distance = target;
        }

        this.power = power;
    }
}
