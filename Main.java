import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;

import javax.xml.soap.SOAPException;

import de.onvif.soap.OnvifDevice;

public class Main {

    public static  void main(String args[]) {
	InputStreamReader inputStream = new InputStreamReader(System.in);
		BufferedReader keyboardInput = new BufferedReader(inputStream);
		String input, cameraAddress, user, password; // deklarasi untuk masukan
                             
		try {
			System.out.print("Masukan IP Camera : ");
			cameraAddress = keyboardInput.readLine();   // masukan ip camera
			System.out.print("Masukan Username : ");
			user = keyboardInput.readLine();            // masukan user
			System.out.print("Maukan Password : ");
			password = keyboardInput.readLine();        // masukan password
		}
		catch (IOException e1) {
			return;
		}

		System.out.println("Connect to camera, please wait ...");
		OnvifDevice cam; // hubungkan ke Onvif Device
		try {
			cam = new OnvifDevice(cameraAddress, user, password); // inisialisasi masukan dengan cam
		}
		catch (ConnectException | SOAPException e1) {
			System.err.println("No connection to camera, please try again.");
			return;
		}
		System.out.println("Connection to camera successful,");
                System.out.println("Picture Has been Take it!");
                
                while(true) {
                            HttpClient.snapshot();
                            return;
                } 
    }             
}