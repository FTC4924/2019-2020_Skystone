package org.firstinspires.ftc.teamcode.SkystoneCode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "AutoTestReverse")
public class AutoTestReverse extends AutoBase {

    @Override
    public Command getCommand() {
        return new Command(CommandType.MOVE, 1.00, -1.00);
    }
}
