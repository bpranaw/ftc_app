import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/*
    Class: Depotside

    Access: Public

    Purpose: Execute functions to complete the Autonomous portion of the competition on the Depotside.
    Is initialized on the Driver's Station phone app

    Arguments: None

    Outputs: None
 */
@Autonomous(name = "DepotSideAuto", group = "Autonomous OpMode")

public class Depotside extends OpMode {

    @Override
    public void run()
    {
        /*
        Marker Secure
        Notes: Secures grip on the team marker upon initialization
         */
            this.getRobot().getServo1().setPosition(Constants.Close_Pos);

        /*
        Notes: Executes the landing function in the Robot Class to bring the robot
        from the lander to the ground and unlatches the hook.
         */
            this.getRobot().Land(1, 10);

        /*
        Notes: Moves out of the Landing area and retracts lifting mechanism to prevent damage
         */
            this.getRobot().Forward(1,1.75);
            this.getRobot().Land(-1, 1);

        /*
        Crater Parking
        Notes: Moves the robot from the depot to the crater to park
         */
            this.getRobot().RRot(1, 0.6);
            this.getRobot().getServo1().setPosition(Constants.Rest_Pos);
            this.getRobot().RRot(0.85,3);
            this.getRobot().Forward(1,1.75);




        /*
        All code past here has been commented out due needing bug fixes and intensive testing.




        //Forwards towards depot
        this.getRobot().Forward(1, 0.75);

        //Sampling
        this.getRobot().LRot(1, 0.85);
        this.wait(0.2);
        this.getRobot().Backward(1,0.3);

        this.getRobot().getServo2().setPosition(Constants.Ready_Pos);
        this.wait(0.2);
        this.getRobot().Forward(0.5,4);

        //Color Sensor
        int red = this.getRobot().getColorSensor1().red();
        boolean testred = this.getRobot().getColorSensor1().red() > red;
        boolean testvalue = (((this.getRobot().getColorSensor1().red() + this.getRobot().getColorSensor1().green())/ 2 ) - 5 )
                > (this.getRobot().getColorSensor1().blue() + 10);
        boolean testvaluered = (this.getRobot().getColorSensor1().red() + 5 ) > this.getRobot().getColorSensor1().green();
        if (testred & testvalue & testvaluered)
        {
            this.startTimer();
            while(this.getTimer() < 1.5)
            {
                this.getRobot().getServo2().setPosition(Constants.Down_Pos);
            }
                this.getRobot().getServo2().setPosition(Constants.Up_Pos);
        }
        this.getRobot().getServo2().setPosition(Constants.Up_Pos);

        //Marking
        this.wait(0.2);
        this.getRobot().RRot(1,0.5);

        this.getRobot().Forward(1,1);
        this.getRobot().Backward(0.7,0.3);
        this.wait(0.2);
        this.getRobot().LRot(1.0,1);
        this.wait(0.2);
        this.getRobot().getServo1().setPosition(Constants.Rest_Pos);
        this.wait(0.2);

        this.getRobot().LRot(1,1.5);

        //Orientate toward crater
        this.wait(0.2);
        this.getRobot().Forward(1,3);
*/


    }

    @Override
    public void repeat(){}

    @Override
    public void stop(){}
}
