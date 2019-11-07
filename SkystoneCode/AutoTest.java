package org.firstinspires.ftc.teamcode.SkystoneCode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import java.util.ArrayList;
import java.util.Arrays;

@Autonomous(name = "AutoTest")
public class AutoTest extends AutoBase {

    @Override
    public ArrayList<Command> getCommands() {
        return new ArrayList<>(
            Arrays.asList(
                new Command(CommandType.MOVE, 1.00, 1.00)
            )
        );
    }
}
