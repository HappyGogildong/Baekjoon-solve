import java.util.*;
import java.io.*;


//아이디어
/*2중 for문 (값1 & 방문X => BFS)
* BFS 돌면서 그림 개수 +1, 최대값 갱신*/
//시간복잡도
/*V : 500 * 500 */
//자료구조
/*그래프 전체 : int[][]
* 방문 bool[][]
* queue*/
public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map; //입력받은 그림
    static boolean[][] visit; // 방문 여부 저장용 boolean 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //행 수
        int m = Integer.parseInt(st.nextToken()); //열 수
        Queue<int[]> q = new LinkedList<>();

        map = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0; //그림의 최대 크기
        int num = 0; //그림의 갯수

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 0 || visit[i][j]) continue;
                num++;
                visit[i][j] = true;
                q.offer(new int[]{i, j});
                int area = 0;
                while(!q.isEmpty()){
                    area++;
                    int[] coordinate = q.poll();
                    int x = coordinate[0];
                    int y = coordinate[1];

                    for (int dir = 0; dir < 4; dir++){
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];
                        if(nx < 0 || ny <0 || nx >= n || ny >= m) continue;
                        if(visit[nx][ny] || map[nx][ny] != 1) continue;
                        visit[nx][ny] = true;
                        q.offer(new int[] {nx, ny});
                    }
                }
                max = Math.max(max, area);
            }
        }
        System.out.println(num);
        System.out.println(max);

    }
}