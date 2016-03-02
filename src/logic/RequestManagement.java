package logic;

import controller.JChatController;
import controller.LogController;
import domain.BlockList;
import domain.PreferencesXmlFile;
import domain.StandardObject;
import java.io.File;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import jsockets.client.SocketClient;
import util.Util;
import jsockets.server.logic.ServerLogic;
import jsockets.util.UtilFunctions;
import presentation.BrodcastWindow;
import presentation.ChatWindow1;
import presentation.JChat;


/**
 * clase de logica de negocio para el ejemplo en el contexto de la gestion
 * de usuarios. esta clase debe implementar la interfaz de jsocket ServerLogic y
 * por tanto el metodo executeOperation, esto es de caracter obligatorio
 * @author gerardobarcia
 * @author ricardocasanova
 * 
 * 
 * GESTION PETICION
 */
public class RequestManagement implements ServerLogic {
private final String SEPARADOR_PROTOCOLO = ":";
    private int operacion;
    private JPanel JPanel;

    @Override
    public byte[] executeOperation(Object arg) {
        byte[] result = null;

        StandardObject standardObject = (StandardObject) arg;

        // se obtiene el protocolo y se separa mediante split por el separador
        // para este ejemplo ":"
        String[] protocol = standardObject.getProtocolo().toString().split(SEPARADOR_PROTOCOLO);

        if (UtilFunctions.isNumeric(protocol[0])) {
            this.operacion = Integer.parseInt(protocol[0]);
        } else {
            throw new RuntimeException("Error.La operacion solicitada no se encuentra soportada");
        }
        
        // dependiendo del numero de operacion enviado en el protocolo:
        switch (this.operacion) {
            case 3: {
                System.out.println("Mesage recived");
                
                if (protocol[3].compareTo("2")==0)
                {
                 if(BrodcastWindow.savechat==true)
                 {
                     PreferencesXmlFile.saveChatToFile(protocol[1], protocol[2]);
                 }
                BrodcastWindow.getjTAconvertation().append(protocol[1]+":"+protocol[2] + "\n");
                }
                else
                {
                    int pos = JChat.getChat().size();
                int i = 0;
                while(i< pos)
                {
                    if(JChat.getChat().get(i).getjLFriendNickname().getText().compareTo(protocol[2])==0)
                    {
                       if(ChatWindow1.savechat==true)
                       {
                           PreferencesXmlFile.saveChatToFile(protocol[1], protocol[3]);
                       }
                        JChat.getChat().get(i).getjTAconvertation().append(protocol[1]+":"+protocol[3] + "\n");
                    } 
                    i++;
                }
                }
                break;   
            }
            case 4:{
                 File fileImagen;
                 int i = 0;
                 Locale l = new Locale("es","VE");
                 Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Caracas"),l);
                 String format =cal.get(Calendar.DATE)+"-" +cal.get((Calendar.MONTH)+1)+"-" +cal.get(Calendar.YEAR)+protocol[2]+Integer.toString(i++);
            try {
                System.out.println(UtilFunctions.byteArrayToString((byte[])standardObject.getObjeto()));
                UtilFunctions.createImageFromByteArray((byte[]) standardObject.getObjeto(),Util.RUTA_COMPUTADORA,format);
                i ++;
            } catch (Exception ex) {
                Logger.getLogger(RequestManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;
            }
            case 8: { // operacion 8 "Update Friends"
                boolean conf=false;
                System.out.println("Update from Server: " + protocol[1]);
                
                BlockList list = new BlockList();
                list = (BlockList) standardObject.getObjeto();
                
                if (list!=null){
                
                LogController.getUser().getUser().setBlockList(list);
                System.out.println("New list");
                 
                try {
                    JChatController.refresh();
                    System.out.println("Refresh Chat");
                } catch (ParseException ex) {
                    Logger.getLogger(RequestManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                conf=true;
                result = UtilFunctions.stringToByteArray("TRUE");
                
                }
                else
                    result = UtilFunctions.stringToByteArray("FALSE");
                 
                break;
            }
            
            
                 
            

            
            
                
            default: { // cualquier otra operacion
                throw new RuntimeException("Error.La operacion solicitada no se encuentra soportada");
            }
        }

        return result;
    }
    
     public void enviarRespuesta(String msg,Object object)
    {
        SocketClient    cliente;
        StandardObject  generalObject;
        //String          mensaje;
        byte[] resultado;
        
        cliente = new SocketClient(false);
        //mensaje = "1:" + "bien y tu?";
        
        generalObject = new StandardObject(msg, object);
        resultado = cliente.executeRequest(generalObject, Util.SERVIDOR, Util.NUMERO_PUERTO_ENVIO);
        
        System.out.println("El resultado devuelto por el cliente es: " + UtilFunctions.byteArrayToString(resultado));
    }
    
}
