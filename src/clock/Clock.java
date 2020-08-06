package clock;

import ui.panels.MainPanel;

import java.util.Timer;
import java.util.TimerTask;

public class Clock extends Timer {

    private final static int COUNTER = 1000;  // 1000 milliseconds

    private TimerTask task;
    private Timer timer;
    private int seconds = 0;
    private MainPanel panel;

    public Clock(MainPanel panels) {
        this.panel = panels;
        timer = new Timer();
        task = new LoopTask();
    }

    public int getSeconds() {
        return seconds;
    }

    public void start(){
        timer.scheduleAtFixedRate(task,COUNTER,COUNTER);
    }

    public void stop(){ timer.cancel();}

    public class LoopTask extends TimerTask{

        @Override
        public void run() {
            if (seconds>10) {
                seconds=0;
                panel.setTxtClock(0);
            }
            seconds++;
            panel.setTxtClock(seconds);
        }
    }

}
