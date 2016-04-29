import java.io.*;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.compress.compressors.xz.XZCompressorInputStream;

import java.io.IOException;

/**
 * Created by Евгений on 28.04.2016.
 */
public class Decoder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter String: ");
        String str = br.readLine();
        byte a[] = Base64.decodeBase64(str);
        byte buf[] = new byte[1024];
        ByteArrayInputStream bin = new ByteArrayInputStream(a);
        XZCompressorInputStream xzIn = new XZCompressorInputStream(bin);
        xzIn.read(buf);
        System.out.println(new String(buf));

    }
}
