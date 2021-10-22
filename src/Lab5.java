import java.io.*;
import java.util.Scanner;

public class Lab5 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        DataOutputStream dout = null;
        DataInputStream din = null;
        DataOutputStream dout2 = null;
        DataInputStream din2 = null;
        try {
            File f1 = new File("src.txt");
            if (f1.exists()) f1.delete();
            f1.createNewFile();
            dout = new DataOutputStream(new FileOutputStream(f1));
            for (int i = 0; i < 20; i++) {
                int a = sc.nextInt();
                dout.writeInt(i);
            }
            File f2 = new File("result.txt");
            if (f2.exists()) f2.delete();
            f2.createNewFile();
            dout2 = new DataOutputStream(new FileOutputStream(f2));
            din = new DataInputStream(new FileInputStream(f1));

            int n = 0;
            for (int i = 0; i < 20; i++) {
                int a = din.readInt();
                if (a % 2 == 1) {
                    dout2.writeInt(a);
                    n++;
                }
            }
            if (n != 0) {
                din2 = new DataInputStream(new FileInputStream(f2));
                for (int i = 0; i < n; i++) {
                    System.out.println(din2.readInt());
                }
            }
            else {
                throw new RuntimeException("Нечётные числа отсутствуют");
            }

        }
        catch (IOException io) {
            io.printStackTrace();
        }
        catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }
        finally {
            dout.flush();
            dout.close();
            dout2.flush();
            dout2.close();
            din.close();
            din2.close();
        }
    }
}
