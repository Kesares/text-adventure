package kesares.textadventure.core;
import kesares.textadventure.io.*;
import kesares.textadventure.io.table.TablePrinter;
import kesares.textadventure.io.table.WorldTablePrinter;
import kesares.textadventure.util.AnsiColor;
import kesares.textadventure.util.ResourceLibrary;
import kesares.textadventure.util.lang.LanguageSelector;

import java.util.List;

public class Game {

    private final Loop loop;
    private final List<World> worlds;
    private final TablePrinter worldsTablePrinter;
    private World world;

    public Game() {
        ResourceLibrary.init();
        this.loop = new Loop(this::update);
        this.worlds = WorldIO.loadWorlds();
        this.worldsTablePrinter = new WorldTablePrinter("Welten", this.worlds, LanguageSelector.strings.numero, LanguageSelector.strings.worlds);
    }

    public void start() {
        this.loop.start();
    }

    private void update() {
        OutputManager.printBoldPartingLine();
        InputManager.enterToContinue();
        OutputManager.clearConsole();
        byte option = MenuPrinter.printMainMenu();
        switch (option) {
            case 1 -> this.playNewWorld();
            case 2 -> this.showWorlds();
            case 3 -> GameSettings.changeSettings();
            case 4 -> this.exit();
            default -> OutputManager.printOptionDoesntExist(option);
        }
    }

    private void playNewWorld() {
        OutputManager.clearConsole();
        OutputManager.printTitle(LanguageSelector.strings.createNewWorld);
        String worldName = InputManager.enterString(LanguageSelector.strings.enterWorldName);
        this.world = new World(worldName);
        this.worlds.add(this.world);
        this.worldsTablePrinter.update();
        this.world.update();
    }

    private void showWorlds() {
        OutputManager.clearConsole();
        this.worldsTablePrinter.update();
        this.worldsTablePrinter.print();
        int index = InputManager.enterByte("> ") - 1;
        OutputManager.clearConsole();
        if (index == this.worlds.size()) return;
        this.selectWorldOption(index);
    }

    private void selectWorldOption(int index) {
        OutputManager.clearConsole();
        this.world = this.worlds.get(index);
        byte option = MenuPrinter.printWorldSelectionMenu(this.world.getName());
        switch (option) {
            case 1 -> {
                OutputManager.printBoldPartingLine();
                this.world.update();
            }
            case 2 -> this.world.changeWorldName();
            case 3 -> this.deleteWorld();
            default -> OutputManager.printOptionDoesntExist(option);
        }
    }

    private void deleteWorld() {
        this.worlds.remove(this.world);
        this.worldsTablePrinter.update();
        OutputManager.printBoldPartingLine();
        OutputManager.printCenteredColorText(this.world.getName() + LanguageSelector.strings.deleted, AnsiColor.YELLOW, OutputManager.LINE_LENGTH);
    }

    private void exit() {
        OutputManager.clearConsole();
        OutputManager.printBoldPartingLine();
        WorldIO.saveWorlds(this.worlds);
        InputManager.close();
        OutputManager.printBoldPartingLine();
        this.loop.stop();
    }
}