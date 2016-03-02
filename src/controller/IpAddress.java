/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Romi
 */
import java.net.*;

public class IpAddress {

    public static String getIP () {
        
        String ip = null;
        
        try {
          InetAddress address = InetAddress.getByName( "localhost" );
          address = InetAddress.getLocalHost();
          
          // Coge la dirección IP como un array de bytes
          byte[] bytes = address.getAddress();
          
          // Convierte los bytes de la dirección IP a valores sin
          // signo y los presenta separados por espacios
          
          for( int cnt=0; cnt < bytes.length; cnt++ ) {
            int uByte = bytes[cnt] < 0 ? bytes[cnt]+256 : bytes[cnt];
            
            if (ip==null){
                String u = Integer.toString(uByte);
                ip=u;
            }
            else {
            String u = Integer.toString(uByte);
            ip = ip+"."+u;
            }
          }
          System.out.println();
          }catch( UnknownHostException e ) {
            System.out.println( e );
            System.out.println( "Off Line =(" );
       }
        System.out.println(ip);
        
        return (ip); 
    }
    
}
