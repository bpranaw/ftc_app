import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.ClassFactory;


@Autonomous(name = "TestAuto2", group = "Autonomous OpMode")
//@Disabled
public class TestAuto2 extends OpMode {
    @Override
    public void run() {
        this.getRobot().RealignmentForward("blue");
    }

    @Override
    public void repeat() {



    }

    @Override
    public void stop() {}
}
