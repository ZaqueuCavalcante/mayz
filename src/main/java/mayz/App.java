package mayz;

import processing.core.PApplet;

public class App 
{
    public static void main( String[] args )
    {
        replayMode();
    }

    public static void funMode() {
        PApplet.main(new String[] { "mayz.GameFunMode" });
    }

    public static void debugMode() {
        PApplet.main(new String[] { "mayz.GameDebugMode" });
    }

    public static void releaseMode() {
        GameReleaseMode.run();
    }

    public static void replayMode() {
        PApplet.main(new String[] { "mayz.GameReplayMode" });
    }
}
