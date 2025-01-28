package kesares.textadventure.core;

public class Loop {

    private final Runnable update;
    private boolean isRunning;

    public Loop(Runnable update) {
        this.update = update;
        this.isRunning = false;
    }

    public void start() {
        if (this.isRunning) return;
        this.isRunning = true;
        this.run();
    }

    public void stop() {
        if (!this.isRunning) return;
        this.isRunning = false;
    }

    private void run() {
        while (this.isRunning) {
            this.update.run();
        }
    }
}