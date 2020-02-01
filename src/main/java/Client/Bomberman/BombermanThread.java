package client.Bomberman;

public class BombermanThread extends Thread {

    private long MIN_FRAME_DURATION = 10000000 / 60;

    private BombermanPanel panel;
    private long passedFrameTime, lastFrameTime, delta;
    private int framesPerSecond;

    public BombermanThread(BombermanPanel panel) {
        this.panel = panel;
    }

    @Override
    public synchronized void run() {
        while(true) {
            try {
                lastFrameTime  = System.nanoTime();
                panel.repaint();
                this.wait();

                delta = System.nanoTime() - lastFrameTime;
                framesPerSecond++;
                passedFrameTime += delta;

                if(passedFrameTime > 1000000000) {
                    System.out.println(framesPerSecond);
                    framesPerSecond = 0;
                    passedFrameTime = 0;
                }
                if(delta < MIN_FRAME_DURATION) {
                    long sleep = MIN_FRAME_DURATION - delta;
                    long millis = sleep / 1000000;
                    int nanos = (int) (sleep - millis * 1000000);
                    Thread.sleep(millis, nanos);
                    passedFrameTime += sleep;
                    delta += sleep;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void nowait() {
        synchronized(this) {
            this.notify();
        }
    }
}
