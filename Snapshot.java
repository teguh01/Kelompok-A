package snapshot;

import com.googlecode.javacv.FrameGrabber;
import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core;
import static com.googlecode.javacv.cpp.opencv_highgui.cvSaveImage;

public class Snapshot {

    public static void main(String[] args) throws Exception {
    OpenCVFrameGrabber frameGrabber = new OpenCVFrameGrabber("rtsp://admin:tekkom2016@192.168.1.64/Stream/Channels/101/?dummy=param.mjpg"); //inisiasi untuk pemanggilan fungsi alamat ip kamera
        try {
            frameGrabber.start();
            opencv_core.IplImage img=frameGrabber.grab();
            if(img!=null)
            {
                cvSaveImage("Picture.png", img);
            }
        } catch (FrameGrabber.Exception e){
        }
    }
}

