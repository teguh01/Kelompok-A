import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Authenticator;
import java.net.URL;
import java.net.URLConnection;

public class HttpClient {
     
    public static void download(String address, String localFileName) {
        OutputStream out = null;
        URLConnection conn = null;
        InputStream  in = null;
        try {
             
            URL url = new URL(address);
            out = new BufferedOutputStream(
            new FileOutputStream(localFileName));
            conn = url.openConnection();
            Authenticator.setDefault(new Autentikasi());
            in = conn.getInputStream();
            byte[] buffer = new byte[1024];
            int numRead;
            long numWritten = 0;
            while ((numRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, numRead);
                numWritten += numRead;
            }
            System.out.println(localFileName + "\t" + numWritten);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException ioe) {
            }
        }
    }
 
    public static void download(String address) {
        int lastSlashIndex = address.lastIndexOf('/');
        if (lastSlashIndex >= 0 && lastSlashIndex < address.length() - 1) {
            download(address, address.substring(lastSlashIndex + 1));
        } else {
            System.err.println("Tidak dapat menemukan nama file lokal untuk " + address);
        }
    }
     
    public static void snapshot() {
        
            HttpClient.download("http://192.168.1.64/onvif-http/snapshot?Profile_1", "E:\\snapshot.png");
    }
}