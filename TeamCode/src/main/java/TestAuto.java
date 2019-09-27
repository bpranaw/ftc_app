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

       this.getRobot().getMotor5().setPower(-0.5);
       this.wait(1.);
       this.getRobot().getMotor5().setPower(0.5);
       this.wait(1.0);
       this.getRobot().getMotor5().setPower(0);
      //
        // - this.getRobot().Forward(1,3);

    }

    @Override
    public void repeat() {}

    @Override
    public void stop() {

    }
}
