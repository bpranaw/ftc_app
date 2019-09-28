import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.ClassFactory;

/*
    Class: TestAuto2

    Access: Public

    Purpose: No definitive purpose other than testing individual features and unrefined implementations.

    Arguments: None

    Outputs: None
 */
@Autonomous(name = "TestAuto2", group = "Autonomous OpMode")

public class TestAuto2 extends OpMode {

    private boolean blue1 = false;
    private boolean blue2 = false;

    @Override
    public void run() {
    this.getRobot().Land(1.0,1);




    }

    @Override
    public void repeat() {



    }

    @Override
    public void stop() {}
}
