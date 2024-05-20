package kesares.textadventure.core;

import kesares.textadventure.io.InputManager;
import kesares.textadventure.io.MenuPrinter;
import kesares.textadventure.io.OutputManager;
import kesares.textadventure.util.AnsiColor;
import kesares.textadventure.util.lang.LanguageSelector;
import kesares.textadventure.util.lang.Strings;

public class Game {

    private boolean isRunning;

    public Game() {
        this.isRunning = true;
    }

    public void update() {
        InputManager.enterToContinue();
        OutputManager.clearConsole();
        byte option = MenuPrinter.printMainMenu();
        switch (option) {
            case 1 -> this.playNewWorld();
            case 2 -> this.playLoadedWorld();
            case 3 -> Settings.changeSettings();
            case 4 -> this.exit();
            default -> OutputManager.printOptionDoesntExist(option);
        }
    }

    public void playNewWorld() {
        OutputManager.clearConsole();
        OutputManager.printTitle(LanguageSelector.strings.createNewWorld);
        String worldName = InputManager.enterString(LanguageSelector.strings.enterWorldName);
        World world = new World(worldName);
        world.load();
    }

    private void playLoadedWorld() {
        OutputManager.printColorText(Strings.COMING_SOON, AnsiColor.RED);
    }

    private void exit() {
        OutputManager.clearConsole();
        OutputManager.printBoldPartingLine();
        InputManager.close();
        this.isRunning = false;
    }

    public boolean isRunning() {
        return isRunning;
    }
}