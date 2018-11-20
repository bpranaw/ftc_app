import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

@Autonomous(name = "DepotSideAuto", group = "Autonomous OpMode")
//@Disabled
public class TestAutoOpMode extends OpMode {
    @Override
    public void run() {


        //Hold Ontro marker
        this.getRobot().getServo1().setPosition(Constants.Close_Pos);
        //Landing / Unhooking
        this.getRobot().Land(0.25, 8.5);
        this.getRobot().RRot(0.5, 0.55);

        //Reorientation
        this.getRobot().Backward(0.25, 0.75);
        this.getRobot().LRot(0.5, 0.55);
        this.getRobot().Land(-0.25, 8.5);

        //Backwards towards depot
        this.getRobot().Backward(1, 1.3);

        // Rotate / Drop
        this.getRobot().LRot(0.5, 0.55);
        this.getRobot().getServo1().setPosition(Constants.Rest_Pos);

        this.write("here");
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
