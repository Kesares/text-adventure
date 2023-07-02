package kesares.textadventure.io;

public final class MenuPrinter {

    private MenuPrinter() {
        throw new UnsupportedOperationException();
    }

    public static void printMainMenu() {
        OutputManager.printTitle("Text Adventure");
        System.out.println("""
                1: Continue story...
                2: Character info
                3: Inventory
                4: Settings
                5: Exit""");
        OutputManager.printBoldPartingLine();
    }

    public static void printSettingsMenu() {
        OutputManager.printTitle("Settings");
        System.out.println("""
                1: Change Language
                
                2: Back""");
        OutputManager.printBoldPartingLine();
    }

    public static void printLanguageSelectionMenu() {
        OutputManager.printTitle("Select Language");
        System.out.println("""
                1: English
                2: German
                
                3: Back""");
        OutputManager.printBoldPartingLine();
    }
}