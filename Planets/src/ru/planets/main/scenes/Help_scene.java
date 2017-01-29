package ru.planets.main.scenes;

import java.awt.Graphics;

import ru.planets.main.settings.Settings;
import ru.planets.main.utils.Tools;

public class Help_scene extends Scene {
	
	double count = 0;
	public boolean showHelp = false;
	
	@Override
	public void Render(Graphics g) {
		drawHelp(this.showHelp, g);
	}

	@Override
	public void Update(double delta) {
		count += delta;
		
		// Blink help
		if(count > 1 * Settings.TICKS_IN_SECOND){
			this.showHelp = !this.showHelp;
			count = 0;
		}
	}
	
	public void drawHelp(boolean showHelp, Graphics g){
        // Draw title
        Tools.drawText(Settings.WINDOW_WIDTH / 2, 50,
        		 Settings.HELP_TITLE, g, 
        		 Settings.FONT_TITLE, 
        		 Settings.ALIGN_MIDDLE);
        
        // Draw help text
        for(int i = 0; i < Settings.HELP.length; i++){
        	Tools.drawText(Settings.WINDOW_WIDTH / 2, 
        			 75 + (20 * i), 
        			 Settings.HELP[i], g, 
        			 Settings.FONT_TEXT, 
        			 Settings.ALIGN_MIDDLE);
        }
        
        // Draw help tip
        if(this.showHelp){
	        Tools.drawText(Settings.WINDOW_WIDTH / 2, 
	        		 100 + (20 * Settings.HELP.length), 
	        		 Settings.HELP_TIP, g, 
	        		 Settings.FONT_TITLE, 
	        		 Settings.ALIGN_MIDDLE);
        }
	}
}
