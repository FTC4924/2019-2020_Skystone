package org.firstinspires.ftc.teamcode.SkystoneCode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import java.util.ArrayList;
import java.util.Arrays;

import static org.firstinspires.ftc.teamcode.SkystoneCode.Constants.*;

@Autonomous(name = "ParkOnTapeRightFar")
public class ParkOnTapeRightFar extends AutoBase {

    @Override
    public ArrayList<Command> getCommands() {
        return new ArrayList<>(
                Arrays.asList(
                        new Command(CommandType.MOVE_ARM, ARM_DEFAULT_POSITION, 0.3),
                        new Command(CommandType.MOVE_LIFTER, 1.5, 0.5),
                        new Command(CommandType.MOVE_STRAIGHT, 0, 2.0, 0.5),
                        new Command(CommandType.TURN, 90.0,.5),
                        new Command(CommandType.MOVE_STRAIGHT_COLOR, 90.0,0.5),
                        new Command(CommandType.MOVE_MIDDLE_WHEEL, 90.0,1.0, 0.5)
                )
        );
    }
}
