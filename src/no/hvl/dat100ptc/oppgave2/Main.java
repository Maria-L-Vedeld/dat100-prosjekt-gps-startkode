package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class Main {

	
	public static void main(String[] args) {

		// TODO
		GPSPoint gpsPoint_1 = new GPSPoint(31948, 60.385390, 5.217217, 62);
		GPSPoint gpsPoint_2 = new GPSPoint(36000, 60.389000, 5.220000, 63.0);
		
		
		GPSData gpsData = new GPSData(2);
		
		
		gpsData.insertGPS(gpsPoint_1);
		gpsData.insertGPS(gpsPoint_2);
		
		
		gpsData.print();
	}
}
