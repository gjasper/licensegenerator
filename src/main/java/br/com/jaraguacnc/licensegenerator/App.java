package br.com.jaraguacnc.licensegenerator;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	
    	String data = "~~~~~~~~";
    	byte[] cdata = data.getBytes();
    	String key = "abcdefghijklmnopqrstuvwxyz";
    	byte[] ckey = key.getBytes();
        System.out.println( encode(cdata, ckey).toString() );
        System.out.println( encode(encode(cdata, ckey),ckey).toString() );
    }
    
    public static byte[] rawByteToPrintableAscii(byte[] data){
    	byte[] outputData = new byte[data.length];
    	for (int i = 0; i < data.length; i++) {
    		outputData[i] = (byte) (data[i]+33); 
		}
    	return outputData;
    }
    
    public static byte[] printableAsciiToRawByte(byte[] data){
    	byte[] outputData = new byte[data.length];
    	for (int i = 0; i < data.length; i++) {
    		outputData[i] = (byte) (data[i]-33); 
		}
    	return outputData;
    }
    
    public static byte[] encode(byte[] data, byte[] key) throws Exception{
    	byte[] ciphedData = new byte[data.length];
    	for (int i = 0; i < data.length; i++) {
    		ciphedData[i] = (byte) (data[i]^key[i]); 
		}
    	return ciphedData;
    }
}
