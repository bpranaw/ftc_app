import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
/*
    Class: Craterside

    Access: Public

    Purpose: Execute functions to complete the Autonomous portion of the competition on the Craterside.
    Is initialized on the Driver's Station phone app

    Arguments: None

    Outputs: None
 */
@Autonomous(name = "Crater", group = "Autonomous OpMode")

public class Craterside extends OpMode
{


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
        this.getRobot().Land(1, 9);


        /*
        Marker Drop
        Notes: Moves the robot toward the depot to drop off the team marker
         */
            //Moves the robot to the edge of the landing area
                this.getRobot().Forward(0.75, 0.5);
                this.getRobot().wait(0.3);
                this.getRobot().LRot(1, 0.95);

            //Retracts the lifting mechanism to prevent damage
                this.getRobot().Land(-1.0,1);

            //Moves the robot to the wall
                this.getRobot().wait(0.2);
                this.getRobot().Forward(1, 1.25);

            //Moves robot along the wall
                this.getRobot().wait(0.2);
                this.getRobot().LRot(1, 0.55);

            //Moves robot along the wall to the depot and puts it in the right orientation
                this.getRobot().Forward(1, 1.45);
                this.getRobot().RRot(1, 0.75);
                this.getRobot().wait(0.5);

            //Dropping of the marker
                this.getRobot().getServo1().setPosition(Constants.Rest_Pos);
        /*
        Crater Parking
        Notes: Moves the robot from the depot to the crater to park
         */

        //Reorients the robot towards the crater
        this.getRobot().Backward(1,0.5);
        this.getRobot().wait(1.0);
        this.getRobot().RRot(1, 3.3);

        //Moves the robot towards the crater
        this.getRobot().wait(0.2);
        this.getRobot().Forward(1, 2);



    }

    @Override
    public void repeat(){}

    @Override
    public void stop(){}
}
