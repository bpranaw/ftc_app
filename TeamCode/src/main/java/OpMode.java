import android.provider.SyncStateContract;


import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Disabled
public abstract class OpMode extends com.qualcomm.robotcore.eventloop.opmode.OpMode {
    public static String TAG = "OpMode";
    protected HardwareMap map = null;
    private Robot robot = null;
    private ElapsedTime timer = new ElapsedTime();

    public OpMode() {

    }

    public void startTimer() {
        timer.reset();
    }

    public double getTimer() {
        return timer.seconds();
    }


    public void wait(double seconds) {
        this.startTimer();

        while(this.getTimer() < seconds);
    }

    public abstract void run() throws InterruptedException;

    public abstract void repeat();

    @Override
    public void init() {
        this.map = hardwareMap;

        if(this.getHardwareMap() != null)
            this.robot = new Robot(this);


    }

    @Override
    public void loop() {
        this.repeat(); // DO NOT block!
    }

    @Override
    public void stop() {}

    @Override
    public void start() {
        this.map = hardwareMap;

        if(this.getHardwareMap() != null) {
            this.robot = new Robot(this);

            this.getRobot().getMotor1().getDcMotor().setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            this.getRobot().getMotor2().getDcMotor().setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            this.getRobot().getMotor3().getDcMotor().setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            this.getRobot().getMotor4().getDcMotor().setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
           // this.getRobot().getMotor5().getDcMotor().setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }

        new Thread(new Runnable() { public void run() {
            try {
                OpMode.this.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }}).start();
    }

    public HardwareMap getHardwareMap() {
        return this.map;
    }


    public Robot getRobot() {
        return this.robot;
    }


    public DcMotor getMotor(String name) {
        return this.getHardwareMap().dcMotor.get(name);
    }

    public Servo getServo(String name) {
        return this.getHardwareMap().servo.get(name);
    }

    public CRServo getCRServo(String name) {
        return this.getHardwareMap().crservo.get(name);
    }


}