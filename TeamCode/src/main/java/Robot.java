import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.util.*;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;


public class Robot {
    private ElapsedTime timer = new ElapsedTime(); // strictly for the wait function!

    //DECLARATIONS OF HARDWARE/LINKAGE TO SOFTWARE
            //Declarations of the motor objects
                private Motor m1 = null;
                private Motor m2 = null;
                private Motor m3 = null;
                private Motor m4 = null;
                private Motor m5 = null;


            //Declarations of the servo objects
                private Servo s1;
                private Servo s2;
                private Servo s3;

            //Declarations of the crservo objects
                private CRServo crs1;
                private CRServo crs2;


            //Declarations of the colorsensor objects
                private ColorSensor cs1 = null;
                private ColorSensor cs2 = null;
                private ColorSensor cs3 = null;


            //Declaration of an Opmode Object
            private OpMode mode;

            /*
            Constructor

            Purpose: To connect the Robot Class to the Opmode class and the actual robot hardware.
            This allows any function of the robot to be controlled through the Robot Class

            Arguments: mode (Opmode)
            */
            public Robot(OpMode mode) {
                this.mode = mode;

                //Create motor & servo instances
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

                //Enable/disable encoders on motors
                this.getMotor1().setDriveMode(DcMotor.RunMode.RUN_USING_ENCODER);
                this.getMotor2().setDriveMode(DcMotor.RunMode.RUN_USING_ENCODER);
                this.getMotor3().setDriveMode(DcMotor.RunMode.RUN_USING_ENCODER);
                this.getMotor4().setDriveMode(DcMotor.RunMode.RUN_USING_ENCODER);


                //Definition of color sensors
                cs1 = this.getOpMode().getHardwareMap().get(ColorSensor.class, "color1");
                cs2 = this.getOpMode().getHardwareMap().get(ColorSensor.class, "color2");
                cs3 = this.getOpMode().getHardwareMap().get(ColorSensor.class, "color3");



            }


            //Reset all motors
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


            //Returns motor objects
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
                public Motor getMotor5() { return this.m5; }


            //Returns servo objects
                public Servo getServo1() {return this.s1;}
                public Servo getServo2() {return this.s2;}
                public Servo getServo3() {return this.s3;}

            //Returns crservo objects
            public CRServo getCRservo1(){return this.crs1;}
            public CRServo getCRServo2(){return this.crs2;}

            //Returns Opmode
                public OpMode getOpMode()
                {
                    return this.mode;
                }

            //Returns Color sensor objects
            public ColorSensor getColorSensor1() { return this.cs1; }
            public ColorSensor getColorSensor2() { return this.cs2; }
            public ColorSensor getColorSensor3() { return this.cs3; }


            //Causes the code to wait
                public void wait(double seconds) {
                    timer.reset();
                    while(timer.seconds() < seconds);
                }

    /*
    AUTONOMOUS COMMANDS

    Purpose: These allow Autonomous to be coded simply without needing
    to write where every piece of electricity needs to go
     */

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
                    public void Land( double power, double time)
                    {
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
                    public void RealignmentBlue ( double power)
                    {
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