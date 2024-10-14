package no.hvl.dat100ptc.oppgave3;

import java.text.DecimalFormat;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;

		// TODO 
		min = da[0];
		
		for (double d : da) {
			if (d < min ) {
				min = d;
			}
		}
		return min;
	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		
		// TODO
		double[] latitudes = new double[gpspoints.length];
		

		
		
		for (int i = 0; i < gpspoints.length; i++) {
			latitudes[i] = gpspoints[i].getLatitude();
		}
		
		return latitudes;
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		
		// TODO
		double[] longitudes = new double[gpspoints.length];
		
		
		for (int i = 0; i < gpspoints.length; i++) {
			longitudes[i] = gpspoints[i].getLongitude();
		}
		
		return longitudes;

	}

	private static final int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;

		// TODO 
		
		latitude1 = Math.toRadians(gpspoint1.getLatitude());
		longitude1 = Math.toRadians(gpspoint1.getLongitude());
		latitude2 = Math.toRadians(gpspoint2.getLatitude());
		longitude2 = Math.toRadians(gpspoint2.getLongitude());
		
		double deltaLat = (latitude2 - latitude1);
		double deltaLon = (longitude2 - longitude1);
		
		double a = compute_a(latitude1, latitude2, deltaLat, deltaLon);
		//double c = compute_c(a);
		
		
		d = R * compute_c(a);
		
		return d;
		
	}
	
	private static double compute_a(double phi1, double phi2, double deltaphi, double deltadelta) {
	
		
		// TODO 
		return Math.sin(deltaphi /2) * Math.sin(deltaphi / 2)
				+ Math.cos(phi1) * Math.cos(phi2)
				* Math.sin(deltadelta / 2) * Math.sin(deltadelta / 2);
		
/*		phi1 - latitude1
		phi2 - latitude2
		deltaphi - latitude2 - latitude1
		deltadelta - longitude2 - longitude1
*/

		
	}

	private static double compute_c(double a) {

		
		// TODO 
		return 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		
	}

	
	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;
		
		// TODO
		double tid1 = gpspoint1.getTime();
		double tid2 = gpspoint2.getTime();
		
		double tidT = (tid1 + tid2);
		
		secs = (int)tidT;
		double avstand = distance(gpspoint1, gpspoint2);
		speed = avstand  /secs;
		
		return speed;
		
	}

	public static String formatTime(int secs) {		
		
		// TODO 
		
		StringBuilder tidString = new StringBuilder();
		
		int totalSek = secs;

		int timer = totalSek / 3600; // gir ut heltall

		int sekundIgjen = totalSek % 3600;

		int min = sekundIgjen / 60;

		int sekunder = sekundIgjen % 60;
		
		tidString.append("  ");
		
		if (timer < 10) {
			tidString.append("0");
			tidString.append(timer);
			tidString.append(":");
		}else {
			tidString.append(timer);
		}
		
		if (min < 10) {
			tidString.append("0");
			tidString.append(min);
			tidString.append(":");
		}else {
			tidString.append(min);
		}
		
		if (sekunder < 10) {
			tidString.append("0");
			tidString.append(sekunder);
		}else {
			tidString.append(sekunder);
		}
		
		//System.out.println(tidString);
		
		return tidString.toString();
		
	}
	 
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;
		
		StringBuilder lengdeTi = new StringBuilder();

		// TODO  "      1.35"
		
		DecimalFormat df = new DecimalFormat("#.##");
		
		str = df.format(d);
		
		int lengde = str.length();
		
		int antallMellom = TEXTWIDTH - lengde;
		
		for (int i = 0; i < antallMellom; i++) {
			lengdeTi.append(" ");
		}
		lengdeTi.append(str);
		
		System.out.println(lengdeTi);
		
		return lengdeTi.toString();
	}
} //får en liten failure, fordi den printer ut med komma og ikke punktum
