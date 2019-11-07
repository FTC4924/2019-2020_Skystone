package org.firstinspires.ftc.teamcode.SkystoneCode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="HDrive")
public class HDrive extends OpMode {

    DcMotor frontRightMotor;
    DcMotor frontLeftMotor;
    DcMotor backLeftMotor;
    DcMotor backRightMotor;
    DcMotor middleWheelMotor;

    DcMotor linearSlideMotor;
    DcMotor linkageMotor;

    Servo grabberServo;

    @Override
    public void init() {
        frontRightMotor = hardwareMap.get(DcMotor.class, "frontRightMotor");
        frontLeftMotor = hardwareMap.get(DcMotor.class, "frontLeftMotor");
        backLeftMotor = hardwareMap.get(DcMotor.class, "backLeftMotor");
        backRightMotor = hardwareMap.get(DcMotor.class, "backRightMotor");
        middleWheelMotor = hardwareMap.get(DcMotor.class, "middleWheelMotor");
        linearSlideMotor = hardwareMap.get(DcMotor.class, "linearSlideMotor");
        linkageMotor = hardwareMap.get(DcMotor.class, "linkageMotor");
        grabberServo = hardwareMap.get(Servo.class,"grabberServo");
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        grabberServo.setPosition(0.50);
    }

    @Override
    public void loop() {
        if (gamepad1.right_stick_y > 0.01 || gamepad1.right_stick_y < -0.01) {

            frontRightMotor.setPower(Math.pow(gamepad1.right_stick_y, 2));
            backRightMotor.setPower(Math.pow(gamepad1.right_stick_y, 2));

        } else {
            frontRightMotor.setPower(0.00);
            backRightMotor.setPower(0.00);
        }

        if (gamepad1.left_stick_y > 0.01 || gamepad1.left_stick_y < -0.01) {

            frontLeftMotor.setPower(Math.pow(gamepad1.left_stick_y, 2));
            backLeftMotor.setPower(Math.pow(gamepad1.left_stick_y, 2));
        } else {
            frontLeftMotor.setPower(0.00);
            backLeftMotor.setPower(0.00);
        }

        if (gamepad1.left_bumper){
            middleWheelMotor.setPower(-1.0);
        } else if (gamepad1.right_bumper){
            middleWheelMotor.setPower(1.0);
        } else {
            middleWheelMotor.setPower(0.0);
        }

        // Arm controls
        if (gamepad2.right_stick_y > 0.01 || gamepad2.right_stick_y < -0.01) {

            linkageMotor.setPower(Math.pow(gamepad2.right_stick_y, 2));

        } else {
            linkageMotor.setPower(0.00);
        }

        if (gamepad2.left_stick_y > 0.01 || gamepad2.left_stick_y < -0.01) {

            linearSlideMotor.setPower(Math.pow(gamepad2.left_stick_y, 2));

        } else {
            linearSlideMotor.setPower(0.00);
        }

        if (gamepad2.left_bumper){
            grabberServo.setPosition(0.0);
        } else if (gamepad2.right_bumper){
            grabberServo.setPosition(1.0);
        } else {
            grabberServo.setPosition(0.50);
        }

    }
}
