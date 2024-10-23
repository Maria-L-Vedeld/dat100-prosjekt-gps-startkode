package no.hvl.dat100ptc.oppgave5;

import no.hvl.dat100ptc.TODO;
import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

import javax.swing.JOptionPane;

public class ShowProfile extends EasyGraphics {

	private static final int MARGIN = 50;		// margin on the sides 
	
	private static final int MAXBARHEIGHT = 500; // assume no height above 500 meters
	
	private GPSPoint[] gpspoints;

	public ShowProfile() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn (uten .csv): ");
		GPSComputer gpscomputer =  new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		int N = gpspoints.length; // number of data points

		makeWindow("Height profile", 2 * MARGIN + 3 * N, 2 * MARGIN + MAXBARHEIGHT);
		//makeWindow("Height profile", 5000, 800);

		// top margin + height of drawing area
		showHeightProfile(MARGIN + MAXBARHEIGHT); 
	}

	public void showHeightProfile(int ybase) {
		
		int k = 0;
		
		int x = MARGIN; // første høyde skal tegnes ved MARGIN
		int y = 300;


		// TODO x aksen må oppdateres for hver linje som tegnes. y er der linjen starter. linjen avsluttes så langt over y-aksen
		
		for (int i  = 0; i < gpspoints.length; i++) {  // vil ikke anerkjenne N som en variabel
			int hoyde = (int)Math.round(gpspoints[i].getElevation());
			
			if (hoyde < 0) {
				hoyde = 0;
			}
			drawLine(x, y, x, y - hoyde);   //(start x, start y, slutt x, slutt y)  start x og slutt x er de samme verdiene, men må oppdateres for hver linje
			x = x + 2;
		}
		
	}

}

