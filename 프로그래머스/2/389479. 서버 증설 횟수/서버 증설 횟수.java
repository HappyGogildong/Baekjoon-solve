import java.util.*;
import java.io.*;
import java.lang.*;

//현재 수용량 변수 : 현재 서버 수 * m
//현재 서버 수 : 이전 시간 서버 수 + 현재 증가 서버 - K 시간 전 서버 수(index는 k-1). players와 같은 크기 배열 선언 후 관리.
//증설 횟수 : 증가 시킨 서버 수 중첩
//players 순회 -> if 수용량 딸림, 현재 서버수 +, 증설 횟수+
class Solution {
    public int solution(int[] players, int m, int k) {
        
        int answer = 0;
        int currentServer[] = new int [players.length + k];
       
        for (int i = 0; i < 24; i++){
            currentServer[i] = 0;
        }
        
        for(int i = 0; i < players.length; i++){
            int currentCapacity = (currentServer[i] * m) -1 + m;
            if (players[i] > currentCapacity){
                for(int j = 0; j<k; j++){
                    currentServer[i+j] += (int)Math.ceil((float)(players[i] - currentCapacity) / (float)m);
                }
                answer += (int)Math.ceil((float)(players[i] - currentCapacity) / (float)m);
            }
        }
        
        
        return answer;
    }
}