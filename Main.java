import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;

import javax.xml.soap.SOAPException;

import de.onvif.soap.OnvifDevice;

public class Main {

    public static  void main(String args[]) {
	InputStreamReader inputStream = new InputStreamReader(System.in);
	BufferedReader input = new BufferedReader(inputStream);
	String ip, user, password;

            try {
		System.out.println("Masukan IP : ");
		ip = input.readLine();
		System.out.println("Masukan Username : ");
		user = input.readLine();
		System.out.println("Masukan Password : ");
		password = input.readLine();
		}
		catch (IOException e1) {
			e1.printStackTrace();
			return;
		}

		System.out.println("\nMenghubungkan ke kamera");
		OnvifDevice kamera ;
		try {
			kamera = new OnvifDevice(ip, user, password);
		}
		catch (ConnectException | SOAPException e1) {
			System.err.println("Tidak terhubung ke kamera");
			return;
		}
		System.out.println("hubungkan ke kamera berhasil\n");
                
                 while (true) {
                    
                     HttpClient.snapshot();
                     return;
                
                 } 
    }             
    
}