package kesares.textadventure;

import kesares.textadventure.core.Game;
import kesares.textadventure.core.GameLoop;

public class Main {

    public static void main(String[] args) {
        GameLoop gameLoop = new GameLoop(new Game());
        gameLoop.start();
    }
}