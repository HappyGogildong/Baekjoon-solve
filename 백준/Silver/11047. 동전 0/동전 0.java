import java.util.*;
import java.io.*;
import java.lang.*;


/*아이디어
*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int res = 0;

        StringTokenizer st  = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int coins[] = new int[n];

       
        for(int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (coins[i] <= k) {
                k -= coins[i];
                count++;
                i++;
            }
        }

        res = count;




        System.out.println(res);
    }
}

