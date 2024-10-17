package no.hvl.dat100ptc.oppgave4;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;

import no.hvl.dat100ptc.TODO;

public class GPSComputer {

	private GPSPoint[] gpspoints;

	public GPSComputer(String filename) {

		GPSData gpsdata = GPSDataFileReader.readGPSFile(filename);
		gpspoints = gpsdata.getGPSPoints();

	}

	public GPSComputer(GPSPoint[] gpspoints) {
		this.gpspoints = gpspoints;
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}

	public double totalDistance() {

		double distance = 0;

		// TODO
		
		 for (int i = 0; i < gpspoints.length - 1; i++) {
			 distance += GPSUtils.distance(gpspoints[i], gpspoints[i + 1]);

		}
		return distance;

	}

	public double totalElevation() {

		double elevation = 0;

		// TODO
		for (int i = 1; i < gpspoints.length; i ++) {
			double elevationDiff = gpspoints[i].getElevation() - gpspoints[i - 1].getElevation();
			if (elevationDiff > 0) {
				elevation += elevationDiff;
			}
		}
		return elevation;
	}

	public int totalTime() {
		
		//TODO
		
		int startTid = gpspoints[0].getTime();
		int endTid = gpspoints[gpspoints.length - 1].getTime();
		
		return endTid -startTid;
		

	}

	public double[] speeds() {

		double[] speeds = new double[gpspoints.length - 1];

		// TODO
		for (int i = 0; i < gpspoints.length - 1; i++) {
			double distance = GPSUtils.distance(gpspoints[i], gpspoints[i + 1]);
			int tid = gpspoints[i + 1].getTime() - gpspoints[i].getTime();
			speeds[i] = distance / tid;
		}
		return speeds;
	}

	public double maxSpeed() {
		
		double[] speeds = speeds();
		double maxspeed = 0;

		// TODO
		for (double speed : speeds) {
			if (speed > maxspeed) {
				maxspeed = speed;
			}
		}
		return maxspeed;
	}

	public double averageSpeed() {

		double average = 0;

		// TODO
		for (int i = 0; i < gpspoints.length - 1; i++) {
			double totalDistance = totalDistance();
			int totalTid = totalTime();
			average = totalDistance / totalTid;
		}
		return average;
	}

	// conversion factor m/s to miles per hour (mps)
	public static final double MS = 2.23;

	public double kcal(double weight, int secs, double speed) {

		double kcal;

		double met = 0;
		
		double speedmph = speed * MS;

		// TODO
		if (speedmph < 10) {
			met = 4.0;
		}else if (speedmph < 12) {
			met = 6.0;
		}else if (speedmph < 14) {
			met = 8.0;
		}else if (speedmph < 16) {
			met = 10.0;
		}else if (speedmph < 20) {
			met = 12.0;
		}else {
			met = 16;
		}
		double timer = secs / 3600.0;
		return met * weight * timer;

	}

	public double totalKcal(double weight) {

		double totalkcal = 0;

		// TODO
	    double[] speeds = speeds();
	    
	    for (int i = 0; i < speeds.length; i++) {
	        int timeSegment = gpspoints[i + 1].getTime() - gpspoints[i].getTime();
	        totalkcal += kcal(weight, timeSegment, speeds[i]);
	    }
	    
	    return totalkcal;

	}

	private static double WEIGHT = 80.0;

	public void displayStatistics() {

		// TODO
		int totalTime = totalTime();
	    double totalDistance = totalDistance();
	    double totalElevation = totalElevation();
	    double maxSpeed = maxSpeed() * 3.6; 
	    double averageSpeed = averageSpeed() * 3.6; 
	    double energy = totalKcal(WEIGHT); 
	    
	    System.out.println("==============================================\n");
	    System.out.println("Total Time     :   " + GPSUtils.formatTime(totalTime));
	    System.out.println("Total distance :      " + totalDistance / 1000 + "km");
	    System.out.println("Total elevation:     " + totalElevation + "m");
	    System.out.println("Max speed      :      " + maxSpeed + "km/t");
	    System.out.println("Average speed  :      " + averageSpeed + "km/t");
	    System.out.println("Energy         :     " + energy + "kcal");
	    System.out.println("==============================================\n");

	}

}
