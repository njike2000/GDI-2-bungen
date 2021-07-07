package util;

public class MathUtil {
	public static final double EPSILON = 1.0E-8;

	public static final boolean nearlyEquals(double a, double b) {
		return (a > b ? a - b : b - a) < EPSILON;
	}

	public static final boolean nearlyNull(double a) {
		return (a > 0 ? a : -a) < EPSILON;
	}
/*
	public static double atan2(double x, double y) {
		if (nearlyNull(x) && nearlyNull(y))
			return 0;
		if (MathUtil.nearlyNull(x))
			return (y > 0 ? 90 : 270);  // Punkt auf der y -Achse
		if (MathUtil.nearlyNull(y))
			return (x > 0 ? 0 : 180);   // Punkt auf der x-Achse

		double angle = Math.toDegrees(Math.atan(y / x));
		if (x > 0 && y < 0) // im vierten Quadranten
			angle += 360;
		else if (x < 0)     // im zweiten oder im dritten
			angle += 180;
		return angle;

	}
*/
}
