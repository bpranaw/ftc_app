import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.util.*;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;


public class Robot {
    private ElapsedTime timer = new ElapsedTime(); // strictly for the wait function!

    // wheel motors
    private Motor m1 = null;
    private Motor m2 = null;
    private Motor m3 = null;
    private Motor m4 = null;
    private Motor m5 = null;


    // servos
    private Servo s1;
    private Servo s2;
    private Servo s3;
    private Servo s4;


    //Sensors

    private ColorSensor cs1 = null;
    private ColorSensor cs2 = null;
    private ColorSensor cs3 = null;
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
        this.s1 = new Servo(this, this.getOpMode().getServo(Constants.S1_Servo));
        this.s2 = new Servo(this, this.getOpMode().getServo(Constants.S2_Servo));
        this.s3 = new Servo(this, this.getOpMode().getServo(Constants.S3_Servo));
        this.s4 = new Servo(this, this.getOpMode().getServo(Constants.S4_Servo));
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
        cs1 = this.getOpMode().getHardwareMap().get(ColorSensor.class, "color1");
        cs2 = this.getOpMode().getHardwareMap().get(ColorSensor.class, "color2");
        cs3 = this.getOpMode().getHardwareMap().get(ColorSensor.class, "color3");


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
    public Servo getServo1() {return this.s1;}
    public Servo getServo2() {return this.s2;}
    public Servo getServo3() {return this.s3;}
    public Servo getServo4() {return this.s4;}

    /* get Opmode */
    public OpMode getOpMode() {
        return this.mode;
    }

    /* get color sensor */
    public ColorSensor getColorSensor1() { return this.cs1; }
    //public ColorSensor getColorSensor2() { return this.cs2; }

    /* get gyro sensor */
    public GyroSensor getGyroSensor() {
        return this.sensorGyro;
    }

    /* wait x seconds */
    public void wait(double seconds) {
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
        this.wait(0.2);
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
        this.wait(0.2);
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
        this.wait(0.2);
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
        this.getMotor1().setPower(speed);
        this.getMotor2().setPower(-speed);
        this.wait(time);
        this.getMotor1().setPower(0);
        this.getMotor2().setPower(0);
        this.wait(0.2);
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
        this.getMotor1().setPower(-speed);
        this.getMotor2().setPower(speed);
        this.wait(time);
        this.getMotor1().setPower(0);
        this.getMotor2().setPower(0);
        this.wait(0.2);
    }


    /*
    Realignment Forward Function
    Arguments:
        Color: Of side

    Task:
        Correct to fit lines based n color
    */
    public void RealignmentForward (String color){


        boolean checkcolorBlue2 = false;
        boolean checkcolorBlue3 = false;
        boolean checkcolorRed2 = false;
        boolean checkcolorRed3 = false;

        //Blue check
        if(cs2.blue()> cs2.red() || cs2.blue()> cs2.green() )
        {
            if(cs2.blue() > 130){
                checkcolorBlue2 = true;
            }
        }

        if(cs3.blue()> cs3.red() || cs3.blue()> cs3.green() )
        {
            if(cs3.blue() > 130){
                checkcolorBlue2 = true;
            }
        }


        //Red Check
        if(cs2.red()> cs2.blue() || cs2.red()> cs2.green() )
        {
            if(cs2.red() > 130){
                checkcolorRed2 = true;
            }
        }

        if(cs3.red()> cs3.blue() || cs3.red()> cs3.green() )
        {
            if(cs3.blue() > 130){
                checkcolorRed2 = true;
            }
        }

        //Condition
        switch(color){
            case "red":
                while(checkcolorRed2){
                    this.getMotor1().setPower(-0.5);
                }
                while(checkcolorRed3){
                    this.getMotor2().setPower(0.5);
                }
                break;
            case "blue":
                while(checkcolorBlue2){
                    this.getMotor1().setPower(-0.5);
                }
                while(checkcolorBlue3){
                    this.getMotor2().setPower(0.5);
                }
                break;
            case"green":
                this.getOpMode().telemetry.addData("Well:", "You Suck");
                break;

        }


    }

}