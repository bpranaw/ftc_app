import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import static com.sun.tools.doclint.Entity.lt;

@TeleOp(name = "MainTeleOp", group = "Tele OpMode")
public class MainTeleOpMode extends TeleOpMode {


    @Override
    public void run() {
        // this runs when you tap the play button
        this.wait(1.0);
        this.getRobot().getServo1().setPosition(Constants.Rest_Pos);
    }

    @Override
    public void repeat() {
        double lx = this.getGamepadA().left_stick_x;
        double ly = this.getGamepadA().left_stick_y;
        double rx = -this.getGamepadA().right_stick_x;
        double ry = this.getGamepadA().right_stick_y;
        double rt = this.getGamepadA().right_trigger;
        double lt = this.getGamepadA().left_trigger;
        double ly2 = this.getGamepadB().left_stick_y;
        double ry2 = this.getGamepadB().right_stick_y;

        boolean rb = this.getGamepadA().right_bumper;
        boolean lb = this.getGamepadA().left_bumper;
        boolean lb2 = this.getGamepadB().left_bumper;
        boolean rb2 = this.getGamepadB().right_bumper;

        boolean open = this.getGamepadA().y;
        boolean close = this.getGamepadA().x;
        double pos = this.getRobot().getServo1().getPosition();


        /*
        //Aaron's Thing
        if(Double.isNaN(rx) || Double.isNaN(ry)) {
            rx = 0;
            ry = 0;
        }

        if(Double.isNaN(lx) || Double.isNaN(ly)) {
            lx = 0;
            ly = 0;
        }
        */

        /*
        Gamepad: Gamepad A
        Function: Drivebase Control
            Individual Functions:
                Claw
                Drivetrain

        */

        //Claw
        if(open)
        {
            this.getRobot().getServo1().setPosition(Constants.Close_Pos);
        }
        else if(close) {
            this.getRobot().getServo1().setPosition(Constants.Rest_Pos);
        }
        else {
            this.getRobot().getServo1().setPosition(pos);
        }


        //Drive Base momvent
        if(Math.abs(ry) >= Constants.TRIGGER_THRESHOLD || Math.abs(ly) >= Constants.TRIGGER_THRESHOLD) {
            this.getRobot().getMotor1().setPower(ly);
            this.getRobot().getMotor2().setPower(-ry);
            }
            else
                {
            this.getRobot().reset();

        }

        /*
        Gamepad: Gamepad B
        Function: Mineral Recovery
        Individual Functions:
            Extended Boy
            Bucket to Heaven
        */

        //Bucket to Heaven


    }

}
