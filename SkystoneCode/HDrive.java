package org.firstinspires.ftc.teamcode.SkystoneCode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="HDrive")
public class HDrive extends OpMode {

    DcMotor rightMotor;
    DcMotor leftMotor;
    DcMotor middleWheelMotor;

    DcMotor linearSlideMotor;
    DcMotor linkageMotor;

    Servo grabberServo;

    @Override
    public void init() {
        rightMotor = hardwareMap.get(DcMotor.class, "rightMotor");
        leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");
        middleWheelMotor = hardwareMap.get(DcMotor.class, "middleWheelMotor");
        linearSlideMotor = hardwareMap.get(DcMotor.class, "linearSlideMotor");
        linkageMotor = hardwareMap.get(DcMotor.class, "linkageMotor");
        grabberServo = hardwareMap.get(Servo.class,"grabberServo");
        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        linkageMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        grabberServo.setPosition(0.50);
    }

    @Override
    public void loop() {
        telemetry.addData("leftpower",gamepad1.left_stick_y * Math.abs(gamepad1.left_stick_y));
        telemetry.addData("rightpower",gamepad1.right_stick_y * Math.abs(gamepad1.right_stick_y));
        telemetry.addData("leftstick",gamepad1.left_stick_y );
        telemetry.addData("rightstick",gamepad1.right_stick_y);

        if (gamepad1.right_stick_y > 0.01 || gamepad1.right_stick_y < -0.01) {

            rightMotor.setPower(gamepad1.right_stick_y * Math.abs(gamepad1.right_stick_y));

        } else {

            rightMotor.setPower(0.00);

        }

        if (gamepad1.left_stick_y > 0.01 || gamepad1.left_stick_y < -0.01) {

            leftMotor.setPower(gamepad1.left_stick_y * Math.abs(gamepad1.left_stick_y));

        } else {

            leftMotor.setPower(0.00);

        }

        if (gamepad1.left_bumper){

            middleWheelMotor.setPower(-0.5);

        } else if (gamepad1.right_bumper){

            middleWheelMotor.setPower(0.5);

        } else {

            middleWheelMotor.setPower(0.0);

        }

        // Arm controls
        if (gamepad2.right_stick_y > -0.01 || gamepad2.right_stick_y < 0.01) {

            linkageMotor.setPower(gamepad2.right_stick_y * Math.abs(gamepad2.right_stick_y / 2 ));

        } else {

            linkageMotor.setPower(0.01);

        }

        if (gamepad2.left_stick_y > 0.01 || gamepad2.left_stick_y < -0.01) {

            linearSlideMotor.setPower(gamepad2.left_stick_y * Math.abs(gamepad2.left_stick_y));

        } else {

            linearSlideMotor.setPower(0.00);

        }

        if (gamepad2.x) {

            grabberServo.setPosition(0.25);

        }

        if (gamepad2.y) {

            grabberServo.setPosition(0.50);

        }

        if (gamepad2.b) {

            grabberServo.setPosition(1.00);

        }
    }
}
