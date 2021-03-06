package org.firstinspires.ftc.teamcode.teleop.inputs;

import org.firstinspires.ftc.teamcode.settings.GlobalVariables;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

public class DriveInput extends Input{

    public DriveInput(GlobalVariables vars){
        super.vars = vars;
    }

    @Override
    public void update() {
        double drive = -vars.gamepad1.left_stick_y;
        double turn  =  vars.gamepad1.right_stick_x;

        double leftPower = Range.clip(drive + turn, -1.0, 1.0);
        double rightPower   = Range.clip(drive - turn, -1.0, 1.0);

        vars.fl.setPower(leftPower);
        vars.bl.setPower(leftPower);
        vars.fr.setPower(rightPower);
        vars.br.setPower(rightPower);
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {
        for (DcMotor wheel : vars.wheels) {
            wheel.setPower(0);
        }
    }
}
