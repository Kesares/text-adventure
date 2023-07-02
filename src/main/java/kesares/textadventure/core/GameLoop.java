package kesares.textadventure.core;

public class GameLoop {

    private final Game game;
    private boolean isRunning;

    public GameLoop(Game game) {
        this.game = game;
        this.isRunning = false;
    }

    public void start() {
        if (this.isRunning) return;
        this.isRunning = true;
        this.run();
    }

    private void run() {
        while (this.isRunning) {
            this.game.update();
            if (!this.game.isRunning()) this.stop();
        }
    }

    private void stop() {
        if (!this.isRunning) return;
        this.isRunning = false;
    }
}