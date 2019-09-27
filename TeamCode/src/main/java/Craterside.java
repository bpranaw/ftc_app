import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "Crater", group = "Autonomous OpMode")
//@Disabled
public class Craterside extends OpMode {


    @Override
    public void run() {

        //zazzles
        this.telemetry.addData("Data", 1);
        this.telemetry.update();
        this.getRobot().getServo1().setPosition(Constants.Close_Pos);

        //Hold Onto marker

        //Landing / Unhooking


        this.getRobot().Land(1, 9);


        //Marker

        this.getRobot().Forward(0.75, 0.5);
        this.getRobot().wait(0.3);
        this.getRobot().LRot(1, 0.95);

        this.getRobot().Land(-1.0,1);
        this.getRobot().wait(0.2);
        this.getRobot().Forward(1, 1.25);

        this.getRobot().wait(0.2);
        this.getRobot().LRot(1, 0.55);

        this.getRobot().Forward(1, 1.45);
        this.getRobot().RRot(1, 0.75);
        this.getRobot().wait(0.5);

        this.getRobot().getServo1().setPosition(Constants.Rest_Pos);


        this.getRobot().Backward(1,0.5);
        this.getRobot().wait(1.0);
        this.getRobot().RRot(1, 3.3);

        this.getRobot().wait(0.2);
        this.getRobot().Forward(1, 2);



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

      //  this.getRobot().getMotor5().setPower(0);

    }
}
