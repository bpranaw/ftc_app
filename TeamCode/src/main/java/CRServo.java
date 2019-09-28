import com.qualcomm.robotcore.hardware.DcMotorSimple;
/*
    Class: CRServo

    Access: Public

    Purpose: Allow any CRServo instances to perform the functions of the servo in a
    cleaner/easier to read way than the original crservo class.

    Arguments: crservo (imported FIRST Code)

    Functions: setPower
               setDirection
               getDirection

    Output: none
 */

public class CRServo
{
   //Createsan instance of the FIRST CRservo
   private com.qualcomm.robotcore.hardware.CRServo crservo;

   //Creates an instance of the Robot Class
       Robot robot;

        //Constructor to link the FIRST CRservo to our CRServo Class and our Robot Class
           public CRServo(Robot robot, com.qualcomm.robotcore.hardware.CRServo crservo)
           {
            this.robot = robot;
            this.crservo = crservo;
           }


  //Servo control Methods

      /*
      Function: setPower

      Purpose: To send a number value inbetween -1 and 1 to send to the CRServo
      that it'll use as a power value

      Arguments: power (double)
       */
            public void setPower(double power){this.getCRServo().setPower(power);}

      /*
      Function: setDirection

      Purpose: To set the direction of rotation forward or backward

       Arguments: Direction Class imported from DCMotor (FORWARD or REVERSE)
       */
            public void setDirection(DcMotorSimple.Direction direction){this.getCRServo().setDirection(direction);}


   //Data Retrieval methods

       /*
       Function: getDirection

       Purpose: Retrieves information on whether Servo is forward or reverse

       Arguments: None

       Outputs: Direction (Imported Class)
       */
            public DcMotorSimple.Direction getDirection (){return this.getCRServo().getDirection();}

        /*
        Function: getPower

        Purpose: Retrieves information on what the power is currently set at.

        Arguments: None

        Outputs: Power(Double
        */
            public double getPower() { return this.getCRServo().getPower();}

        /*
        Function: getCRServo

        Purpose: Allows other classes to access the functions within a created instance of a CRservo class

        Arguments: None

        Outputs: the specific instance of the crservo
        */
            public com.qualcomm.robotcore.hardware.CRServo getCRServo() {return this.crservo;}


}
