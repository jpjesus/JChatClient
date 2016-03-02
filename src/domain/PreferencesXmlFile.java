package domain;







import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import jsockets.server.logic.Server;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.JDOMParseException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import presentation.Main;
import util.Util;


/**
 *
 * @author Jesus Parada & Erick Medina
 */
public class PreferencesXmlFile {

    public static User readPreferencesFromFile(String nick)
    {  
        User             user = null;
        Document        doc;
        Element         root,child;
        List <Element>  rootChildrens;
        String          nickname, serverip, serverport, clientport;
        boolean         found = false;
        int             pos = 0;

        SAXBuilder      builder = new SAXBuilder();

        try
        {
            doc = builder.build(Utildomain.PREFERENCES_XML_PATH);

            root = doc.getRootElement();

            rootChildrens = root.getChildren();

            while (!found && pos < rootChildrens.size())
            {
                child = rootChildrens.get(pos);

                nickname        = child.getAttributeValue(Utildomain.PREFERENCE_NICKNAME_TAG);
                serverip        = child.getAttributeValue(Utildomain.PREFERENCE_SERVERIP_TAG);
                serverport      = child.getAttributeValue(Utildomain.PREFERENCE_SERVERPORT_TAG);
                clientport      = child.getAttributeValue(Utildomain.PREFERENCE_CLIENTPORT_TAG);
                
                
                if(nickname         != null   &&   nickname.compareTo(nick)==0 &&
                   serverip         != null   &&    
                   serverport       != null   &&
                   clientport       != null   )
                {
                    found = true;
                    Main.setSERVIDOR(serverip);
                    int port = Integer.parseInt(clientport.trim());
                    Main.setNUMERO_PUERTO_ESCUCHA(port);
                    System.out.println(Main.NUMERO_PUERTO_ESCUCHA );
                    int port1 = Integer.parseInt(serverport.trim());
                    Main.setNUMERO_PUERTO_ENVIO(port1);
                    user = new User( nickname, serverip, serverport,clientport );
                    
                }
                else
                {
                    if (nickname == null)
                        System.out.println(Utildomain.ERROR_PREFERENCE_NICKNAME_TAG);

                    if (serverip == null)
                        System.out.println(Utildomain.ERROR_PREFERENCE_SERVERIP_TAG);

                    if (serverport == null)
                        System.out.println(Utildomain.ERROR_PREFERENCE_SERVERPORT_TAG);
                    
                    if (clientport == null)
                        System.out.println(Utildomain.ERROR_PREFERENCE_CLIENTPORT_TAG);
                   
                }
                pos++;
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println(Utildomain.ERROR_XML_EMPTY_FILE);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Utildomain.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Utildomain.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }

        return user;
    }
    
     public static boolean updatePreferencesInFile(String nickuser,String sip, String sport, String myport)
    {
        Document        doc;
        Element         root,child;
        List <Element>  rootChildrens;
        String          nickname, serverip, serverport, clientport;
        boolean         found = false;
        int             pos = 0;

        SAXBuilder      builder = new SAXBuilder();

        try
        {
            doc = builder.build(Utildomain.PREFERENCES_XML_PATH);

            root = doc.getRootElement();

            rootChildrens = root.getChildren();

            while (!found && pos < rootChildrens.size())
            {
                child = rootChildrens.get(pos);

                nickname             = child.getAttributeValue(Utildomain.PREFERENCE_NICKNAME_TAG);
                serverip             = child.getAttributeValue(Utildomain.PREFERENCE_SERVERIP_TAG);
                serverport           = child.getAttributeValue(Utildomain.PREFERENCE_SERVERPORT_TAG);
                clientport           = child.getAttributeValue(Utildomain.PREFERENCE_CLIENTPORT_TAG);
                
                
                
                if(nickname     != null && serverip     != null && 
                   serverport   != null && clientport   != null && 
                   nickname.equals(nickuser))
                {
                    
                    found = true;
                    
                    child.removeAttribute(Utildomain.PREFERENCE_SERVERIP_TAG);
                    child.setAttribute(Utildomain.PREFERENCE_SERVERIP_TAG, sip);
                   
                    child.removeAttribute(Utildomain.PREFERENCE_SERVERPORT_TAG);
                    child.setAttribute(Utildomain.PREFERENCE_SERVERPORT_TAG, sport);
                    
                    child.removeAttribute(Utildomain.PREFERENCE_CLIENTPORT_TAG);
                    child.setAttribute(Utildomain.PREFERENCE_CLIENTPORT_TAG, myport);
                    
                    
            try
            {
                Format format = Format.getPrettyFormat();
             
                XMLOutputter out = new XMLOutputter(format);

                FileOutputStream file = new FileOutputStream(Utildomain.PREFERENCES_XML_PATH);

                out.output(doc,file);

                file.flush();
                file.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
                }
                else
                {
                    if (nickname == null)
                        System.out.println(Utildomain.ERROR_PREFERENCE_NICKNAME_TAG);
                    if (serverport == null)
                        System.out.println(Utildomain.ERROR_PREFERENCE_SERVERPORT_TAG);
                    if (serverip == null)
                        System.out.println(Utildomain.ERROR_PREFERENCE_SERVERIP_TAG);
                    if (clientport == null)
                        System.out.println(Utildomain.ERROR_PREFERENCE_CLIENTPORT_TAG);
                    
                    pos++;
                }
                
           
                
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println(Utildomain.ERROR_XML_EMPTY_FILE);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Utildomain.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Utildomain.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }

        return found;
    }
     public static boolean saveChatToFile (String nickname,String message)
    {
        Document    doc;
        Element     root, newChild;

        SAXBuilder  builder = new SAXBuilder();
         Locale l = new Locale("es","VE");
         Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Caracas"),l);
         String date =cal.get(Calendar.DATE)+"/" +cal.get((Calendar.MONTH+1))+"/" +cal.get(Calendar.YEAR);
         String time =cal.get(Calendar.HOUR)+":"+cal.get(Calendar.MINUTE);
        try
        {
            doc = builder.build(Utildomain.SAVECHAT_XML_PATH);

            root = doc.getRootElement();

            newChild = new Element(Utildomain.SAVECHAT_TAG);

            newChild.setAttribute(Utildomain.SAVECHAT_DATE_TAG, date);
            newChild.setAttribute(Utildomain.SAVECHAT_TIME_TAG, time);
            newChild.setAttribute(Utildomain.SAVECHAT_NICKNAME_TAG, nickname);
            newChild.setAttribute(Utildomain.SAVECHAT_MESSAGE_TAG, message);
            
            root.addContent(newChild);
            try
            {
                Format format = Format.getPrettyFormat();
             
                XMLOutputter out = new XMLOutputter(format);

                FileOutputStream file = new FileOutputStream(Utildomain.SAVECHAT_XML_PATH);

                out.output(doc,file);

                file.flush();
                file.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println(Utildomain.ERROR_XML_EMPTY_FILE);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Utildomain.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Utildomain.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }

        return true;
    }
}

