package kesares.textadventure.entity;

import kesares.textadventure.io.InputManager;
import kesares.textadventure.io.MenuPrinter;
import kesares.textadventure.io.OutputManager;
import kesares.textadventure.util.lang.Strings;

public class Battle {

    private final Player player;
    private final Invader invader;

    public Battle(Player player, Invader invader) {
        this.player = player;
        this.invader = invader;
    }

    public void begin() {
        String title = String.format(Strings.beingAttacked, this.invader.getName(), this.invader.getLevel());
        OutputManager.printTitle(title);
        InputManager.enterToContinue();
        this.battle();
    }

    private void battle() {
        byte option;
        do {
            OutputManager.clearConsole();
            MenuPrinter.printBattleMenu(this.player, this.invader);
            option = InputManager.enterByte("> ");

            switch (option) {
                case 1 -> this.attack();
                case 2 -> System.out.println(Strings.runAway);
                default -> OutputManager.printOptionDoesntExist(option);
            }
        } while(this.areBothEntitiesAlive());
        this.end();
    }

    private void attack() {
        int makeDamage = Math.max(this.player.calculateAtk() - this.invader.calculateDef(), 0);
        int takeDamage = Math.max(this.invader.calculateAtk() - this.player.calculateDef(), 0);
        this.player.removeHP(takeDamage);
        this.invader.removeHP(makeDamage);

        OutputManager.printThinPartingLine();
        System.out.printf(Strings.makeDamage, this.invader.getName(), makeDamage);
        System.out.printf(Strings.takeDamage, this.invader.getName(), takeDamage);
        OutputManager.printThinPartingLine();
        InputManager.enterToContinue();
    }

    private boolean areBothEntitiesAlive() {
        return this.player.isAlive() && this.invader.isAlive();
    }

    private void end() {
        OutputManager.clearConsole();
        if (this.player.isAlive()) {
            this.playerWins();
        } else {
            OutputManager.printTitle(Strings.lostBattle);
            // invaderWins(), lostXp(), lostGold()
            // or end of story
        }
        this.player.setHP(this.player.getMaxHP());
    }

    private void playerWins() {
        OutputManager.printTitle(String.format(Strings.defeatedEntity, this.invader.getName(), this.invader.getLevel()));
        this.player.addExp(this.invader.getExp());
        this.player.addGold(this.invader.getGold());
        System.out.printf(Strings.gotXP, this.invader.getExp());
        System.out.printf(Strings.gotGold, this.invader.getGold());
        OutputManager.printBoldPartingLine();
        InputManager.enterToContinue();
    }
}