package onvifcamera;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.util.List;
import javax.xml.soap.SOAPException;
import org.onvif.ver10.schema.Profile;
import de.onvif.soap.OnvifDevice;

import com.googlecode.javacv.FrameGrabber;
import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core;
import static com.googlecode.javacv.cpp.opencv_highgui.cvSaveImage;

public class Camera {
	         
	public static void main(String[] args) throws IOException {
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
			System.err.println("No connection to Onvif Camera, please try again.");
			return;
		}
		System.out.println("Connection to Onvif Camera successful!");
                
		while (true) {                                  
                    List<Profile> profiles = cam.getDevices().getProfiles(); // akses profile onvif
                    for (Profile p : profiles) {                   
                     OpenCVFrameGrabber frameGrabber = new OpenCVFrameGrabber("rtsp://admin:tekkom2016@192.168.1.64/Stream/Channels/101/?dummy=param.mjpg");
                        try {
                            frameGrabber.start();
                            opencv_core.IplImage img=frameGrabber.grab();
                            if(img!=null){
                                cvSaveImage("Picture.png", img); // simpan gambar parameter dan nama file
                            }
                        }catch (FrameGrabber.Exception e){
                        }   
                        break;   
                    }
                    break;	
		}
            }
        
       
}
