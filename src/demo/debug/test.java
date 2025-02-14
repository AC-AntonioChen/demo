package demo.debug;

public class test {
    public static void main(String[] args) {
        System.out.println(getResult());
    }

    private static int getResult() {
        try {
            System.out.println("Try to do something");
            throw new RuntimeException("RuntimeException");
        } catch (Exception e) {
            System.out.println("Catch Exception -> " + e.getMessage());
            // 终止当前正在运行的Java虚拟机
            System.exit(1);
        } finally {
            System.out.println("Finally");
        }
        return 0;
    }
}
