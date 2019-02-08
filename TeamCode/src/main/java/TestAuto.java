import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.I2cAddr;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;

import org.firstinspires.ftc.robotcore.external.Const;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.internal.vuforia.VuforiaException;

import java.util.Locale;


@Autonomous(name = "TestAuto", group = "Autonomous OpMode")
//@Disabled
public class TestAuto extends OpMode {

    @Override
    public void run() {
        while(this.getRobot().getOpMode().opModeIsActive()) {
            this.getRobot().RealignmentBlue(0.5);
        }
    }

    @Override
    public void repeat() {}

    @Override
    public void stop() {

    }
}
