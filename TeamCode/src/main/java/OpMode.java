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
    private String name = "OpMode";
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

    public boolean isTimerDone(double secs) {
        return this.getTimer() >= secs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
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

    public void write(String data) {
        this.write("INFO", data);
    }

    public void write(String tag, String data) {
        Log.write(tag, data);
        telemetry.addData(Constants.ROBOT_NAME, "\n" + Log.getString());
        telemetry.update();
    }

    public void write(String data, boolean asdf) {
        telemetry.addData(Constants.ROBOT_NAME, data);
        telemetry.update();
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


    public boolean isColor(double r, double g, double b, String name) {
        name = name.toLowerCase(); // get the lower case version of the name

        switch(name) {
            case "red":
                if(r >= Constants.COLOR_THRESHOLD)
                    return true; // it is red
                break;
            case "green":
                if(g >= Constants.COLOR_THRESHOLD)
                    return true; // it is green
                break;
            case "blue":
                if(b >= Constants.COLOR_THRESHOLD)
                    return true; // it is blue
                break;
            case "white":
                if(r > Constants.COLOR_THRESHOLD && g > Constants.COLOR_THRESHOLD && b > Constants.COLOR_THRESHOLD)
                    return true;
                break;
            case "black":
                if(r < Constants.COLOR_THRESHOLD && g < Constants.COLOR_THRESHOLD && b < Constants.COLOR_THRESHOLD)
                    return true;
                break;
            default:
                // status("Unknown color (" + r + ", " + g + ", " + b + ")."); // unknown color; will get annoying if it is spamming console.
                return false;
        }

        return false; // unknown color
    }

    private double dir = 0;

    public void check() {
        if(this.getRobot().getServo1() != null && Double.isNaN(this.getRobot().getServo1().getPosition()))
            this.getRobot().getServo1().setPosition(0); // these are the default positions
    }

    public void point(double direction) {

        dir = direction;
    }

    public void drive(double power) {
        this.getRobot().getMotor1().setPower(power);
        this.getRobot().getMotor2().setPower(power);
        this.getRobot().getMotor3().setPower(power);
        this.getRobot().getMotor4().setPower(power);
       // this.getRobot().getMotor5().setPower(power);
    }
}