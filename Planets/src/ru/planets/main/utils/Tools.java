package ru.planets.main.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

import ru.planets.main.settings.Settings;

public class Tools {
	public static void drawText(int x, int y, String text, Graphics g, Font font, int alignment){
		//Graphics2D g2d = (Graphics2D) g;
		g.setFont(font);
		g.setColor(Color.WHITE);
		
		FontMetrics metrics = g.getFontMetrics(font);
		
		switch(alignment){
			default:
			case Settings.ALIGN_LEFT:
				g.drawString(text, x, y);
			break;
			case Settings.ALIGN_MIDDLE:
				g.drawString(text, x - metrics.stringWidth(text) / 2, y);
			break;
			case Settings.ALIGN_RIGHT:
				g.drawString(text, x - metrics.stringWidth(text), y);
			break;
		}
	}
}
