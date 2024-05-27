package kesares.textadventure.core;

import kesares.textadventure.io.*;
import kesares.textadventure.util.lang.LanguageSelector;

import java.util.List;

public class Game {

    private final ConsoleTable worldsTable;
    private final List<World> worlds;
    private World world;
    private boolean isRunning;

    public Game() {
        this.worldsTable = new ConsoleTable(LanguageSelector.strings.numero, LanguageSelector.strings.worlds);
        this.worlds = WorldIO.loadWorlds(this.worldsTable);
        this.isRunning = true;
    }

    public void update() {
        OutputManager.printBoldPartingLine();
        InputManager.enterToContinue();
        OutputManager.clearConsole();
        byte option = MenuPrinter.printMainMenu();
        switch (option) {
            case 1 -> this.playNewWorld();
            case 2 -> this.selectWorld();
            case 3 -> Settings.changeSettings();
            case 4 -> this.exit();
            default -> OutputManager.printOptionDoesntExist(option);
        }
    }

    public void playNewWorld() {
        OutputManager.clearConsole();
        OutputManager.printTitle(LanguageSelector.strings.createNewWorld);
        String worldName = InputManager.enterString(LanguageSelector.strings.enterWorldName);
        this.world = new World(worldName);
        this.worlds.add(this.world);
        this.worldsTable.addRow(this.worlds.size() + ".", this.world.getName());
        this.world.load();
    }

    private void selectWorld() {
        OutputManager.clearConsole();
        this.worldsTable.setHeaders(LanguageSelector.strings.numero, LanguageSelector.strings.worlds);
        this.worldsTable.print();
        int index = InputManager.enterByte("> ") - 1;
        OutputManager.clearConsole();
        if (index == this.worlds.size()) return;
        this.playSelectedWorld(index);
    }

    private void playSelectedWorld(int index) {
        OutputManager.clearConsole();
        OutputManager.printBoldPartingLine();
        this.world = this.worlds.get(index);
        this.world.load();
    }

    private void exit() {
        OutputManager.clearConsole();
        OutputManager.printBoldPartingLine();
        WorldIO.saveWorlds(this.worlds);
        InputManager.close();
        OutputManager.printBoldPartingLine();
        this.isRunning = false;
    }

    public boolean isRunning() {
        return isRunning;
    }
}