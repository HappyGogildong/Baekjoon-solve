import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        for (int i = 1; i <= x; i++) {
            int j;
            j = x-i;
            for(int k = 1; k <= j; k++) {
                System.out.print(" ");
            }
            for(int y = 1; y <= i; y++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}