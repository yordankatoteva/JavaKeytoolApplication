/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javakeytoolapplication;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ytoteva
 */
// http://grepcode.com/file/repository.grepcode.com/java/root/jdk/openjdk/8u40-b25/sun/security/tools/keytool/Main.java
public class Keytool {

    private static final String Country = "BG";
    public static void executeCommand(String command) {
        try {
            sun.security.tools.keytool.Main.main(parse(command));
        } catch (Exception ex) {
            Logger.getLogger(Keytool.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String[] parse(String command) {
        String[] options = command.trim().split("\\s+");
        return options;
    }

    public static String[] generateKeyPair(String Alias, String OID, String CommonName, String Path, String StorePass, String KeyPass) {
        String jskPath = null;
        String jskStorePass = null;
        String jskKeyPass = null;
        String command = " -genkeypair "
                + " -alias " + Alias + " "
                + " -keyalg RSA " + " -keysize 2048 "
                + " -dname C=" + Country + ",S=OID:" + OID + ",CN=" + CommonName + " "
                + " -keystore " + Path + "\\"+ Alias + ".jsk" + " "
                + " -storepass " + StorePass + " "
                + " -keypass " + KeyPass + " ";
        jskPath = Path + "\\"+ Alias + ".jsk";
        jskStorePass = StorePass;
        jskKeyPass = KeyPass;
        executeCommand(command);
        String[] data = new String[]{jskPath, jskStorePass, jskKeyPass};
        return data;
    }
    public static void createCertificateRequest(String Alias, String Path, String StorePass, String KeyPass)
    {
        //String fileName = Path.substring(0, String.c);
        String command = " -certreq "
                + " -alias " + Alias + " "
                + " -file " + Path + " "
                + " -keystore C:\\Users\\ytoteva\\Desktop\\justatest6.jks "
                + " -storepass 123456 "
                + " -keypass 123456";
        executeCommand(command);
    }
    
    public static void list(String[] data) {
        String jskPath = null;
        String jskStorePass = null;
        String jskKeyPass = null;
        
        for (int i = 0; i < 10; i++) {
            switch (i) {
                case 0:
                    jskPath = data[0];
                    break;
                case 1:
                    jskStorePass = data[1];
                    break;
                case 2:
                    jskKeyPass = data[2];
                    break;
                default:
                    break;
            }
        }
        
        String command = " -list "
                + " -v "
                + " -keystore " + jskPath + " "
                + " -storepass " + jskStorePass + " "
                + " -keypass " + jskKeyPass;
        executeCommand(command);
    }
}
