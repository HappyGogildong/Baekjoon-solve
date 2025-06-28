import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.readLine();
        int sum = 0;
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < n-1; i++) {
            String t = br.readLine();
            if(t.equals("ENTER")){
                sum += map.size();
                map.clear();
                continue;
            }
            map.putIfAbsent(t, 1);
        }
        System.out.println(sum + map.size());
    }
}