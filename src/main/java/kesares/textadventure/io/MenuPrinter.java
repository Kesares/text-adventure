package kesares.textadventure.io;

import kesares.textadventure.entity.Invader;
import kesares.textadventure.entity.Player;
import kesares.textadventure.util.lang.Strings;

public final class MenuPrinter {

    private MenuPrinter() {
        throw new UnsupportedOperationException();
    }

    public static void printMainMenu() {
        OutputManager.printTitle("Text Adventure");
        System.out.println(Strings.mainMenu);
        OutputManager.printBoldPartingLine();
    }

    public static void printSettingsMenu() {
        OutputManager.printTitle(Strings.settingsMenuTitle);
        System.out.println(Strings.settingsMenu);
        OutputManager.printBoldPartingLine();
    }

    public static void printLanguageSelectionMenu() {
        OutputManager.printTitle(Strings.langSelectionMenuTitle);
        System.out.println(Strings.langSelectionMenu);
        OutputManager.printBoldPartingLine();
    }

    public static void printStoryMenu() {
        OutputManager.printTitle("Story");
        System.out.println(Strings.storyMenu);
        OutputManager.printBoldPartingLine();
    }

    public static void printBattleMenu(Player player, Invader invader) {
        OutputManager.printTitle("Battle");
        System.out.printf("%s (%d)\r\nHP: %d/%d\r\n", player.getName(), player.getLevel(), player.getHP(), player.getMaxHP());
        OutputManager.printThinPartingLine();
        System.out.printf("%s (%d)\r\nHP: %d/%d\r\n", invader.getName(), invader.getLevel(), invader.getHP(), invader.getMaxHP());
        OutputManager.printThinPartingLine();
        System.out.println(Strings.battleMenu);
        OutputManager.printBoldPartingLine();
    }
}