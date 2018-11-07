import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

@Autonomous(name = "Full Power", group = "Autonomous OpMode")
//@Disabled
public class TestAutoOpMode extends OpMode {
    @Override
    public void run() {


       this.write("here");
//This is actually the worst thing I've ever written
        this.getRobot().getMotor5().setPower(0.2);
        this.wait(3.9);
        this.getRobot().getMotor5().setPower(0);
        this.getRobot().getMotor1().setPower(-1);
        this.getRobot().getMotor2().setPower(1);
        this.getRobot().getMotor3().setPower(1);
        this.getRobot().getMotor4().setPower(-1);


        this.wait(5.0);
        this.getRobot().getMotor1().setPower(0);
        this.getRobot().getMotor2().setPower(0);

        this.getRobot().getMotor3().setPower(0);
        this.getRobot().getMotor4().setPower(0);

        this.wait(1.0);
        this.getRobot().getMotor5().setPower(0);
        this.getRobot().getMotor1().setPower(0.5);
        this.getRobot().getMotor2().setPower(0.5);
        this.getRobot().getMotor3().setPower(-0.5);
        this.getRobot().getMotor4().setPower(-0.5);

        this.wait(0.5);
        this.getRobot().getMotor1().setPower(0);
        this.getRobot().getMotor2().setPower(0);
        this.getRobot().getMotor3().setPower(0);
        this.getRobot().getMotor4().setPower(0);



        /*this.getRobot().getMotor1().getDcMotor().setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.getRobot().getMotor2().getDcMotor().setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.getRobot().getMotor3().getDcMotor().setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.getRobot().getMotor4().getDcMotor().setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        this.getRobot().getMotor1().getDcMotor().setMode(DcMotor.RunMode.RUN_TO_POSITION);
        this.getRobot().getMotor2().getDcMotor().setMode(DcMotor.RunMode.RUN_TO_POSITION);
        this.getRobot().getMotor3().getDcMotor().setMode(DcMotor.RunMode.RUN_TO_POSITION);
        this.getRobot().getMotor4().getDcMotor().setMode(DcMotor.RunMode.RUN_TO_POSITION);*/

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
        this.getRobot().getMotor5().setPower(0);

    }
}
