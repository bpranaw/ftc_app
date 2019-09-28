import com.qualcomm.robotcore.hardware.configuration.I2cSensor;
/*
    Class: Constants

    Access: Public

    Purpose: To house variables that will be used within other classes. Allows for easy value changes to be made in one place
    without changing the stucture of the code within those other classes. Also serves as the intital connection between the REV
    Hub and the code.

    Arguments: None

    Outputs: None
 */

public class Constants
{
    /*
    License Key For Vuforia

    Notes: Currently not in use but awaits future integration
    */
    public static final String LICENSE_KEY = "AdlbcgL/////AAAAGdkbbJ/FBUjTiZEHQ8wntkBBQpCOLmNv2PWfmvHsWabZ5lRtoGgchQDi9WmxChfQJPOhsKmZdkhWpAupCCzgrXgnUsg2r1Gedla37EHscGaT+fFMuYATkYfe1YBNZjzYKJWDYONYq/ntym+A7cV7Hc3SUf1XlNJ8nYzndDl9S1VvNkGBOocCqQvI7VAU5/Os+D3x/uGNlHWgCtxiDexuTYKENGXk7IUBbbh2ypujcmdzAVThoWFYZMdWNEVAamD1hZapjL5pVba7l8A27kCbGqe11UG2DylMjlQYCUS4f6j41GsSo85J6EzKQFValAzNABVV3pH5TdkqNbVjG9zi19TRHxNUWFVwoWUdI9Sl+P+q"; // shhh you didn't just read this

    /*
    Definition of Rev Hub Components

    Notes: The following lines of code establish a connection between the component names listed
    in the REV Expansion Hub ( example: motorx, servox, sensorx etc.) and the code itself (to be used to other classes)

    */

        // Definitions of Motors

            public static final String M1_MOTOR = "motor1";
            public static final String M2_MOTOR = "motor2";
            public static final String M3_MOTOR = "motor3";
            public static final String M4_MOTOR = "motor4";
            public static final String M5_Motor = "motor5";

        // Definitions of Limited Rotation Servos

            public static final String S1_Servo = "servo1";
            public static final String S2_Servo = "servo2";
            public static final String S3_Servo = "servo3";

        //Definitions of Continuous Rotation Servos (CRservo)

            public static final String CR1_CRservo = "crservo1";
            public static final String CR2_CRservo = "crservo2";



    //Threshold Values

        public static final double TRIGGER_THRESHOLD = 0.1;

    /*
    Threshold for Color Sensors in detecting Yellow
    Currently requires further testing, therefore it's not implemented in the functioning code
     */
        public static final double COLOR_THRESHHOLD = 5;


    /*
    Servo Positions
    Notes: Number values between

     */
        /*
        Positions for the Claw Servo

        Notes: Currently needs some readjustments and testing, but still functional.
         */

            public static final double Rest_Pos = 0.7;
            public static final double Close_Pos = 0.4;

        /*
        Positions for the Side Arm

        Notes: Not currently in use due to lack of time to test Autonomous routes
         */

            public static final double Down_Pos = 0.55;
            public static final double Up_Pos = 1;
            public static final double Ready_Pos = 0.8;
        /*
        Positions for the Gate on the main collection mechanism

        Notes: Not currently in use due to sensitivity issues with controllers on hand.
        Could be useful in the future with some testing, but the gate function is currently linked to thumbstick control
        */
            public static final double Gate_Open = 1;
            public static final double Gate_Close = 0;



}
