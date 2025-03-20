import java.util.*;
import java.io.*;
import java.lang.*;


/*아이디어
*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int res = 0;
        int time[] = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i =0; i< num; i++){
            time[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time);

        for(int i = 0 ; i < num; i++){
            res += time[i] * (num-i);
        }

        System.out.println(res);
    }
}