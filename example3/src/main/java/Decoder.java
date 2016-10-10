import org.apache.commons.codec.binary.Base64;
import org.apache.commons.compress.compressors.xz.XZCompressorInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Decoder {

    public static void main(String[] args) throws IOException {
    	    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter String: ");
        String s = br.readLine();
        
    	byte[] valueDecoded = Base64.decodeBase64(s.getBytes());
    	
    	ByteArrayInputStream bIn = new ByteArrayInputStream(valueDecoded);
        XZCompressorInputStream xzIn = new XZCompressorInputStream(bIn);

        byte [] result=new byte[valueDecoded.length];
        xzIn.read(result);
        
    	System.out.println((new String(result)).trim());
    	
    	xzIn.close();
    }
}