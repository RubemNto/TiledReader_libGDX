package com.mygdx.tiledmapreader.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.tiledmapreader.Game;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Game game = new Game();
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title="Game title";
		config.useGL30 = true;
		config.width = 16*20*3;
		config.height = 16*12*3;
		new LwjglApplication(game, config);
	}
}
