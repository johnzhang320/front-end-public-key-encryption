package com.front.end.pk.encrypt.demo.fepke_api;
/**
 *  Singleton ensure keyPair only be created one time
 */
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import java.security.KeyPair;
@Slf4j
@Data
public class KeyPairManager {
	private static KeyPairManager handler=null;
	private KeyPair keyPair=null; 
	private String keyString=null;
	JCryptionUtil jCryptionUtil =null;
	public synchronized static KeyPairManager getInstance() {
		if (null==handler) {
		    handler = new KeyPairManager();
		}
		return handler;
	}
	 /**
	  *  KeyPair structure: {e,n} is public key , {d,n} is private key, 
	  *  md=(p-1) x (q-1) , n=p x q, p and q must be prime number 
	  */
			
	private KeyPairManager() {
		try {
			 jCryptionUtil = new JCryptionUtil();  	       
			 keyPair = jCryptionUtil.generateKeypair();  
			 StringBuffer output = new StringBuffer();  
			 String e = jCryptionUtil.getPublicKeyExponent(keyPair);  
			 String n = jCryptionUtil.getPublicKeyModulus(keyPair);  
			 String md = String.valueOf(jCryptionUtil.getMaxDigits());  		
			 output.append("{\"e\":\"");  
			 output.append(e);  
			 output.append("\",\"n\":\"");  
			 output.append(n);  
			 output.append("\",\"maxdigits\":\"");  
			 output.append(md);  
			 output.append("\"}");  
			 output.toString();  
			 keyString = output.toString().replaceAll("\r", "")
					                    .replaceAll("\n", "").trim();
		} catch (Exception e) {
			log.info("Generate Key Failed because of "+e.getMessage());
		}
	}

	public String decrypt(String encrypted) {
		String retVal = null;
		log.debug("encrypted String="+encrypted+"\n keyPair="+keyPair);
		try {
			retVal = jCryptionUtil.decrypt(encrypted, keyPair);
		} catch (Exception e) {
			log.info("Descryption Failed because of "+e.getMessage());
		}
		return retVal;
	}
}
