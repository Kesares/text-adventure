package kesares.textadventure.io;

import kesares.textadventure.entity.NPC;
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

    public static byte printWorldSelectionMenu(String worldName) {
        OutputManager.printTitle(worldName);
        System.out.println(LanguageSelector.strings.worldSelectionMenu);
        OutputManager.printBoldPartingLine();
        return InputManager.enterByte("> ");
    }

    public static byte printWorldMenu(String name) {
        OutputManager.printTitle(name);
        System.out.println(LanguageSelector.strings.worldMenu);
        OutputManager.printBoldPartingLine();
        return InputManager.enterByte("> ");
    }

    public static boolean printYesNoMenu(String text) {
        OutputManager.printTitle(text);
        System.out.println(LanguageSelector.strings.yesNo);
        OutputManager.printBoldPartingLine();
        return InputManager.enterBoolean("> ");
    }

    public static byte printBattleMenu(Player player, NPC NPC, int rounds) {
        OutputManager.printTitle("Battle – Runde " + rounds);
        System.out.printf("%s (%d)%nHP: %d/%d%n", player.getName(), player.getLevel(), player.getHP(), player.getMaxHP());
        OutputManager.printPartingLine(OutputManager.MINUS_SIGN);
        System.out.printf("%s (%d)%nHP: %d/%d%n", NPC.getName(), NPC.getLevel(), NPC.getHP(), NPC.getMaxHP());
        OutputManager.printPartingLine(OutputManager.MINUS_SIGN);
        System.out.println(LanguageSelector.strings.battleMenu);
        OutputManager.printBoldPartingLine();
        return InputManager.enterByte("> ");
    }
}