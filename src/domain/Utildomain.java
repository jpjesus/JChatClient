/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Jesus Parada & Erik Medina
 */
public class Utildomain
{
   
    public static       String USER_NICKNAME;
    public static final String PREFERENCE_TAG               = "preference";
    public static final String PREFERENCE_NICKNAME_TAG      = "nickname";
    public static final String PREFERENCE_SERVERIP_TAG      = "serverip";
    public static final String PREFERENCE_SERVERPORT_TAG    = "serverport";
    public static final String PREFERENCE_CLIENTPORT_TAG    = "clientport";
    
    public static final String SAVECHAT_TAG               = "savechat";
    public static final String SAVECHAT_NICKNAME_TAG      = "nickname";
    public static final String SAVECHAT_DATE_TAG          = "date";
    public static final String SAVECHAT_TIME_TAG          = "time";
    public static final String SAVECHAT_MESSAGE_TAG     = "message";
    
    public static final String ERROR_PREFERENCE_NICKNAME_TAG      = "Error loading User from XML - Error in the attribute " + PREFERENCE_NICKNAME_TAG + " of the XML tag";
    public static final String ERROR_PREFERENCE_SERVERIP_TAG      = "Error loading User from XML - Error in the attribute " + PREFERENCE_SERVERIP_TAG + " of the XML tag";
    public static final String ERROR_PREFERENCE_SERVERPORT_TAG    = "Error loading User from XML - Error in the attribute " + PREFERENCE_SERVERPORT_TAG + " of the XML tag";
    public static final String ERROR_PREFERENCE_CLIENTPORT_TAG    = "Error loading User from XML - Error in the attribute " + PREFERENCE_CLIENTPORT_TAG + " of the XML tag";
    
    public static final String ERROR_SAVECHAT_NICKNAME_TAG      = "Error loading User from XML - Error in the attribute " + SAVECHAT_NICKNAME_TAG + " of the XML tag";
    public static final String ERROR_SAVECHAT_DATE_TAG      = "Error loading User from XML - Error in the attribute " + SAVECHAT_DATE_TAG + " of the XML tag";
    public static final String ERROR_SAVECHAT_TIME_TAG    = "Error loading User from XML - Error in the attribute " + SAVECHAT_TIME_TAG + " of the XML tag";
    public static final String ERROR_SAVECHAT_MESSAGE_TAG    = "Error loading User from XML - Error in the attribute " + SAVECHAT_MESSAGE_TAG + " of the XML tag";
    
    public static final String ERROR_XML_EMPTY_FILE                 = "Error loading XML file - The file is empty";
    public static final String ERROR_XML_PROCESSING_FILE            = "Error loading XML file - It's not possible processing the file";
    
    public static final String PREFERENCES_XML_PATH           = "src/domain/xml/preferences.xml";
    public static final String SAVECHAT_XML_PATH           = "src/domain/xml/savechats.xml";
    }

