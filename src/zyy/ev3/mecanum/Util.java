package zyy.ev3.mecanum;

public class Util {

	public static double[] proportion(double x[], double magnitude) {
		double max = 0.0;
		int i;
		for (i = 0; i < x.length; i++) {
			double t = Math.abs(x[i]);
			if (t > max) {
				max = t;
			}
		}
		double[] r = new double[x.length];
		for (i = 0; i < x.length; i++) {
			r[i] = (max > 0.0) ? (x[i] / max) * magnitude : 0.0;
		}
		return r;
	}

	public static int[] round(double[] x) {
		int[] r = new int[x.length];
		int i;
		for (i = 0; i < x.length; i++) {
			r[i] = (int) Math.round(x[i]);
		}
		return r;
	}
}
