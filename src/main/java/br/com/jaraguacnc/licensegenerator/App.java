package br.com.jaraguacnc.licensegenerator;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.codec.binary.Hex;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	
    	String data = "tchaikovskymozartbtv";
    	byte[] cdata = data.getBytes();
    	String key = "abcdefghijklmnopqrstuvwxyz";
    	byte[] ckey = key.getBytes();
        Files.write(Paths.get("C:\\Users\\GHJ\\Desktop\\mach3license.jrg"), Hex.encodeHexString(encode(cdata, ckey)).getBytes());
    }
       
    public static byte[] encode(byte[] data, byte[] key) throws Exception{
    	byte[] ciphedData = new byte[data.length];
    	for (int i = 0; i < data.length; i++) {
    		ciphedData[i] = (byte) (data[i]^key[i]); 
		}
    	return ciphedData;
    }
}
