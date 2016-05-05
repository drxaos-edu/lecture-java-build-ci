import org.apache.commons.codec.binary.Base64;
import org.apache.commons.compress.compressors.xz.XZCompressorInputStream;

import java.io.*;

public class Decoder{
    public static <XZCompressorInputStream> void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter String: ");
        String s = br.readLine();
        byte[] buf = new byte[100];

        ByteArrayInputStream bin = new ByteArrayInputStream(Base64.decodeBase64(s));
        XZCompressorInputStream xzIn = new XZCompressorInputStream(bin);
        xzIn.read(buf);
        xzIn.close();

        String result = new String(buf);
        System.out.println(result);
    }
}
