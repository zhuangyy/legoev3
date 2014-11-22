package zyy.ev3.mecanum.test;

import java.util.ArrayList;
import java.util.Collection;

import zyy.ev3.mecanum.MecanumNavigator;

public class Mecalets extends ArrayList<Mecalet> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -880895295825274190L;

	public Mecalets(MecanumNavigator nav) {
		add(new MecaletPolar(nav));
		add(new MecaletCartesian(nav));
		add(new MecaletCircle1(nav));
		add(new MecaletCircle2(nav));
		add(new MecaletCircle3(nav));
		add(new MecaletSpin(nav));
	}

	public String[] getTitles() {
		String r[] = new String[this.size()];
		int i;
		for (i = 0; i < size(); i ++) {
			r[i] = get(i).getTitle();
		}
		return r;
	}

	public boolean run(int idx) {
		Mecalet m = get(idx);
		if (null != m) {
			return m.run();
		}
		return false;
	}

}
