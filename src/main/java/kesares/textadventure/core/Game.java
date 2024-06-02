package kesares.textadventure.core;
import kesares.textadventure.io.*;
import kesares.textadventure.util.AnsiColor;
import kesares.textadventure.util.ResourceLibrary;
import kesares.textadventure.util.lang.LanguageSelector;

import java.util.List;

public class Game {

    private ConsoleTable worldsTable;
    private final List<World> worlds;
    private World world;
    private boolean isRunning;

    public Game() {
        ResourceLibrary.init();
        this.worlds = WorldIO.loadWorlds();
        this.createNewWorldTable();
        this.isRunning = true;
    }

    public void update() {
        OutputManager.printBoldPartingLine();
        InputManager.enterToContinue();
        OutputManager.clearConsole();
        byte option = MenuPrinter.printMainMenu();
        switch (option) {
            case 1 -> this.playNewWorld();
            case 2 -> this.showWorlds();
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
        this.world.update();
    }

    private void showWorlds() {
        OutputManager.clearConsole();
        this.worldsTable.setHeaders(LanguageSelector.strings.numero, LanguageSelector.strings.worlds);
        this.worldsTable.print(LanguageSelector.strings.savedWorldsTitle);
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
            case 2 -> {
                this.world.changeWorldName();
                this.createNewWorldTable();
            }
            case 3 -> {
                this.deleteWorld();
                this.createNewWorldTable();
            }
            default -> OutputManager.printOptionDoesntExist(option);
        }
    }

    private void deleteWorld() {
        this.worlds.remove(this.world);
        OutputManager.printBoldPartingLine();
        OutputManager.printCenteredColorText(this.world.getName() + LanguageSelector.strings.deleted, AnsiColor.YELLOW, OutputManager.LINE_LENGTH);
    }

    private void exit() {
        OutputManager.clearConsole();
        OutputManager.printBoldPartingLine();
        WorldIO.saveWorlds(this.worlds);
        InputManager.close();
        OutputManager.printBoldPartingLine();
        this.isRunning = false;
    }

    private void createNewWorldTable() {
        this.worldsTable = new ConsoleTable(LanguageSelector.strings.numero, LanguageSelector.strings.worlds);
        for (int i = 0; i < worlds.size(); i++) {
            this.worldsTable.addRow(i + 1 + ".", this.worlds.get(i).getName());
        }
    }

    public boolean isRunning() {
        return isRunning;
    }
}