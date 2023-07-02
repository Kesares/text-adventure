package kesares.textadventure.io;

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
}