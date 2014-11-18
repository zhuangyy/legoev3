package zyy.ev3.mecanum.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import zyy.ev3.mecanum.MecanumNavigator;
import zyy.ev3.mecanum.RouteCircle;
import zyy.ev3.mecanum.RouteHeart;
import lejos.hardware.BrickFinder;
import lejos.hardware.Button;
import lejos.hardware.lcd.GraphicsLCD;
import lejos.hardware.lcd.LCD;
import lejos.robotics.geometry.Point;
import lejos.utility.Delay;
import lejos.utility.TextMenu;

public class Meca4x4 {
		
	static MecanumNavigator nav = new MecanumNavigator();
	static Mecalets lets = new Mecalets(nav);
			
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TextMenu menu = new TextMenu(lets.getTitles());
		int r = menu.select();
		while (r >= 0) {
			if (lets.run(r)) {
				nav.stop(false);			
			}
			r = menu.select();
		}
		nav.release();
	}

}

