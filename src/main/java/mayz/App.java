package mayz;

import processing.core.PApplet;

public class App 
{
    public static void main( String[] args )
    {
        debugMode();
    }

    public static void debugMode() {
        PApplet.main(new String[] { "mayz.GameDebugMode" });
    }
}
