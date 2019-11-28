import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @author JiYunfei
 * @date 2019-07-02
 */
public class TestScanPassword {
//    public static void main(String[] args) throws NoSuchAlgorithmException {
//        MessageDigest md5 = MessageDigest.getInstance("MD5");
//        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
//        String str = String.format("%s:%s", "femoo.amigo.bjmcc.net", "8eaf1b54d77928666207e32b9046972b");
//        byte[] tmp = new byte[28];
//        copy(tmp, longToByte(42224), 0, 8);
//        System.out.println(Arrays.toString(str.getBytes(Charset.forName("UTF-8"))));
//        sha1.update(str.getBytes(Charset.forName("UTF-8")));
//        byte[] digest1 = sha1.digest();
//        System.out.println(Arrays.toString(digest1));
//        copy(tmp, digest1, 8, 28);
//        System.out.println(Arrays.toString(tmp));
//        sha1.update(tmp);
//        byte[] digest = sha1.digest();
//        // 服务端计算出来的，redis存的value还需要md5
//        System.out.println(Arrays.toString(digest));
//
//        // 解析端上带上来的鉴权头
//        System.out.println(Arrays.toString(fromHexString("27cbc37259e23c696dc4ade3369221ea62d2e288")));//pc端上是一-2147483648L为uid算出来的
//    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
        String str = String.format("%s:%s", "femoo.amigo.bjmcc.net", "8eaf1b54d77928666207e32b9046972b");
        byte[] tmp = new byte[28];
        copy(tmp, longToByte(42224), 0, 8);
        sha1.update(str.getBytes(Charset.forName("UTF-8")));
        copy(tmp, sha1.digest(), 8, 28);
        sha1.update(tmp);
        byte[] digest = sha1.digest();
        // 服务端计算出来的，redis存的value还需要md5
        System.out.println(Arrays.toString(digest));

        // 解析端上带上来的鉴权头
        System.out.println(Arrays.toString(fromHexString("f881aea4ea0b990aa959e554a8f0a815d8e5e36f")));//pc端上是一-2147483648L为uid算出来的
        byte[] bytes =  new byte[]{39, -53, -61, 114, 89, -30, 60, 105, 109, -60, -83, -29, 54, -110, 33, -22, 98, -46, -30, -120};
        System.out.println(bytes2HexString(digest).toLowerCase());
    }

    /**
     * 把16进制数字字符串转化成为byte数组
     *
     * @param hex
     * @return byte[]
     */
    public static byte[] fromHexString(String hex) {
        if (hex == null || hex.length() < 1)
            return new byte[0];

        int len = hex.length() / 2;
        byte[] result = new byte[len];
        len *= 2;

        for (int index = 0; index < len; index++) {
            String s = hex.substring(index, index + 2);
            int b = Integer.parseInt(s, 16);
            result[index / 2] = (byte) b;
            index++;
        }
        return result;
    }

    public static String toHexString(byte[] bytes) {
        StringBuffer stringBuffer =  new StringBuffer();

        for (byte aByte : bytes) {
            int aByte1 = aByte;
            String s = intToHex(aByte1);
            stringBuffer.append(s);
        }
        return stringBuffer.toString();
    }


    /**
     * 字节数组转换成字符串HEX表示
     *
     * @param data 字节数组
     * @return 字节数组的HEX字符串表示
     */
    public static String bytes2HexString(byte[] data) {
        if (data == null) {
            throw new NullPointerException();
        }

        StringBuilder buffer = new StringBuilder();
        for (byte b : data) {
            String hex = Integer.toHexString(b & 0xff);//为啥呢1 ？？
            if (hex.length() == 1) {
                buffer.append('0');//为啥呢2 ？？
            }
            buffer.append(hex);
        }
        return buffer.toString().toUpperCase();
    }

    private static String intToHex(int n) {
        StringBuffer s = new StringBuffer();
        String a;
        char []b = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(n != 0){
            s = s.append(b[n%16]);
            n = n/16;
        }
        a = s.reverse().toString();
        return a;
    }

    /**
     * long to byte[]
     *
     * @param longValue
     * @return
     */
    public static byte[] longToByte(long longValue) {
        long temp = longValue;
        byte[] b = new byte[8];
        for (int i = 0; i < b.length; i++) {
            b[i] = new Long(temp & 0xff).byteValue();
            temp = temp >> 8; // 向右移8位
        }
        return b;
    }

    /**
     * copy array to other arrsy
     * @param desc
     * @param src
     * @param from
     * @param to
     */
    public static void copy(byte[] desc, byte[] src, int from, int to) {
        for (int i = from, j = 0; i < to; i++, j++) {
            desc[i] = src[j];
        }
    }
}