import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import static com.sun.tools.doclint.Entity.lt;

@TeleOp(name = "MainTeleOp", group = "Tele OpMode")
public class MainTeleOpMode extends TeleOpMode {
    private double rotate = 0;
    private double speed = 1;

    private boolean pressed = false;

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

        boolean rb = this.getGamepadA().right_bumper;
        boolean lb = this.getGamepadA().left_bumper;
        boolean lb2 = this.getGamepadB().left_bumper;
        boolean rb2 = this.getGamepadB().right_bumper;

        boolean open = this.getGamepadA().y;
        boolean close = this.getGamepadA().x;
        double pos = this.getRobot().getServo1().getPosition();



        //Aaron's Thing
        if(Double.isNaN(rx) || Double.isNaN(ry)) {
            rx = 0;
            ry = 0;
        }

        if(Double.isNaN(lx) || Double.isNaN(ly)) {
            lx = 0;
            ly = 0;
        }


        Driver driver = this.getRobot().getDriver();

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

        driver.drive();


        //Drive Base momvent

        if(Math.abs(ry) >= Constants.TRIGGER_THRESHOLD || Math.abs(ly) >= Constants.TRIGGER_THRESHOLD) {
            this.getRobot().getMotor1().setPower(ly);
            this.getRobot().getMotor2().setPower(-ry);
            }
            else
                {
            this.getRobot().reset();

        }


        //Hook slide Movement
      if( rt >= Constants.TRIGGER_THRESHOLD || lt >= Constants.TRIGGER_THRESHOLD )
        {
            if (rt > lt)
            {
                this.getRobot().getMotor3().setPower(-1);

            }
            else
            {
                this.getRobot().getMotor3().setPower(1);
            }
         }
        else
        {
            this.getRobot().getMotor3().setPower(0);
        }

        //Suction
        double pos3= this.getRobot().getServo3().getPosition();
        double pos4= this.getRobot().getServo4().getPosition();
        if (rb2){
            this.getRobot().getServo3().setPosition(1);
            this.getRobot().getServo3().setPosition(-1);
        }
        else if (lb){
            this.getRobot().getServo3().setPosition(-1);
            this.getRobot().getServo3().setPosition(1);
        }
        else{
            this.getRobot().getServo3().reset();
            this.getRobot().getServo4().reset();
        }

        if(ly2 > 0 || ly2 < 0) {
            this.getRobot().getMotor4().setPower(ly2);
        }


        this.write("here");

    }

}
