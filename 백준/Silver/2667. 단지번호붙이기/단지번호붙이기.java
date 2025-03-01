import java.util.*;
import java.io.*;
import java.lang.*;


/*아이디어

*/
public class Main {
    static int[][] map;
    static boolean[][] visit;
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};
    static LinkedList<Integer> rs;
    static int each;
    static int n;

    public static void dfs(int y, int x, int n) {
        visit[y][x] = true;

        for (int k = 0; k < 4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];

            if (0 <= ny && ny < n && 0 <= nx && nx < n) {
                if (map[ny][nx] == 1 && !visit[ny][nx]) {
                    each++;
                    dfs(ny, nx, n);
                }
            }
        }
    }
        public static void main (String[]args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //StringTokenizer st = new StringTokenizer(br.readLine());

            each = 0;
            n = Integer.parseInt(br.readLine());
            rs = new LinkedList<>();
            map = new int[n][n];
            visit = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                for (int j = 0; j < n; j++) {
                    map[i][j] = s.charAt(j) -'0';
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1 && !visit[i][j]) {
                        visit[i][j] = true;  //visit check
                        each = 1;
                        dfs(i, j, n); //DFS
                        rs.add(each);

                    }
                }
            }
            Collections.sort(rs);
            System.out.println(rs.size());
            for (int i = 0; i < rs.size(); i++) {
                System.out.println(rs.get(i));
            }
        }
    }
