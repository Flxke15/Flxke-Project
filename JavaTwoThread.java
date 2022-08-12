import java.io.*;

public class JavaTwoThread implements Runnable {
    int x;
    int y;
    int sum = 0;

    public JavaTwoThread(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void run() {
        for (int i = x; i <= y; i++) {
            sum += i;
        }
    }

    public int getSum() {
        return sum;
    }

    public static void main(String[] args) {
        int result = 0;
        JavaTwoThread s1 = new JavaTwoThread(1, 10000);
        JavaTwoThread s2 = new JavaTwoThread(10001, 20000);
        Thread t1 = new Thread(s1);
        Thread t2 = new Thread(s2);
        try {
            t1.start();
            Thread.sleep(5000);
            t2.start();
            Thread.sleep(10000);
            t1.join();
            t2.join();
            result = s1.getSum() + s2.getSum();
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println(result);
    }

}
