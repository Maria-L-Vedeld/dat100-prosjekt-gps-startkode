package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int antall) {
		
		// TODO
		gpspoints = new GPSPoint[antall];
		
		antall = 0;
		
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	protected boolean insertGPS(GPSPoint gpspoint) {

		boolean inserted = false;
		
		
		// TODO 
		if (antall < gpspoints.length) {
			gpspoints[antall] = gpspoint;
			antall++;
			return true;
		}else {
			return inserted;
		}
	
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {

		//GPSPoint gpspoint;

		// TODO 
		
		int tid = GPSDataConverter.toSeconds(time);
		double breddeg = Double.parseDouble(latitude);
		double lengdeg = Double.parseDouble(longitude);
		double hoyde = Double.parseDouble(elevation);
		
		GPSPoint gpspoint = new GPSPoint(tid, breddeg, lengdeg, hoyde);
		
		return insertGPS(gpspoint);
	}

	public void print() {

		// TODO 
		
		System.out.println("===== GPS Data - START =====");
		
		for (int i = 0; i < antall; i++) {
			System.out.println((i + 1) + " " + gpspoints[i].toString());
		}
		System.out.println("===== GPS Data - SLUTT =====");
		
	}
}
