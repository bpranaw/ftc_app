import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import static com.sun.tools.doclint.Entity.lt;
/*
    Class: MainTeleOpMode

    Access: Public

    Purpose: To allow for the drivers to control the
    robot during the player control portion

    Arguments: None

    Outputs: None
 */

@TeleOp(name = "TeleOp", group = "Tele OpMode")
public class MainTeleOpMode extends TeleOpMode {


    @Override
    public void run()
    {
        /*
        Notes: This only runs on initialization. It's purpose is to clean up
        the portions of the autonomous phase that couldn't be dealt with until
        afterwards
        */
        this.getRobot().getServo1().setPosition(Constants.Rest_Pos);
        this.getRobot().getColorSensor2().enableLed(false);
        this.getRobot().getColorSensor3().enableLed(false);
    }

    @Override
    public void repeat()
    {
        /*
        Note: Declaration of all variables/ Linking the gamepads to the code
        */
            double lx = this.getGamepadA().left_stick_x;
            double ly = this.getGamepadA().left_stick_y;
            double rx = -this.getGamepadA().right_stick_x;
            double ry = this.getGamepadA().right_stick_y;
            double rt = this.getGamepadA().right_trigger;
            double lt = this.getGamepadA().left_trigger;
            double ly2 = this.getGamepadB().left_stick_y;
            double ry2 = this.getGamepadB().right_stick_y;

            boolean rb = this.getGamepadA().right_bumper;
            boolean lb = this.getGamepadA().left_bumper;
            boolean lb2 = this.getGamepadB().left_bumper;
            boolean rb2 = this.getGamepadB().right_bumper;

            boolean open = this.getGamepadA().y;
            boolean close = this.getGamepadA().x;
            double pos = this.getRobot().getServo1().getPosition();

            double gate_pos = this.getRobot().getServo2().getPosition();
            double gate_open = this.getGamepadB().left_trigger;
            double gate_close = this.getGamepadB().right_trigger;

        /*
        Gamepad: Gamepad A
        Function: Drivebase Control
            Individual Functions:
                Claw
                Drivetrain

        */

            //Claw
            if(open)
            {
                this.getRobot().getServo1().setPosition(Constants.Close_Pos);
            }
            else if(close) {
                this.getRobot().getServo1().setPosition(Constants.Rest_Pos);
            }
            else {
                this.getRobot().getServo1().setPosition(pos);
            }


            //Drive Base movement
            if(Math.abs(ry) >= Constants.TRIGGER_THRESHOLD || Math.abs(ly) >= Constants.TRIGGER_THRESHOLD) {
                this.getRobot().getMotor1().setPower(-ry);
                this.getRobot().getMotor2().setPower(ly);
                }
                else if (Math.abs(ry) <= Constants.TRIGGER_THRESHOLD || Math.abs(ly) <= Constants.TRIGGER_THRESHOLD)
                    {
                        this.getRobot().getMotor1().setPower(-ry);
                        this.getRobot().getMotor2().setPower(ly);

            }
            else{
                this.getRobot().getMotor1().reset();
                this.getRobot().getMotor2().reset();
            }

            //Lift
            if(open){
                    this.getRobot().getMotor3().setPower(1);
                }
                else if(close){
                    this.getRobot().getMotor3().setPower(-1);
                }
                else
                {
                    this.getRobot().getMotor3().reset();
                }




        /*
        Gamepad: Gamepad B
        Function: Mineral Recovery
        Individual Functions:
            Extended Boy
            Bucket to Heaven
        */

            //Bucket to Heaven
            if(lb2){
                this.getRobot().getCRservo1().setDirection(DcMotorSimple.Direction.FORWARD);
                this.getRobot().getCRservo1().setPower(1);
            }
            else if(rb2){
                this.getRobot().getCRservo1().setPower(-1);
            }
            else {
                this.getRobot().getCRservo1().setPower(0);
            }

            //Stairway to Heaven
            if(ly2 > Constants.TRIGGER_THRESHOLD ){
                this.getRobot().getMotor4().setPower(ly2);
            }
            else if(ly2 < -Constants.TRIGGER_THRESHOLD){
                this.getRobot().getMotor4().setPower(ly2);
            }
            else {
                this.getRobot().getMotor4().setPower(0);
            }

            //Ladder to Heaven
            if(ry2 > Constants.TRIGGER_THRESHOLD ){
                this.getRobot().getMotor5().setPower(ry2);
            }
            else if(ry2 < -Constants.TRIGGER_THRESHOLD){
                this.getRobot().getMotor5().setPower(ry2);
            }
            else {
                this.getRobot().getMotor5().setPower(0);
            }

            //Gate

            if(gate_open > Constants.TRIGGER_THRESHOLD || gate_close < Constants.TRIGGER_THRESHOLD)
            {
                this.getRobot().getCRServo2().setPower(gate_open);
            }
            else if (gate_close > Constants.TRIGGER_THRESHOLD){
                this.getRobot().getCRServo2().setPower(-gate_close);
            }
            else
            {
                this.getRobot().getCRServo2().setPower(0);
            }

    }

}
