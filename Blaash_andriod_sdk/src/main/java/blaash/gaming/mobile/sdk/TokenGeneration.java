package blaash.gaming.mobile.sdk;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.google.gson.Gson;

import org.apache.commons.codec.binary.Base64;

import java.nio.charset.StandardCharsets;
import java.security.Key;
//import java.util.Base64;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class TokenGeneration {
    private static final String TAG = "Events";
    private final String CLIENT_ID = BuildConfig.CLIENT_ID;
    private final String CLIENT_SECRET = BuildConfig.CLIENT_SECRET;
    private final String SALT = "abcd";
    private final Token token;
    static String INITIALIZATIO_VECTOR = "AODVNUASDNVVAOVF";

    @RequiresApi(api = Build.VERSION_CODES.O)
    public TokenGeneration(Token token) {
        this.token = token;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getTokenToSend() {
        Gson gson = new Gson();
        String plainToken = gson.toJson(token);
        Log.e(TAG, "getTokenToSend: Generated json = " + plainToken);

        String[] characters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
        Random random = new Random();
        int charLen = characters.length;
        StringBuilder alphaNumeric = new StringBuilder();
        for (int i = 0; i < 180; i++) {
            alphaNumeric.append(characters[random.nextInt(charLen)]);
        }
        return alphaNumeric + CLIENT_ID + encrypt(plainToken);
    }

    public String encrypt(String strToEncrypt)
    {
        try
        {
            byte[] key_Array = Base64.decodeBase64(CLIENT_ID);
//            Cipher _Cipher = Cipher.getInstance("AES");
            Cipher _Cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
//            Cipher _Cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");

            // Initialization vector.
            // It could be any value or generated using a random number generator.
            byte[] iv = { 1, 2, 3, 4, 5, 6, 6, 5, 4, 3, 2, 1, 7, 7, 7, 7 };
            IvParameterSpec ivspec = new IvParameterSpec(iv);

            Key SecretKey = new SecretKeySpec(key_Array, "AES");
            _Cipher.init(Cipher.ENCRYPT_MODE, SecretKey, ivspec);

            return Base64.encodeBase64String(_Cipher.doFinal(strToEncrypt.getBytes()));
        }
        catch (Exception e)
        {
            System.out.println("[Exception]:"+e.getMessage());
        }
        return null;
    }

//    @RequiresApi(api = Build.VERSION_CODES.O)
//    private String testAes(String s) {
////        String key = "aesEncryptionKey";
////        String IV = "0000000000000000";
//        byte[] IV = {0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0};
//        try
//        {
//            IvParameterSpec iv = new IvParameterSpec(IV);
//            byte[] temp = CLIENT_SECRET.getBytes(StandardCharsets.UTF_8);
//            SecretKeySpec skeySpec = new SecretKeySpec(temp, "AES-256");
//            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
//            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
//            byte[] encrypted = cipher.doFinal(s.getBytes());
//            return Base64.encodeBase64String(encrypted);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }

//    public static byte[] encrypt(String plainText, String encryptionKey) throws Exception {
//        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
//        SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), "AES");
//        cipher.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(INITIALIZATIO_VECTOR.getBytes("UTF-8")));
//        return cipher.doFinal(plainText.getBytes("UTF-8"));
//    }

//    @RequiresApi(api = Build.VERSION_CODES.O)
//    private String aes(String inputString,int mode) // mode = 0 for encryption & 1 for decryption
//    {
//        byte[] iv = {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0};
//        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
//        try
//        {
//            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
//            KeySpec keySpec = new PBEKeySpec(CLIENT_SECRET.toCharArray(),SALT.getBytes(),65536,256);
//            SecretKey temp = factory.generateSecret(keySpec);
//            SecretKeySpec secretKey = new SecretKeySpec(temp.getEncoded(), "AES");
//            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//            if(mode == 0)
//            {
//                cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
//                return Base64.getEncoder().encodeToString(cipher.doFinal(inputString.getBytes(StandardCharsets.UTF_8)));
//            } else if(mode == 1)
//            {
//                cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
//                return new String(cipher.doFinal(Base64.getDecoder().decode(inputString)));
//            } else
//            {
//                Log.e(TAG, "aesEncrypt: Invalid encryption mode");
//                return null;
//            }
//
//        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException | InvalidKeySpecException e)
//        {
//            Log.e(TAG, "aesEncrypt: Encryption failed");
//            System.out.println(e.getMessage());
//            return null;
//        }
//    }
}
