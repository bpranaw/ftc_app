import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "Crater", group = "Autonomous OpMode")
//@Disabled
public class Craterside extends OpMode {
    @Override
    public void run() {


        //Hold Onto marker

        //Landing / Unhooking
        //this.getRobot().Land(0.25, 8.5);
       // this.getRobot().LRot(1, 0.25);

        //Reorientation
       // this.getRobot().Forward(0.25, 0.75);
       // this.getRobot().RRot(0.5, 0.55);

        this.getRobot().Forward(1,0.2);
        this.wait(0.5);
        this.getRobot().RRot(1,0.6);
        this.wait(0.5);
        this.getRobot().Backward(1,0.65);

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
