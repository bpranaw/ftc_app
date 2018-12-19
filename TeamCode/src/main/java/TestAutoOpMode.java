import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name = "DepotSideAuto", group = "Autonomous OpMode")
//@Disabled
public class TestAutoOpMode extends OpMode {
    @Override
    public void run() {
        // Values


        //Hold Onto marker
        this.getRobot().getServo1().setPosition(Constants.Close_Pos);

        //Landing / Unhooking
        this.getRobot().Land(1, 11);






        //Forwards towards depot
        this.getRobot().Forward(0.7, 0.25);

        //Sampling
        this.getRobot().LRot(1, 0.4);
        this.wait(0.2);
        this.getRobot().Backward(0.7,0.55);
       // this.getRobot().getServo2().setPosition(Constants.Ready_Pos);
        this.wait(0.2);
        this.getRobot().Forward(0.35,3.3);

      /*  int red = this.getRobot().getColorSensor1().red();
        boolean testred = this.getRobot().getColorSensor1().red() > red;
        boolean testvalue = (((this.getRobot().getColorSensor1().red() + this.getRobot().getColorSensor1().green())/ 2 ) - 5 )
                > (this.getRobot().getColorSensor1().blue() + 10);
        boolean testvaluered = (this.getRobot().getColorSensor1().red() + 5 ) > this.getRobot().getColorSensor1().green();
        if (testred & testvalue & testvaluered)
        {
            this.startTimer();
            while(this.getTimer() > 0.5)
            {
                this.getRobot().getServo2().setPosition(Constants.Down_Pos);
            }
                this.getRobot().getServo2().setPosition(Constants.Up_Pos);
        }
        */


        //Marking
        this.wait(0.2);
        this.getRobot().RRot(1,0.305);

        this.getRobot().Forward(0.7,0.3);
        this.wait(0.2);
        this.getRobot().RRot(1.0,0.315);
        this.wait(0.2);
        this.getRobot().Forward(0.7,1.2);
        this.getRobot().LRot(1,0.4);
        this.wait(0.2);
        this.getRobot().getServo1().setPosition(Constants.Rest_Pos);

        //Orientate toward crater
        this.wait(0.2);
        this.getRobot().Forward(0.5,0.2);

        //maybe .45

        this.getRobot().RRot(1, 0.42);
        this.wait(0.5);
        this.getRobot().Backward(0.7, 2);

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
