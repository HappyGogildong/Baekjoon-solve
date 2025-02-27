import java.util.*;
import java.io.*;


/*아이디어
메모이제이션 활용
4를 합으로 나타내는 방법은
3을 합으로 나타낸 경우 +1
2를 합으로 나타낸 경우 +2
1을 합으로 나타낸 경우 +3
씩 하면 되므로 1,2,3의 경우를 모두 더한 것과 같다.
일반화하면 점화식 도출 가능
*/
public class Main {
    static int []memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        memo = new int[12];
        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 4;
        
        for(int i = 4; i<=11; i++){
            memo[i] = memo[i-1] + memo[i-2] + memo[i-3];
        }
        
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            
            System.out.println(memo[a]);
        }



    }
}
