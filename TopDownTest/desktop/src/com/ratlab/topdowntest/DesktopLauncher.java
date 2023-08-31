package com.ratlab.topdowntest;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.ratlab.topdowntest.TopDownTest;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.useVsync(true);

		config.setTitle("TopDownTest - Rat Lab");
		config.setWindowedMode(World.screenWidth, World.screenHeight);
		new Lwjgl3Application(new TopDownTest(), config);
	}
}
