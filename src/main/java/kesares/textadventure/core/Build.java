package kesares.textadventure.core;

import kesares.textadventure.Main;

public final class Build {

    public static final boolean IS_RUNNING_IN_PRODUCTION_MODE;

    static {
        String relativePath = Main.class.getName().replace('.', '/');
        String absolutePath = String.valueOf(Main.class.getResource(String.format("/%s.class", relativePath)));
        IS_RUNNING_IN_PRODUCTION_MODE = absolutePath.startsWith("jar:");
    }

    private Build() {
        throw new UnsupportedOperationException();
    }
}