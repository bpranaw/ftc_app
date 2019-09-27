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

    private CRServo crs1;
    private CRServo crs2;


    //Sensors

    private ColorSensor cs1 = null;
    private ColorSensor cs2 = null;
    private ColorSensor cs3 = null;



    private OpMode mode = null;

    /* robot constructor, initialize stuff */
    public Robot(OpMode mode) {
        this.mode = mode;

        // create motor&servo instances
        this.m1 = new Motor(this, this.getOpMode().getMotor(Constants.M1_MOTOR));
        this.m2 = new Motor(this, this.getOpMode().getMotor(Constants.M2_MOTOR));
        this.m3 = new Motor(this, this.getOpMode().getMotor(Constants.M3_MOTOR));
        this.m4 = new Motor(this, this.getOpMode().getMotor(Constants.M4_MOTOR));
        this.m5 = new Motor(this, this.getOpMode().getMotor(Constants.M5_Motor));
        this.s1 = new Servo(this, this.getOpMode().getServo(Constants.S1_Servo));
        this.s2 = new Servo(this, this.getOpMode().getServo(Constants.S2_Servo));
        this.s3 = new Servo(this, this.getOpMode().getServo(Constants.S3_Servo));
        this.crs1 = new CRServo(this,this.getOpMode().getCRServo(Constants.CR1_CRservo));
        this.crs2 = new CRServo(this,this.getOpMode().getCRServo(Constants.CR2_CRservo));

       // this.m5 = new Motor(this, this.getOpMode().getMotor(Constants.M5_MOTOR));
        // this.s1 = new Servo(this, this.getOpMode().getServo(Constants.S1_SERVO)); // uncomment to enable servo
        // this.s1.setCenter(0.5);

        // enable/disable encoders on motors
        this.getMotor1().setDriveMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.getMotor2().setDriveMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.getMotor3().setDriveMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.getMotor4().setDriveMode(DcMotor.RunMode.RUN_USING_ENCODER);


        // define sensors
        cs1 = this.getOpMode().getHardwareMap().get(ColorSensor.class, "color1");
        cs2 = this.getOpMode().getHardwareMap().get(ColorSensor.class, "color2");
        cs3 = this.getOpMode().getHardwareMap().get(ColorSensor.class, "color3");



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
        this.getMotor5().reset();
        this.getServo3().reset();
        this.getServo1().reset();
        //this.getMotor5().reset();
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
    public Motor getMotor5() { return this.m5;}
   /* public Motor getMotor5() {
        return this.m5;
    }

    /* get servos */
    public Servo getServo1() {return this.s1;}
    public Servo getServo2() {return this.s2;}
    public Servo getServo3() {return this.s3;}

    public CRServo getCRservo1(){return this.crs1;}
    public CRServo getCRServo2(){return this.crs2;}

    /* get Opmode */
    public OpMode getOpMode() {
        return this.mode;
    }

    /* get color sensor */
    public ColorSensor getColorSensor1() { return this.cs1; }
    public ColorSensor getColorSensor2() { return this.cs2; }
    public ColorSensor getColorSensor3() { return this.cs3; }


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
    public void RealignmentBlue ( double power){
        while(this.getColorSensor2().blue() < 4 || this.getColorSensor3().blue() < 4) {
            if (this.getColorSensor2().blue() < 4) {
                this.getMotor1().setPower(power / 2);
            } else if (this.getColorSensor3().blue() < 4) {
                this.getMotor2().setPower(-power / 2);
            }
            else {
                this.getMotor1().setPower(0);
                this.getMotor2().setPower(0);
            }
            this.getColorSensor2().blue();
            this.getColorSensor3().blue();
        }
        this.getMotor1().setPower(0);
        this.getMotor1().setPower(0);
        this.wait(0.2);

    }


}