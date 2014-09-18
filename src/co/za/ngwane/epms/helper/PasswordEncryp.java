package co.za.ngwane.epms.helper;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;

public final class PasswordEncryp {
	public synchronized String encrypt(String plaintext,
            String algorithm, String encoding) throws Exception {
        MessageDigest msgDigest = null;
        String hashValue = null;
        try {
            msgDigest = MessageDigest.getInstance(algorithm);
            msgDigest.update(plaintext.getBytes(encoding));
            byte rawByte[] = msgDigest.digest();
            hashValue = (new BASE64Encoder()).encode(rawByte);
            System.out.println("Thy hash value is : "+hashValue);
 
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No Such Algorithm Exists");
        } catch (UnsupportedEncodingException e) {
            System.out.println("The Encoding Is Not Supported");
        }
        return hashValue;
        //System.out.println("PlainText\tAlgo\tEncoding\tEncrypted Password");
//      
//      System.out.println(plainPassword + "\tSHA\tUTF-8\t" + encrypt("MySecretPassword", "SHA", "UTF-8"));
//      System.out.println(plainPassword + "\tSHA-1\tUTF-16\t"
//              + encrypt("MySecretPassword", "SHA-1", "UTF-16"));
//      
      //NTww5tlUgMTDg+M8LOXelA==
     // System.out.println(plainPassword + "\tMD5\tUTF-8\t"+ encrypt(plainPassword, "MD5", "UTF-8"));
      
      //System.out.println(plainPassword + "\tMD5\tUTF-16\t"+ encrypt(plainPassword, "MD5", "UTF-16"));
    }
	
	public static void main (String[] arg)
	{
		PasswordEncryp encryp = new PasswordEncryp();
		try
		{
			System.out.println(encryp.encrypt("p@ssw0rd", Status.ALGORITHM, Status.ENCODING));
			
		} catch (Exception e)
		{
			// TODO: handle exception
		}
	}
 
}
