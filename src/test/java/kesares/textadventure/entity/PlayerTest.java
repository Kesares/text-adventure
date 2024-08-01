package kesares.textadventure.entity;

import kesares.textadventure.item.Items;
import kesares.textadventure.util.ResourceLibrary;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {

    private static final int[] REQUIRED_XP_FOR_LEVEL_UP = {2_550, 4_000, 5_000, 6_250, 7_750, 9_500, 11_500, 13_750,
            16_250, 19_000, 22_000, 25_250, 28_750, 32_500, 36_500, 40_750, 45_250, 50_000, 60_000};

    @Test
    void addExp() {
        ResourceLibrary.init();
        Player player = new Player("Player", new Inventory("Test Inventory", Items.ITEMS.size()));
        assertEquals(0, player.getExp());
        player.addExp(REQUIRED_XP_FOR_LEVEL_UP[0] - 1);
        assertEquals(REQUIRED_XP_FOR_LEVEL_UP[0] - 1, player.getExp());
        assertEquals(1, player.getLevel());
        player.addExp(1);
        assertEquals(REQUIRED_XP_FOR_LEVEL_UP[0], player.getExp());
        assertEquals(2, player.getLevel());
        player.addExp(2_450);
        assertEquals(REQUIRED_XP_FOR_LEVEL_UP[2], player.getExp());
        assertEquals(4, player.getLevel());
    }
}