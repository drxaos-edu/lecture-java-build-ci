import org.apache.commons.codec.binary.Base64;
import org.apache.commons.compress.compressors.xz.XZCompressorInputStream;

import java.io.*;

public class Decoder {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter encodedString: ");
        String s = br.readLine();

        byte[] encodedString = Base64.decodeBase64(s);
        byte[] result = new byte[1024];

        ByteArrayInputStream inputStream = new ByteArrayInputStream(encodedString);

        XZCompressorInputStream xzIn = new XZCompressorInputStream(inputStream);

        xzIn.read(result);
        xzIn.close();

        System.out.println(new String(encodedString));
    }
}
