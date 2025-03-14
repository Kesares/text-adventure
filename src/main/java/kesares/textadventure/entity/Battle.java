package kesares.textadventure.entity;

import kesares.textadventure.io.InputManager;
import kesares.textadventure.io.MenuPrinter;
import kesares.textadventure.io.OutputManager;
import kesares.textadventure.item.*;
import kesares.textadventure.util.lang.LanguageSelector;

public class Battle {

    private final Player player;
    private final NPC npc;
    private int rounds;

    public Battle(Player player, NPC npc) {
        this.player = player;
        this.npc = npc;
        this.rounds = 0;
    }

    public void begin() {
        String title = String.format(LanguageSelector.strings.beingAttacked, this.npc.getName(), this.npc.getLevel());
        OutputManager.printTitle(title, title.length());
        InputManager.enterToContinue();
        this.update();
    }

    private void update() {
        do {
            OutputManager.clearConsole();
            final byte option = MenuPrinter.printBattleMenu(this.player, this.npc, ++this.rounds);
            switch (option) {
                case 1 -> this.attack();
                case 2 -> {
                    System.out.println(LanguageSelector.strings.flee);
                    this.player.setHp(this.player.getMaxHP());
                    OutputManager.printBoldPartingLine();
                    return;
                }
                default -> OutputManager.printOptionDoesntExist(option);
            }
        } while(this.areBothEntitiesAlive());
        this.end();
    }

    private void attack() {
        Cannon[] npcCannons = this.npc.getShip().getCannons();
        Cannon[] playerCannons = this.player.getShip().getCannons();

        int takeDamage = this.getSumDamage(npcCannons);
        int makeDamage = this.getSumDamage(playerCannons);

        ItemStack[] itemStacks = this.player.getInventory().getItemStacks();
        makeDamage += this.getSumCannonballsDamage(itemStacks, playerCannons.length);
        takeDamage += playerCannons.length * ((Cannonball) Items.STONE_BALL).getDamage();

        this.player.removeHP(takeDamage);
        this.npc.removeHP(makeDamage);
        this.printAttackInfo(takeDamage, makeDamage);
    }

    private void printAttackInfo(int takeDamage, int makeDamage) {
        OutputManager.clearConsole();
        OutputManager.printBoldPartingLine();
        System.out.printf(LanguageSelector.strings.makeDamage, this.npc.getName(), makeDamage);
        System.out.printf(LanguageSelector.strings.takeDamage, this.npc.getName(), takeDamage);
        OutputManager.printBoldPartingLine();
        InputManager.enterToContinue();
    }

    private boolean areBothEntitiesAlive() {
        return this.player.isAlive() && this.npc.isAlive();
    }

    private void end() {
        OutputManager.clearConsole();
        if (this.player.isAlive()) {
            this.playerWins();
            return;
        }
        OutputManager.printTitle(LanguageSelector.strings.lostBattle);
//          invaderWins(), lostXp(), lostGold()
        this.player.setHp(this.player.getMaxHP());
    }

    private void playerWins() {
        OutputManager.printTitle(String.format(LanguageSelector.strings.defeatedEntity, this.npc.getName(), this.npc.getLevel()));
        this.player.addExp(this.npc.getExp());
        this.player.addGold(this.npc.getGold());
        System.out.printf(LanguageSelector.strings.gotExp + "%n", this.npc.getExp());
        System.out.printf(LanguageSelector.strings.gotGold + "%n", this.npc.getGold());
        OutputManager.printBoldPartingLine();
    }

    private int getSumDamage(Cannon[] cannons) {
        int sum = 0;
        for (Cannon cannon : cannons) {
            if (Math.random() < cannon.getScattering()) {
                sum += cannon.getDamage();
            }
        }
        return sum;
    }

    private int getSumCannonballsDamage(ItemStack[] itemStacks, int amountOfCannons) {
        for (ItemStack itemStack : itemStacks) {
            if (itemStack.getItem() instanceof Cannonball cannonball) {
                itemStack.pop(amountOfCannons);
                return cannonball.getDamage() * amountOfCannons;
            }
        }
        return 0;
    }
}