package Utility;

import org.jasypt.util.text.BasicTextEncryptor;

import java.time.Duration;

public class Util{


    static BasicTextEncryptor encryptor= new BasicTextEncryptor();




    public static String decrypytText(String stringToBeDecrypted){
        encryptor.setPasswordCharArray("PWD".toCharArray());
       return encryptor.decrypt(stringToBeDecrypted);
    }
}
