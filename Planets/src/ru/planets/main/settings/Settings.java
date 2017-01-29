package ru.planets.main.settings;

import java.awt.Font;

public class Settings {
	public static final int WINDOW_WIDTH = 640;
	public static final int WINDOW_HEIGHT = 480;
	public static final String TITLE = "Planets";
	
	public static final int GAME_STATE_HELP = 0;
	public static final int GAME_STATE_GAME = 1;
	public static final int GAME_STATE_SCORE = 2;
	
	public static final String HELP_TITLE = "HELP";
	public static final String HELP_TIP = "Prees any key to start!";
	
	public static final String[] HELP = {
		"Welcome to Planet Battle!",
		"Control Buttons:",
		"Arrow Up/Down/Left/Right - Moving.",
		"Spacebar - Skip Turn.",
		"Enter - Action.",
		"If our planet - Increase the population by 15.",
		"If neutral planet - Capture Planet.",
		"If enemy planet - Attack enemy Planet.",
		"You capture an enemy planet, if the total number of people on ",
		"your planet more than and you have your Planet nearby.",
		"You win if you grab all the Planets.",
		"You lose if all of your Planet will be captured."
	};
	
	public static final Font FONT_TITLE = new Font("TimesRoman", Font.BOLD, 16);
	public static final Font FONT_TEXT = new Font("TimesRoman", Font.PLAIN, 12);
	
	public static final int ALIGN_LEFT = 0;
	public static final int ALIGN_MIDDLE = 1;
	public static final int ALIGN_RIGHT = 2;
	
	public static final double TICKS_IN_SECOND = 60D;
}
