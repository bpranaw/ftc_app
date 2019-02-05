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
        try {
            DetectionOutsourcing poscheck = new DetectionOutsourcing();
            poscheck.setKey("ATGargf/////AAABmWpuExvAEkA8vwn+QkRXwaaGomLnTVATqcPQzCbbcuGhMobzznoB1HNxj/6ESuGF0KGCHuIDeGGkEKbOcFG4WykKkAUIamhENTpalbNyBkeDe0SapXIm+ddAZaLFdCwfonRfSYJCytI3D0JyfD7AQKBVPFnX4LwNjl5NCPzqnCAlFMEe55zcQP2CwGKVLoJ+hyCtCT0S+tD4xzAd09GFY18ZbWFDUm8rjTBlfywGUHl/WbSpxDb6gBaG9y2ZfV8/PAZaoq/AppVgKvKyzE80oEm09cbSTflsT4X7aAwwGOIx0ZQTGTplt0OV5dvQxEWx0bazJvf83FBtWjSTeinrr3C7NNMXLwCFlGogVTa6I8n2");

            poscheck.runOpMode();
        } catch (NullPointerException e) {
            telemetry.addData("Error", "You done goofe.");
        } catch (VuforiaException a) {
            telemetry.addData("Error", "You done goofed.");
        }
    }

    @Override
    public void repeat() {}

    @Override
    public void stop() {

    }
}
