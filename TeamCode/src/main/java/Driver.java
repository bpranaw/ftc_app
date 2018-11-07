import com.qualcomm.robotcore.util.ElapsedTime;

public class Driver {
    private Robot robot = null;

    public static final int STRAIGHT = 0;
    public static final int ROTATE = -1;
    public static final int NINETY = 1;

    public Driver(Robot robot) {
        this.robot = robot;

        this.getRobot().getMotor1().invert(true);
        this.getRobot().getMotor2().invert(true);

    }

    private final double[] straight /*0*/ = {1, 0.2, 0.7, 0.3}, ff /*1*/ = {0.6, 0.6, 0.3, 0.6}, ninety /*-1*/ = {0.3, 0.9, 0, 1};
    private double dir = 0;
    private double rotate = 0;
    private double speed = 1;


    public Driver() {
    }

    public void setDirection(double direction) {
        this.dir = direction;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setRotation(double rotate) {
        this.rotate = rotate;
    }


    public Driver drive() {
        double angle = dir;

                //angle = Math.IEEEremainder(angle, Math.PI * 2);

        Motor motor1 = this.getRobot().getMotor1();
        Motor motor2 = this.getRobot().getMotor2();
        Motor motor3 = this.getRobot().getMotor3();
        Motor motor4 = this.getRobot().getMotor4();

        Motor motor5 = this.getRobot().getMotor5();


    motor1.getDcMotor().setPower(speed * Math.sin(angle - (Math.PI / 4)));
    motor2.getDcMotor().setPower(speed * -Math.cos(angle - (Math.PI / 4)));
    motor3.getDcMotor().setPower(speed * Math.cos(angle + (Math.PI / 4)));
    motor4.getDcMotor().setPower(speed * Math.sin(angle + (Math.PI / 4)));

        return this;
    }

    public void stop() {
        this.getRobot().getMotor1().setPower(0);
        this.getRobot().getMotor2().setPower(0);
        this.getRobot().getMotor3().setPower(0);
        this.getRobot().getMotor4().setPower(0);
        this.getRobot().getMotor5().setPower(0);
    }

    public void check() {/*
        if(this.getRobot().getServo1() != null && Double.isNaN(this.getRobot().getServo1().getPosition()))
            this.getRobot().getServo1().setPosition(straight[0]);
        if(this.getRobot().getServo2() != null && Double.isNaN(this.getRobot().getServo2().getPosition()))
            this.getRobot().getServo2().setPosition(straight[1]);
        if(this.getRobot().getServo3() != null && Double.isNaN(this.getRobot().getServo3().getPosition()))
            this.getRobot().getServo3().setPosition(straight[2]);
        if(this.getRobot().getServo4() != null && Double.isNaN(this.getRobot().getServo4().getPosition()))
            this.getRobot().getServo4().setPosition(straight[3]);*/
    }

    public static boolean isZero(double x) {
        return x < Constants.TRIGGER_THRESHOLD && x > -Constants.TRIGGER_THRESHOLD;
    }

    public static boolean isZero(double x, double threshold) {
        return x < threshold && x > -threshold;
    }

    public static final double CONSTANT = (4 * Math.PI);

    public static double getAngle(double x, double y) {
        if(isZero(x) && isZero(y))
            return 0;
        return Math.toDegrees(1.5 * Math.PI - Math.atan2(y, x)) - 180; // supposed to be y,x
    }
/*
    public void rotate(double degrees) {
        ElapsedTime timer = new ElapsedTime();
        while(timer.seconds() < 5 && this.getRobot().getGyroSensor().isCalibrating()); // max 5 secs for calibration.

        this.getRobot().reset();

        int olddir = -10;
        // check if turned or not
        if(this.dir != ROTATE) {
            olddir = this.dir;
            timer.reset();
            this.point(ROTATE);
            while(timer.seconds() < 1.5); // delay to wait for wheels to turn
        }

        // generate data
        double heading = this.getRobot().getGyroSensor().getHeading();
        double target = heading + degrees;
        target = (double)((double)((double) (target % 360) + 360) + 360); // I don't even know...

        if(degrees > 0) {
            // rotate clockwise
            this.drive(1);
        } else {
            // rotate counterclockwise
            this.drive(-1);
        }

        int distance = Math.abs((int)(target - heading)); // calculate distance from target

        timer.reset();
        while(timer.seconds() < 10 && distance < 5) { // 5 is the threshold of angles
            distance = Math.abs((int)(target - this.getRobot().getGyroSensor().getHeading())); // check if done rotating or not
        }

        // reset everything
        this.getRobot().reset();
        if(olddir != -10)
            this.point(olddir);
    }
*/
    /* open: true = open, false = closed */
    /*public void setServo(String servo, boolean open) {

        double pos = 0.5;
        switch(servo.trim().toLowerCase()) {
            case "arm1":
                if(open)
                    pos = opened[0];
                else
                    pos = closed[0];
                this.getRobot().getServoArm1().setPosition(pos);

                break;
            case "arm2":
                if(open)
                    pos = opened[1];
                else
                    pos = closed[1];
                this.getRobot().getServoArm2().setPosition(pos);

                break;
            case "arme":
                if(open)
                    pos = opened[2];
                else
                    pos = closed[2];
                this.getRobot().getServoArmE().setPosition(pos);

                break;
            default:
                System.err.println("lol that servo no exists!!!");
        }
    }*/

    public boolean isColor(double r, double g, double b, String name) {
        name = name.toLowerCase(); // get the lower case version of the name

        switch(name) {
            case "red":
                if(r >= 0.5)
                    return true; // it is red
                break;
            case "green":
                if(g >= 0.5)
                    return true; // it is green
                break;
            case "blue":
                if(b >= 0.5)
                    return true; // it is blue
                break;
            case "white":
                if(r > 0.5 && g > 0.5 && b > 0.5)
                    return true;
                break;
            case "black":
                if(r < 0.5 && g < 0.5 && b < 0.5)
                    return true;
                break;
            default:
                // status("Unknown color (" + r + ", " + g + ", " + b + ")."); // unknown color; will get annoying if it is spamming console.
                return false;
        }

        return false; // unknown color
    }

    public Robot getRobot() {
        return this.robot;
    }
}