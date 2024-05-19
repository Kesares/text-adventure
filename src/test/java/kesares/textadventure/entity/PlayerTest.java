package kesares.textadventure.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {

    @Test
    void addExp() {
//        Strings.levelUp = "You are now level %d.";
        Player player = new Player("Player");
        assertEquals(0, player.getExp());
        player.addExp(14);
        assertEquals(14, player.getExp());
        assertEquals(1, player.getLevel());
        player.addExp(1);
        assertEquals(15, player.getExp());
        assertEquals(2, player.getLevel());
        player.addExp(19);
        assertEquals(34, player.getExp());
        assertEquals(4, player.getLevel());
    }
}