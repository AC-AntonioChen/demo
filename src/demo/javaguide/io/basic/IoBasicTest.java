package demo.javaguide.io.basic;

import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author 16085
 */
public class IoBasicTest {

    public static final String TEST_FILE_PATH =
            "D:\\Code_demo\\leetcode\\leetcode\\src\\demo\\javaguide\\io\\basic\\input.txt";

    @Test
    public void starter() {
        inputStreamTest();
        bufferedInputStreamTest();
        dataInputStreamTest();
    }


    private void inputStreamTest() {
        System.out.println("\n----------[ " + Thread.currentThread().getStackTrace()[1].getMethodName() + " ]----------\n");

        try (InputStream fis = Files.newInputStream(
                Paths.get(TEST_FILE_PATH))) {
            System.out.println("Number of remaining bytes:" + fis.available());
            int content;
            long skip = fis.skip(2);
            System.out.println("The actual number of bytes skipped:" + skip);
            System.out.println("The content read from file:");
            while ((content = fis.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println();
        }
    }

    private void bufferedInputStreamTest() {
        // 新建一个 BufferedInputStream 对象
        System.out.println("\n----------[ " + Thread.currentThread().getStackTrace()[1].getMethodName() + " ]----------\n");
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(
                Files.newInputStream(Paths.get(TEST_FILE_PATH)))) {
            // 创建一个 ByteArrayOutputStream 对象来存储读取的字节
            ByteArrayOutputStream result = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = bufferedInputStream.read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }
            // 将字节转换为字符串
            System.out.println(result.toString("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void dataInputStreamTest() {
        System.out.println("\n----------[ " + Thread.currentThread().getStackTrace()[1].getMethodName() + " ]----------\n");

        try (DataOutputStream dos = new DataOutputStream(Files.newOutputStream(Paths.get("test.txt")))) {
            // 写入一个整数
            dos.writeInt(123);

            // 写入一个浮点数
            dos.writeFloat(45.67f);

            // 写入一个布尔值
            dos.writeBoolean(true);

            // 写入一个字符串
            dos.writeUTF("Hello, world!");
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (DataInputStream dis = new DataInputStream(Files.newInputStream(Paths.get("test.txt")))) {
            // 读取并打印一个整数
            int i = dis.readInt();
            System.out.println("Read Integer: " + i);

            // 读取并打印一个浮点数
            float f = dis.readFloat();
            System.out.println("Read Float: " + f);

            // 读取并打印一个布尔值
            boolean b = dis.readBoolean();
            System.out.println("Read Boolean: " + b);

            // 读取并打印一个字符串
            String str = dis.readUTF();
            System.out.println("Read String: " + str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
