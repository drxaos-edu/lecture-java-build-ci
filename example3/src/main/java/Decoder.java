import org.apache.commons.codec.binary.Base64;
import org.apache.commons.compress.compressors.xz.XZCompressorInputStream;
import org.apache.commons.compress.compressors.xz.XZCompressorOutputStream;

import java.io.*;

public class Decoder {

/*
Enter String: *****
/Td6WFoAAATm1rRGAgAhARYAAAB0L+WjAQBEQXBhY2hlIE1hdmVuIGlzIGEgc29mdHdhcmUgcHJvamVjdCBtYW5hZ2VtZW50IGFuZCBjb21wcmVoZW5zaW9uIHRvb2wuAAAAAMXaU7TVffeMAAFdRS0jJSkftvN9AQAAAAAEWVo=
*/

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