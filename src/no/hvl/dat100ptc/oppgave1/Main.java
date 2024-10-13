package no.hvl.dat100ptc.oppgave1;

public class Main {

	public static void main(String[] args) {
		
		// TODO
		GPSPoint gpsPoint = new GPSPoint(1, 2.0, 3.0, 5.0);

        // Bruk getTime-metoden for å skrive tid ut på skjermen
        System.out.println("Tid: " + gpsPoint.getTime());

        // Bruk setTime-metoden for å endre tid til 2
        gpsPoint.setTime(2);

        // Bruk toString-metoden for å skrive informasjon om objektet ut på skjermen
        System.out.println(gpsPoint.toString());
		
	}

}
