import java.util.*;
import java.io.*;
import java.lang.*;


/*
for 1- n 1개 선택, 결과에 추가, 방문 여부 체크

recur(num+1)

백트랙킹은 10얹저리만 커버 가능(중복 가능 n^n, 중복 x n!)

*/
public class Main {
    public static int [] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visit = new boolean[n];
    
        dfs(n,m,0);
        
        System.out.println(sb);
        
    }

    public static void dfs(int n, int m, int depth){
        if(depth == m){
            for(int val : arr){
                sb.append(val).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < n; i++){
            if(!visit[i]){
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(n, m, depth + 1);
                visit[i] = false;
            }
        }
    }
}