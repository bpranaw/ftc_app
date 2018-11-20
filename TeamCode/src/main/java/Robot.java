import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.util.*;

public class Robot {
    private ElapsedTime timer = new ElapsedTime(); // strictly for the wait function!

    // wheel motors
    private Motor m1 = null;
    private Motor m2 = null;
    private Motor m3 = null;
    private Motor m4 = null;
    private Motor m5 = null;

    // servos
    private Servo s1 = null;

    private ColorSensor sensorColor = null;
    private GyroSensor sensorGyro = null;
    private OpMode mode = null;

    private Driver driver = null;

    /* robot constructor, initialize stuff */
    public Robot(OpMode mode) {
        this.mode = mode;

        // create motor&servo instances
        this.m1 = new Motor(this, this.getOpMode().getMotor(Constants.M1_MOTOR));
        this.m2 = new Motor(this, this.getOpMode().getMotor(Constants.M2_MOTOR));
        this.m3 = new Motor(this, this.getOpMode().getMotor(Constants.M3_MOTOR));
        this.m4 = new Motor(this, this.getOpMode().getMotor(Constants.M4_MOTOR));
        this.s1 = new Servo(this, this.getOpMode().getServo(Constants.S1_Motor));
       // this.m5 = new Motor(this, this.getOpMode().getMotor(Constants.M5_MOTOR));
        // this.s1 = new Servo(this, this.getOpMode().getServo(Constants.S1_SERVO)); // uncomment to enable servo
        // this.s1.setCenter(0.5);

        // enable/disable encoders on motors
        this.getMotor1().setDriveMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.getMotor2().setDriveMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.getMotor3().setDriveMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.getMotor4().setDriveMode(DcMotor.RunMode.RUN_USING_ENCODER);
       // this.getMotor5().setDriveMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        this.driver = new Driver(this);

        // define sensors
        if(Constants.COLOR_SENSOR != null && Constants.COLOR_SENSOR.length() != 0)
            this.sensorColor = this.getOpMode().getColorSensor(Constants.COLOR_SENSOR);
        if(Constants.GYRO_SENSOR != null && Constants.GYRO_SENSOR.length() != 0)
            this.sensorGyro = this.getOpMode().getGyroSensor(Constants.GYRO_SENSOR);

        // calibrate sensors
        if(this.getGyroSensor() != null)
            this.getGyroSensor().calibrate();
    }


    /* get driver object */
    public Driver getDriver() {
        return this.driver;
    }

    /* drive for x seconds at x speed */
    /*public void drive(double speed, double time) {
        setPower(speed);

        this.wait(time);

        reset(); // TODO: make only main motors stop
    }*/

    /* reset all motors */
    public void reset() {
        this.getMotor1().reset();
        this.getMotor2().reset();
        this.getMotor3().reset();
        this.getMotor4().reset();
        //this.getMotor5().reset();
    }

    /* set power on all motors */
    public Driver drive(double speed, double angle) {
        return this.drive(speed, angle, 0.0);
    }

    /* set power on all motors */
    public Driver drive(double height, double angle, double rotation) {
        Driver driver = this.getDriver();

        driver.setHeight(height);
        driver.setDirection(angle);
        driver.setRotation(rotation);

        driver.drive();

        return driver;
    }

    /* get motors */
    public Motor getMotor1() {
        return this.m1;
    }
    public Motor getMotor2() {
        return this.m2;
    }
    public Motor getMotor3() {
        return this.m3;
    }
    public Motor getMotor4() {
        return this.m4;
    }
   /* public Motor getMotor5() {
        return this.m5;
    }

    /* get servos */
    public Servo getServo1() {
        return this.s1;
    }

    /* get Opmode */
    public OpMode getOpMode() {
        return this.mode;
    }

    /* get color sensor */
    public ColorSensor getColorSensor() {
        return this.sensorColor;
    }

    /* get gyro sensor */
    public GyroSensor getGyroSensor() {
        return this.sensorGyro;
    }

    /* wait x seconds */
    private void wait(double seconds) {
        timer.reset();
        while(timer.seconds() < seconds);
    }

    /*
    Landing Function (Autonomous)
    Arguments:
        Power(double: Sets power to motors (preset direction)
        Time(double): Amount of time motors should have power
    Task:
        Executes the Landing maneuver.
        1)Brings robot down by extending arm(motor 3) for an amount of time
        2)Rotates in the right direction (topside view)
    */
    public void Land( double power, double time) {
        this.getMotor3().setPower(-power);
        this.wait(1.0 * time);
        this.getMotor3().setPower(0);
    }

    /*
    Left Rotate Function (Topside View)
    Arguments:
        Speed: Speed of rotation
        Time: Time which robot will rotate.
    Task:
        Rotates left
    */
    public void LRot ( double speed, double time)
    {
        this.getMotor1().setPower(speed);
        this.getMotor2().setPower(speed);
        this.wait(time);
        this.getMotor1().setPower(0);
        this.getMotor2().setPower(0);
    }

    /*
     Rotate Right Function (Topside View)
     Arguments:
         Speed: Speed of rotation
         Time: Time which robot will rotate.
     Task:
         Rotates right
     */
    public void RRot ( double speed, double time)
    {
        this.getMotor1().setPower(-speed);
        this.getMotor2().setPower(-speed);
        this.wait(time);
        this.getMotor1().setPower(0);
        this.getMotor2().setPower(0);
    }

    /*
     Forward Function (Topside View)
     Arguments:
         Speed: Speed of movement
         Time: Time which robot will move forward
     Task:
         Goes forward
     */
    public void Forward (double speed, double time)
    {
        this.getMotor1().setPower(-speed);
        this.getMotor2().setPower(speed);
        this.wait(time);
        this.getMotor1().setPower(0);
        this.getMotor2().setPower(0);
    }

    /*
    Backward Function (Topside View)
    Arguments:
        Speed: Speed of movement
        Time: Time which robot will move backward
    Task:
        Goes backward
    */
    public void Backward (double speed, double time)
    {
        this.getMotor1().setPower(speed);
        this.getMotor2().setPower(-speed);
        this.wait(time);
        this.getMotor1().setPower(0);
        this.getMotor2().setPower(0);
    }

}