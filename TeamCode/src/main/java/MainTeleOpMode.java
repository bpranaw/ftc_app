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
        this.getRobot().getServo1().setPosition(Constants.Close_Pos);
    }

    @Override
    public void repeat() {
        double lx = this.getGamepadA().left_stick_x;
        double ly = this.getGamepadA().left_stick_y;
        double rx = -this.getGamepadA().right_stick_x;
        double ry = this.getGamepadA().right_stick_y;
        double rt = this.getGamepadA().right_trigger;
        double lt = this.getGamepadA().left_trigger;

        boolean rb = this.getGamepadA().right_bumper;
        boolean lb = this.getGamepadA().left_bumper;

        boolean open = this.getGamepadA().y;
        boolean close = this.getGamepadA().x;
        double pos = this.getRobot().getServo1().getPosition();


        double multiplier = 0;


        if(Double.isNaN(rx) || Double.isNaN(ry)) {
            rx = 0;
            ry = 0;
        }

        if(Double.isNaN(lx) || Double.isNaN(ly)) {
            lx = 0;
            ly = 0;
        }


        Driver driver = this.getRobot().getDriver();
        //Check of controller input
        /*if(Math.abs(rx) >= Constants.TRIGGER_THRESHOLD || Math.abs(ry) >= Constants.TRIGGER_THRESHOLD) {
            double angle = Math.atan2(ry, rx);


            if (angle <= 0) {
                angle += Math.PI * 2;
            }

            driver.setDirection(angle);
            driver.setRotation(rotate);
            driver.setSpeed(1.0);

            driver.drive();
        } */
        //TEST
        //TEST

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

        /*if(rb) {
            multiplier = -0.5;
        } else if(lb) {
            multiplier = 0.5;
        }*/

        this.getRobot().getDriver().setHeight(multiplier);
        driver.drive();

        /*if(Math.abs(ly) >= Constants.TRIGGER_THRESHOLD)
        {

            if (ly >= Constants.TRIGGER_THRESHOLD)
            {
                driver.setDirection(1);
            }
            else
            {
                driver.setDirection(-1);
            }
            driver.drive();

        }
        else if( rt >= Constants.TRIGGER_THRESHOLD || lt >= Constants.TRIGGER_THRESHOLD )
        {
            if (rt > lt)
            {
                driver.setDirection(0);
                driver.setRotation(-1);

            }
            else
            {
                driver.setDirection(0);
                driver.setRotation(1);
            }
            driver.drive();

        }
        else
        {
            this.getRobot().reset();
            driver.setDirection(0);
            driver.setRotation(0);
        }*/

        if(Math.abs(ry) >= Constants.TRIGGER_THRESHOLD) {
            this.getRobot().getMotor1().setPower(ry);
            this.getRobot().getMotor2().setPower(ry);
        } else if (Math.abs(rx) >= Constants.TRIGGER_THRESHOLD) {
            this.getRobot().getMotor1().setPower(rx);
            this.getRobot().getMotor2().setPower(-rx);
        } else {
            this.getRobot().reset();
        }

    }
}
