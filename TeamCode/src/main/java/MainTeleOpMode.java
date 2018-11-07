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
    }

    @Override
    public void repeat() {
        double lx = this.getGamepadA().left_stick_x;
        double ly = this.getGamepadA().left_stick_y;
        double rx = -this.getGamepadA().right_stick_x;
        double ry = this.getGamepadA().right_stick_y;

        int multiplier = 0;

        if(this.getGamepad().right_bumper) {
            multiplier = 1;
        } else if(this.getGamepad().left_bumper) {
            multiplier = -1;
        }

        this.getRobot().getMotor5().setPower(multiplier);

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
        if(Math.abs(rx) >= Constants.TRIGGER_THRESHOLD || Math.abs(ry) >= Constants.TRIGGER_THRESHOLD) {
            double angle = Math.atan2(ry, rx);


            if (angle <= 0) {
                angle += Math.PI * 2;
            }

            driver.setDirection(angle);
            driver.setRotation(rotate);
            driver.setSpeed(1.0);

            driver.drive();
        }
        else
        {

            this.getRobot().reset();
        }
    }
}
