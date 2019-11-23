package org.firstinspires.ftc.teamcode.SkystoneCode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="SingleMotorTest")
public class SingleMotorTest extends OpMode {

    DcMotor rightMotor;

    @Override
    public void init() {
        rightMotor = hardwareMap.get(DcMotor.class, "rightMotor");
    }

    @Override
    public void loop() {
        rightMotor.setPower(0.5);
    }
}
