package org.firstinspires.ftc.teamcode.SkystoneCode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import java.util.ArrayList;
import java.util.Arrays;

@Autonomous(name = "AutoTestReverse")
public class AutoTestReverse extends AutoBase {

    @Override
    public ArrayList<Command> getCommands() {
        return new ArrayList<>(
            Arrays.asList(
                new Command(CommandType.TURN, 1.00, -1.00)
            )
        );
    }
}
