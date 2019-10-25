package org.firstinspires.ftc.teamcode.SkystoneCode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "AutoTest")
public class AutoTest extends AutoBase {

    @Override
    public Command getCommand() {
        return new Command(CommandType.MOVE, 1.00, 1.00);
    }
}
