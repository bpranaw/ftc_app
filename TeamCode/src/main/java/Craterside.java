import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "Crater", group = "Autonomous OpMode")
//@Disabled
public class Craterside extends OpMode {
    @Override
    public void run() {


        //Hold Ontro marker
        this.getRobot().getServo1().setPosition(Constants.Close_Pos);
        //Landing / Unhooking
        this.getRobot().Land(0.25, 8.5);
        this.getRobot().RRot(0.5, 0.8);
        this.getRobot().Forward(1.0,1);

    }

    @Override
    public void repeat() {
        //this.getRobot().getMotor1().setPower(1);
        //this.getRobot().getMotor2().setPower(1);



       /*
        this.getRobot().getMotor5().setPower(0.1);

            this.getRobot().getMotor1().setPower(-0.25);
            this.getRobot().getMotor2().setPower(0.25);
            this.getRobot().getMotor3().setPower(0.25);
            this.getRobot().getMotor4().setPower(-0.25);
*/

    }

    @Override
    public void stop() {
        this.getRobot().getMotor1().setPower(0);
        this.getRobot().getMotor2().setPower(0);
        this.getRobot().getMotor3().setPower(0);
        this.getRobot().getMotor4().setPower(0);
      //  this.getRobot().getMotor5().setPower(0);

    }
}
