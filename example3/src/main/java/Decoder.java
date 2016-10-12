import org.apache.commons.codec.binary.Base64;
import org.apache.commons.compress.compressors.xz.XZCompressorInputStream;

import java.io.*;

public class Decoder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter String: ");
        String s = br.readLine();

        byte[] ans = Base64.decodeBase64(s.getBytes());
        ByteArrayInputStream bIn = new ByteArrayInputStream(ans);
        XZCompressorInputStream xzIn = new XZCompressorInputStream(bIn);
        ans = new byte[ans.length];
        xzIn.read(ans);
        xzIn.close();

        System.out.println((new String(ans)).trim());
    }
}
