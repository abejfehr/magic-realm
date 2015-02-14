package com.magicrealm.client.controller;

import java.util.Observable;

import com.magicrealm.client.ui.screen.MainMenu;
import com.magicrealm.client.ui.screen.Screen;

/*
 * ScreenController will manage which screen is currently shown in the game.
 * 
 * The Main class(the entry point of the program) registered as an observer for
 * this class.
 * 
 * If you'd like to show a screen, simply do this:
 * - Make your screen so it extends com.magicrealm.client.ui.screen.Screen;
 * - Anywhere you'd like to switch screens, simply call the following:
 *     scrController.show(MyScreen.class)
 * 
 * The above code shows MyScreen in the window instead of whatever was just
 * shown.
 * 
 * Things to keep in mind:
 * - It doesn't remember or care about the state of your previous screen. If 
 * your screen needs to store something besides what's already in the model,
 * you'd better put it in the model.
 * - It doesn't care what kind of parameter gets passed into show(). It works
 * with reflection, but I don't think I have the ability to limit parameters to
 * only be Screen types. Be careful.
 * - It expects your screen to have a constructor with NO parameters
 * 
 */
public class ScreenController extends Observable {
	// Stores the current screen
	private Screen screen;
	
	public ScreenController() {
		screen = new MainMenu();
		screen.setController(this);
	}
	
	public void show(Class<?> screen) {
		Object newScreen = null;
		try {
			newScreen = screen.newInstance();
			((Screen) newScreen).setController(this);
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.screen = (Screen)newScreen;
		setChanged();
		notifyObservers(this.screen);
	}

	public Screen getScreen() {
		return screen;
	}
}
