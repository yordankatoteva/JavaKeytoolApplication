/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javakeytoolapplication;

/**
 *
 * @author ytoteva
 */
public class JavaKeytoolApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Keytool.list();
       /*String[] result = Keytool.parse(" -genkeypair "
                + " -alias justatest "
                + " -keyalg RSA " + " -keysize 2048 "
                + " -dname C=BG S=OID:2.16.100.1.1.100006.1.2 CN=ytoteva.ad.tlogica.com-java-test"
                + " -keystore \"C:\\Users\\ytoteva\\Desktop\\justatest.jks\" "
                + " -storepass 123456 "
                + " -keypass 123456 "); */
       String r = " -genkeypair "
                + " -alias justatest6 "
                + " -keyalg RSA " + " -keysize 2048 "
                + " -dname C=BG,ST=OID:2.16.100.1.1.100006.1.2,CN=ytoteva.ad.tlogica.com-java-test"
                + " -keystore C:\\Users\\ytoteva\\Desktop\\justatest6.jks "
                + " -storepass 123456 "
                + " -keypass 123456 ";
       String[] result = Keytool.parse(" -genkeypair "
                + " -alias justatest5 "
                + " -keyalg RSA " + " -keysize 2048 "
                + " -dname C=BG,ST=OID:2.16.100.1.1.100006.1.2,CN=ytoteva.ad.tlogica.com-java-test"
                + " -keystore C:\\Users\\ytoteva\\Desktop\\justatest5.jks "
                + " -storepass 123456 "
                + " -keypass 123456 ");
       //Keytool.createCertificateRequest();
       //String[] data = Keytool.generateKeyPair("test2", "1:1:1", "test2", "C:\\Users\\ytoteva\\Desktop\\ClientCertificate", "123456", "123456");
       String[] data = new String[] {"C:\\Users\\ytoteva\\Desktop\\ClientCertificate\\ytoteva.ad.tlogica.com-java-test-exported.jks", "123456", "123456"};
       Keytool.list(data);
       //Keytool.executeCommand(r);
      /* for (String string : result) {
            
            System.out.println(string);
        }*/
       //Keytool.generateKeyPair();
    }
    
}
