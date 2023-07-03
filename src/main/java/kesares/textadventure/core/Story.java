package kesares.textadventure.core;

import kesares.textadventure.entity.Player;
import kesares.textadventure.io.OutputManager;
import kesares.textadventure.util.lang.Strings;

public class Story {

    public Story(Player player) {
    }

    public void continueJourney() {
        OutputManager.clearConsole();
        double eventRate = Math.random();

        if (eventRate < 0.7) {
            // battle
        } else if (eventRate < 0.9) {
            System.out.println(Strings.peacefulJourney);
        }
    }
}