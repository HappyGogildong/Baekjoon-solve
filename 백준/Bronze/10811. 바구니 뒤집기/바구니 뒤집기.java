import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int lengthOfArr = Integer.parseInt(st.nextToken());
        int flipCount = Integer.parseInt(st.nextToken());

        int[] arr = new int[lengthOfArr];

        for(int i = 0; i < lengthOfArr; i++){
            arr[i] = i + 1;
        }
        for (int i = 0; i < flipCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;

            while(start < end){
                int temp = arr[start];
                arr[start++] = arr[end];
                arr[end--] = temp;
            }
        }
        for(int i = 0; i < lengthOfArr; i++){
            System.out.print(arr[i] + " ");
        }
        br.close();
    }
}
