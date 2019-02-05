import android.graphics.Path;

import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class CRServo {
   private com.qualcomm.robotcore.hardware.CRServo crservo = null;
    Robot robot;

    double power;

  public CRServo(Robot robot, com.qualcomm.robotcore.hardware.CRServo crservo){
    this.robot = robot;
    this.crservo = crservo;
  }

  public void setPower(double power){this.getCRServo().setPower(power);}

  public void setDirection(DcMotorSimple.Direction direction){this.getCRServo().setDirection(direction);}


  //retrieve Data

  public DcMotorSimple.Direction getDirection (){return this.getCRServo().getDirection();}

  public double getPower() { return this.getCRServo().getPower();}


  public com.qualcomm.robotcore.hardware.CRServo getCRServo() {return this.crservo;}


}
