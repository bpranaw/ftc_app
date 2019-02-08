import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.ClassFactory;


@Autonomous(name = "TestAuto2", group = "Autonomous OpMode")
//@Disabled
public class TestAuto2 extends OpMode {

    private boolean blue1 = false;
    private boolean blue2 = false;

    @Override
    public void run() {
        if(!blue1){
            this.getRobot().getMotor1().setPower(0.5);
        }
        else if(!blue2){
            this.getRobot().getMotor2().setPower(-0.5);
        }
        else
        {
            this.getRobot().getMotor1().setPower(0);
            this.getRobot().getMotor2().setPower(0);
        }
        this.wait(0.2);




    }

    @Override
    public void repeat() {
        if(this.getRobot().getColorSensor2().blue() < Constants.COLOR_THRESHHOLD){
            this.blue1 = true;
        }
        if(this.getRobot().getColorSensor3().blue() < Constants.COLOR_THRESHHOLD){
            this.blue2 = true;
        }



    }

    @Override
    public void stop() {}
}
