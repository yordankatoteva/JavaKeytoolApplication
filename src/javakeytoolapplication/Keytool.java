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
    public static void createCertificateRequest()
    {
        String command = " -certreq "
                + " -alias justatest6 "
                + " -file C:\\Users\\ytoteva\\Desktop\\justatest6.csr "
                + " -keystore C:\\Users\\ytoteva\\Desktop\\justatest6.jks "
                + " -storepass 123456 "
                + " -keypass 123456";
        executeCommand(command);
    }
    // keytool -certreq -alias is1tesorg -file "C:\Users\ytoteva\Desktop\is1tesorg.csr" -keystore "C:\Users\ytoteva\Desktop\is1tesorg.jks" -storepass 123456 -keypass 123456
    public static void list(String[] data) {
        String jskPath = null;
        String jskStorePass = null;
        String jskKeyPass = null;
        
        for (int i = 0; i < 10; i++) {
            if(i == 0)
            {
                jskPath = data[0];
            }
            else if(i == 1)
            {
                jskStorePass = data[1];
            }
            else if(i == 2)
            {
                jskKeyPass = data[2];
            }
        }
        
        String command = " -list "
                + " -v "
                + " -keystore " + jskPath + " "
                + " -storepass " + jskStorePass + " "
                + " -keypass " + jskKeyPass;
        //"C:\Users\ytoteva\Desktop\is1tesorg.jks"
        executeCommand(command);
    }
}
