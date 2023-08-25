package com.ratlab.topdownryan;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.ratlab.topdownryan.TopDownRyan;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.useVsync(true);
		config.setForegroundFPS(60);
		config.setTitle("Top Down Ryan");
		config.setWindowedMode(GameVariables.screenWidth, GameVariables.screenHeight);
		new Lwjgl3Application(new TopDownRyan(), config);
	}
}
