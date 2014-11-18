package zyy.ev3.mecanum;

import lejos.utility.Delay;

public class RouteHeart extends Route {
	
	public RouteHeart() {
	}
	
	public void draw(double scale, boolean animate) {
		int offset = SW / 4;
		int i;
		for (i = 0; i <= 60; i ++) {
			double x = scale * (40*i + 1200 - (i * i)) * Math.sin(Math.PI * i / 180.0) / 100.0;
			double y = scale * (40*i + 1200 - (i * i)) * Math.cos(Math.PI * i / 180.0) / 100.0;
			//System.out.println(x + " " + y);
			drawPixel(round(x), round(y) - offset);
			drawPixel(-round(x), round(y) - offset);
			if (animate) {
				Delay.msDelay(20);
			}
		}
	}

}
