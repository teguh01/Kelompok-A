import java.net.Authenticator;
import java.net.InetAddress;
import java.net.PasswordAuthentication;

public class Autentikasi extends Authenticator {
    // Metode ini dipanggil ketika URL yang dilindungi kata sandi diakses
    protected PasswordAuthentication getPasswordAuthentication() {
        
        // mendapatkan informasi tentang permintaan tersebut
        String promptString = getRequestingPrompt();
        String hostname = getRequestingHost();
        InetAddress ipaddr = getRequestingSite();
        int port = getRequestingPort();
 
        // mendapatkan username dari pengguna
        String username = "admin";
 
        // mendapatkan password dari pengguna
        String password = "tekkom2016";
 
        // mengembalikan informasi ke PasswordAuthentication
        return new PasswordAuthentication(username, password.toCharArray());
    }
}
