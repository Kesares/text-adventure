package kesares.textadventure.core;

import kesares.textadventure.io.InputManager;
import kesares.textadventure.io.MenuPrinter;
import kesares.textadventure.io.OutputManager;

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
        byte input;

        while (this.isRunning) {
            InputManager.enterToContinue();
            OutputManager.clearConsole();
            MenuPrinter.printMainMenu();
            input = InputManager.enterByte("> ");
            this.game.update(input);
            if (!this.game.isRunning()) this.stop();
        }
    }

    private void stop() {
        if (!this.isRunning) return;
        this.isRunning = false;
    }
}