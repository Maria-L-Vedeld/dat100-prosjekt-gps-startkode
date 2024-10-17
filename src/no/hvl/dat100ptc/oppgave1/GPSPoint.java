package no.hvl.dat100ptc.oppgave1;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave3.GPSUtils;

public class GPSPoint {

	// TODO - objektvariable
	
	private int time;
	private double latitude;
	private double longitude;
	private double elevation;
	
	
	public GPSPoint(int time, double latitude, double longitude, double elevation) {

		// TODO - konstruktur
		this.time = time;
		this.latitude = latitude;
		this.longitude = longitude;
		this.elevation = elevation;
				
	}

	// TODO - get/set metoder
	public int getTime() {
		
		System.out.println(this.time);
		
		return this.time;
		
	}

	public void setTime(int time) {
				
		this.time = time;
		
	}

	public double getLatitude() {
		
		//System.out.println(this.latitude);
		
		return this.latitude;
		
		
	}

	public void setLatitude(double latitude) {
		
		this.latitude = latitude;
		
	}

	public double getLongitude() {
		
		//System.out.println(this.longitude);	
		
		return this.longitude;
		
	}

	public void setLongitude(double longitude) {
		
		this.longitude = longitude;
		
	}

	public double getElevation() {
		
		//System.out.println(this.elevation);	
		
		return this.elevation;
		
	}

	public void setElevation(double elevation) {
		
		this.elevation = elevation;
		
	}
	
	public String toString() {
		
		// TODO
		String tid = getTime() + "";
		String breddegrad = getLatitude() + "";
		String lengdegrad = getLongitude() + "";
		String hoyde = getElevation() + "";
		
		String str = (tid + " (" + breddegrad + ","+ lengdegrad + ") " + hoyde + "\n");
		
		System.out.println(str);
		
		return str;
		
	}
}

