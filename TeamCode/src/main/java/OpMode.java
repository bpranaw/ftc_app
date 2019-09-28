import android.provider.SyncStateContract;


import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ThreadPool;

import org.firstinspires.ftc.robotcore.internal.opmode.OpModeManagerImpl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
/*
Imported FIRST OP Mode
 */
@Disabled
public abstract class OpMode extends com.qualcomm.robotcore.eventloop.opmode.OpMode {
    public static String TAG = "OpMode";
    protected HardwareMap map = null;
    private Robot robot = null;
    private ElapsedTime timer = new ElapsedTime();
    private volatile boolean   isStarted       = false;
    private volatile boolean   stopRequested   = false;
    private ExecutorService executorService = null;

    public OpMode() {

    }

    public void startTimer() {
        timer.reset();
    }

    public double getTimer() {
        return timer.seconds();
    }


    public void wait(double seconds) {
        this.startTimer();

        while(this.getTimer() < seconds);
    }

    public abstract void run() throws InterruptedException;

    public abstract void repeat();

    public final boolean isStopRequested() {
        return this.stopRequested || Thread.currentThread().isInterrupted();
    }

    public final boolean isStarted() {
        return this.isStarted || Thread.currentThread().isInterrupted();
    }

    public final boolean opModeIsActive() {
        boolean isActive = !this.isStopRequested() && this.isStarted();
        if (isActive) {
            idle();
        }
        return isActive;
    }


    public synchronized void waitForStart(){
        while(!isStarted()){
            synchronized (this){
                try{this.wait();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                return;
                }
            }
        }


    }
    public final void idle() {

        Thread.yield();
    }

    @Override
    public void init() {
        this.map = hardwareMap;

        if(this.getHardwareMap() != null)
            this.robot = new Robot(this);


    }

    @Override
    public void loop() {
        this.repeat(); // DO NOT block!
    }

    @Override
    public void stop() {
        // make isStopRequested() return true (and opModeIsActive() return false)
        this.getRobot().reset();
        stopRequested = true;


        if (executorService != null) {  // paranoia

            // interrupt the linear opMode and shutdown it's service thread
            executorService.shutdownNow();

            /** Wait, forever, for the OpMode to stop. If this takes too long, then
             * {@link OpModeManagerImpl#callActiveOpModeStop()} will catch that and take action */
            try {
                String serviceName = "user linear op mode";
                ThreadPool.awaitTermination(executorService, 100, TimeUnit.DAYS, serviceName);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    }

    @Override
    public void start() {
        this.map = hardwareMap;

        if(this.getHardwareMap() != null) {
            this.robot = new Robot(this);

            this.getRobot().getMotor1().getDcMotor().setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            this.getRobot().getMotor2().getDcMotor().setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            this.getRobot().getMotor3().getDcMotor().setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            this.getRobot().getMotor4().getDcMotor().setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            this.getRobot().getMotor5().getDcMotor().setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
           // this.getRobot().getMotor5().getDcMotor().setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }

        new Thread(new Runnable() { public void run() {
            try {
                OpMode.this.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }}).start();
    }

    public HardwareMap getHardwareMap() {
        return this.map;
    }


    public Robot getRobot() {
        return this.robot;
    }


    public DcMotor getMotor(String name) {
        return this.getHardwareMap().dcMotor.get(name);
    }

    public Servo getServo(String name) {
        return this.getHardwareMap().servo.get(name);
    }

    public CRServo getCRServo(String name) {
        return this.getHardwareMap().crservo.get(name);
    }


}