package kesares.textadventure.io;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import kesares.textadventure.core.World;
import kesares.textadventure.util.AnsiColor;

import java.io.File;
import java.io.IOException;
import java.util.List;

public final class WorldIO {

    private static final String RESOURCES_PATH = "src/main/resources/";

    private WorldIO() {
        throw new UnsupportedOperationException();
    }

    public static List<World> loadWorlds() {
        OutputManager.printBoldPartingLine();
        OutputManager.printCenteredColorText("Load worlds...", AnsiColor.YELLOW, OutputManager.LINE_LENGTH);
        final ObjectMapper mapper = new ObjectMapper();
        try {
            final List<World> worlds = mapper.readValue(new File(RESOURCES_PATH + "worlds.json"), new TypeReference<>(){});
            OutputManager.printCenteredColorText(worlds.size() + " worlds loaded!", AnsiColor.YELLOW, OutputManager.LINE_LENGTH);
            return worlds;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void saveWorlds(List<World> worlds) {
        OutputManager.printCenteredColorText("Save worlds...", AnsiColor.YELLOW, OutputManager.LINE_LENGTH);
        final ObjectMapper mapper = new ObjectMapper();
        final ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
        try {
            writer.writeValue(new File(RESOURCES_PATH + "worlds.json"), worlds);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        OutputManager.printCenteredColorText(worlds.size() + " worlds saved!", AnsiColor.YELLOW, OutputManager.LINE_LENGTH);
    }
}
