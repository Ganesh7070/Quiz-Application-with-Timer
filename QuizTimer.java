package quiz;

import java.util.Timer;
import java.util.TimerTask;

public class QuizTimer {
    private Timer timer;
    private boolean timeUp;

    public QuizTimer() {
        timer = new Timer();
        timeUp = false;
    }

    public void startTimer(int seconds) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timeUp = true;
            }
        }, seconds * 1000);
    }

    public boolean isTimeUp() {
        return timeUp;
    }

    public void stopTimer() {
        timer.cancel();
    }
}
