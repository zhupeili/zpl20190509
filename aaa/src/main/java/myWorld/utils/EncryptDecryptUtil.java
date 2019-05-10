package myWorld.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import java.io.*;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * Author: lfh
 * Version: 1.0
 * Date: 2017/2/26
 * Description: 加密、解密工具类
 * Function List:
 */
public class EncryptDecryptUtil {


    public static final int KEYSIZE = 1024;
    public static final String KEY_MD5 = "MD5";
    public static final String KEY_SHA256 = "SHA-256";
    public static final String KEY_SHA512 = "SHA-512";
    public static final String KEY_RSA = "RSA";
    public static final String KEY_AES = "AES";

    /**
     * BASE64Decoder 加密
     *
     * @param key
     * @return
     */
    public static String getBase64(String key) {
        String result = null;
        byte[] b = null;
        try {
            b = key.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (b != null) {
            result = (new BASE64Encoder()).encode(b);
        }
        return result;
    }

    /**
     * BASE64Decoder 解密
     *
     * @param key
     * @return
     */
    public static String getFromBase64(String key) {
        byte[] b = null;
        String result = null;
        if (key != null) {
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                b = decoder.decodeBuffer(key);
                result = new String(b, "UTF-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 字符串 SHA 加密
     *
     * @param strText
     * @param strType
     * @return
     */
    public static String SHA(final String strText, final String strType) {
        // 返回值
        String strResult = null;

        // 是否是有效字符串
        if (strText != null && strText.length() > 0) {
            try {
                // SHA 加密开始
                // 创建加密对象 并传入加密类型
                MessageDigest messageDigest = MessageDigest.getInstance(strType);
                // 传入要加密的字符串
                messageDigest.update(strText.getBytes());
                // 得到 byte 类型结果
                byte byteBuffer[] = messageDigest.digest();

                // 将 byte 转换为 string
                StringBuffer strHexString = new StringBuffer();
                // 遍历 byte buffer
                for (int i = 0; i < byteBuffer.length; i++) {
                    String hex = Integer.toHexString(0xff & byteBuffer[i]);
                    if (hex.length() == 1) {
                        strHexString.append('0');
                    }
                    strHexString.append(hex);
                }
                // 得到返回結果
                strResult = strHexString.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        return strResult;
    }

    /**
     * 生成秘钥对
     *
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator pairgen = KeyPairGenerator.getInstance(KEY_RSA);
        SecureRandom random = new SecureRandom();
        pairgen.initialize(KEYSIZE, random);
        KeyPair keyPair = pairgen.generateKeyPair();
        return keyPair;
    }

    /**
     * 加密
     *
     * @param publicKey
     * @param srcBytes
     * @return
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public static byte[] encrypt(RSAPublicKey publicKey, byte[] srcBytes) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        if (publicKey != null) {
            //Cipher负责完成加密或解密工作，基于RSA
            Cipher cipher = Cipher.getInstance(KEY_RSA);
            //根据公钥，对Cipher对象进行初始化
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] resultBytes = cipher.doFinal(srcBytes);
            return resultBytes;
        }
        return null;
    }

    /**
     * 解密
     *
     * @param privateKey
     * @param srcBytes
     * @return
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public static byte[] decrypt(RSAPrivateKey privateKey, byte[] srcBytes) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        if (privateKey != null) {
            //Cipher负责完成加密或解密工作，基于RSA
            Cipher cipher = Cipher.getInstance(KEY_RSA);
            //根据公钥，对Cipher对象进行初始化
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] resultBytes = cipher.doFinal(srcBytes);
            return resultBytes;
        }
        return null;
    }


    /**
     * AES对称加密,解密
     */
    public static class AES {

        private Key key;

        /**
         * 生成AES对称秘钥
         *
         * @throws NoSuchAlgorithmException
         */
        public void generateKey() throws NoSuchAlgorithmException {
            KeyGenerator keygen = KeyGenerator.getInstance(KEY_AES);
            SecureRandom random = new SecureRandom();
            keygen.init(random);
            this.key = keygen.generateKey();
        }


        /**
         * 加密
         *
         * @param in
         * @param out
         * @throws InvalidKeyException
         * @throws ShortBufferException
         * @throws IllegalBlockSizeException
         * @throws BadPaddingException
         * @throws NoSuchAlgorithmException
         * @throws NoSuchPaddingException
         * @throws IOException
         */
        public void encrypt(InputStream in, OutputStream out) throws InvalidKeyException, ShortBufferException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, IOException {
            this.crypt(in, out, Cipher.ENCRYPT_MODE);
        }

        /**
         * 解密
         *
         * @param in
         * @param out
         * @throws InvalidKeyException
         * @throws ShortBufferException
         * @throws IllegalBlockSizeException
         * @throws BadPaddingException
         * @throws NoSuchAlgorithmException
         * @throws NoSuchPaddingException
         * @throws IOException
         */
        public void decrypt(InputStream in, OutputStream out) throws InvalidKeyException, ShortBufferException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, IOException {
            this.crypt(in, out, Cipher.DECRYPT_MODE);
        }

        /**
         * 实际的加密解密过程
         *
         * @param in
         * @param out
         * @param mode
         * @throws IOException
         * @throws ShortBufferException
         * @throws IllegalBlockSizeException
         * @throws BadPaddingException
         * @throws NoSuchAlgorithmException
         * @throws NoSuchPaddingException
         * @throws InvalidKeyException
         */
        public void crypt(InputStream in, OutputStream out, int mode) throws IOException, ShortBufferException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
            Cipher cipher = Cipher.getInstance(KEY_AES);
            cipher.init(mode, this.key);

            int blockSize = cipher.getBlockSize();
            int outputSize = cipher.getOutputSize(blockSize);
            byte[] inBytes = new byte[blockSize];
            byte[] outBytes = new byte[outputSize];

            int inLength = 0;
            boolean more = true;
            while (more) {
                inLength = in.read(inBytes);
                if (inLength == blockSize) {
                    int outLength = cipher.update(inBytes, 0, blockSize, outBytes);
                    out.write(outBytes, 0, outLength);
                } else {
                    more = false;
                }
            }
            if (inLength > 0)
                outBytes = cipher.doFinal(inBytes, 0, inLength);
            else
                outBytes = cipher.doFinal();
            out.write(outBytes);
            out.flush();
        }

        public void setKey(Key key) {
            this.key = key;
        }

        public Key getKey() {
            return key;
        }

    }


    public static void main(String args[]) throws Exception {

        String test = new String("测试text_1234");
        System.out.println(test);
        System.out.println("MD5:" + SHA(test, KEY_MD5));
        System.out.println("SHA-256:" + SHA(test, KEY_SHA256));
        System.out.println("SHA-512:" + SHA(test, KEY_SHA512));
        System.out.println("getBASE64:" + getBase64(test));
        System.out.println("getFromBASE64:" + getFromBase64(getBase64(test)));

        EncryptDecryptUtil.AES aes = new EncryptDecryptUtil.AES();
        aes.generateKey();
        File file = new File("C:/asmis/bak/temp/pri.key");
        FileInputStream in = new FileInputStream(file);
        File file1 = new File("C:/asmis/bak/temp/pub.key");
        FileOutputStream out = new FileOutputStream(file1);
        aes.encrypt(in, out);
        aes.decrypt(in, out);

        KeyPair keyPair = generateKeyPair();
        //用公钥加密
        byte[] srcBytes = test.getBytes();
        byte[] resultBytes = encrypt((RSAPublicKey) keyPair.getPublic(), srcBytes);
        //用私钥解密
        byte[] decBytes = decrypt((RSAPrivateKey) keyPair.getPrivate(), resultBytes);
        System.out.println("原文: " + test);
        System.out.println("加密: " + new String(resultBytes));
        System.out.println("解密: " + new String(decBytes));
    }
}  
