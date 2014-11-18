package zyy.ev3.mecanum;

import lejos.hardware.BrickFinder;
import lejos.hardware.lcd.GraphicsLCD;

public class Route {
	protected final int SW;
	protected final int SH;
	
	public Route() {
		GraphicsLCD g = BrickFinder.getDefault().getGraphicsLCD();
		SW = g.getWidth();  //178
		SH = g.getHeight(); //128
	}
	
	public void drawCoord() {
		GraphicsLCD g = BrickFinder.getDefault().getGraphicsLCD();
		g.drawLine(0, SH/2, SW, SH/2);
		g.drawLine(SW/2, 0, SW/2, SH);		
	}
	
	protected void drawPixel(int x, int y) {
		GraphicsLCD g = BrickFinder.getDefault().getGraphicsLCD();
		x += SW / 2;
		y = SH / 2 - y;
		g.setPixel(x, y, 1);
	}
	
	protected int round(double x) {
		return (int)Math.round(x);
	}
	
}
