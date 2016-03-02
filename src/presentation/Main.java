/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;
import logic.RequestManagement;
import controller.IpAddress;
import domain.StandardObject;
import jsockets.client.SocketClient;
import jsockets.server.logic.Server;
import util.Util;
/**
 *
 * @author Jesus Parada & Erick Medina
 */
public class Main {
    public static int NUMERO_PUERTO_ENVIO = 7687;
    public static String SERVIDOR = "127.0.0.1";
    public static int NUMERO_PUERTO_ESCUCHA = 7692;
    public static String MI_IP = IpAddress.getIP();

    public static String getMI_IP() {
        return MI_IP;
    }

    public static void setMI_IP(String MI_IP) {
        Main.MI_IP = MI_IP;
    }

    public static int getNUMERO_PUERTO_ENVIO() {
        return NUMERO_PUERTO_ENVIO;
    }

    public static void setNUMERO_PUERTO_ENVIO(int NUMERO_PUERTO_ENVIO) {
        Main.NUMERO_PUERTO_ENVIO = NUMERO_PUERTO_ENVIO;
    }

    public static int getNUMERO_PUERTO_ESCUCHA() {
        return NUMERO_PUERTO_ESCUCHA;
    }

    public static void setNUMERO_PUERTO_ESCUCHA(int NUMERO_PUERTO_ESCUCHA) {
        Main.NUMERO_PUERTO_ESCUCHA = NUMERO_PUERTO_ESCUCHA;
    }

    public static String getSERVIDOR() {
        return SERVIDOR;
    }

    public static void setSERVIDOR(String SERVIDOR) {
        Main.SERVIDOR = SERVIDOR;
    }
 
    
    
    
    public static void main(String [] args)
    {   
        

        
        
           SocketClient usersocket = new SocketClient();

         byte[] resultado;
        
        StandardObject generalObject;
       MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);
        mainWindow.setLocationRelativeTo(null);
        
        String port =Integer.toString(NUMERO_PUERTO_ESCUCHA).trim();
        System.out.println(port);
        String[] parametros = {port, Util.CLASE_LOGICA};
        System.out.println(port);
        Server.main(parametros);
    }
    
}
