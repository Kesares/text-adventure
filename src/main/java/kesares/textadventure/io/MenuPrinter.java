package kesares.textadventure.io;

import kesares.textadventure.entity.Invader;
import kesares.textadventure.entity.Player;
import kesares.textadventure.util.lang.LanguageSelector;

public final class MenuPrinter {

    private MenuPrinter() {
        throw new UnsupportedOperationException();
    }

    public static byte printMainMenu() {
        OutputManager.printTitle("Text Adventure");
        System.out.println(LanguageSelector.strings.mainMenu);
        OutputManager.printBoldPartingLine();
        return InputManager.enterByte("> ");
    }

    public static byte printSettingsMenu() {
        OutputManager.printTitle(LanguageSelector.strings.settingsMenuTitle);
        System.out.println(LanguageSelector.strings.settingsMenu);
        OutputManager.printBoldPartingLine();
        return InputManager.enterByte("> ");
    }

    public static byte printLanguageSelectionMenu() {
        OutputManager.printTitle(LanguageSelector.strings.languageSelectionMenuTitle);
        System.out.println(LanguageSelector.strings.languageSelectionMenu);
        OutputManager.printBoldPartingLine();
        return InputManager.enterByte("> ");
    }

    public static byte printStoryMenu() {
        OutputManager.printTitle("Story");
        System.out.println(LanguageSelector.strings.worldMenu);
        OutputManager.printBoldPartingLine();
        return InputManager.enterByte("> ");
    }

    public static byte printBattleMenu(Player player, Invader invader) {
        OutputManager.printTitle("Battle");
        System.out.printf("%s (%d)\r\nHP: %d/%d\r\n", player.getName(), player.getLevel(), player.getHP(), player.getMaxHP());
        OutputManager.printPartingLine(OutputManager.MINUS_SIGN);
        System.out.printf("%s (%d)\r\nHP: %d/%d\r\n", invader.getName(), invader.getLevel(), invader.getHP(), invader.getMaxHP());
        OutputManager.printPartingLine(OutputManager.MINUS_SIGN);
//        System.out.println(Strings.battleMenu);
        OutputManager.printBoldPartingLine();
        return InputManager.enterByte("> ");
    }
}