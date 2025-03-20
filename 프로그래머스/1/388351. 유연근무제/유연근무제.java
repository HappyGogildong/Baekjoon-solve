import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        int gift[] = new int[schedules.length];
        for (int i = 0; i < gift.length; i++){
            gift[i] = 1;
        }
        
        int t [] = new int [schedules.length];
        for(int i = 0 ; i < schedules.length; i++){
            int m = schedules[i] % 100;
            int nT = schedules[i] + 10;
            if(nT %  100 >= 60){
                nT += 40;
            }
            t[i] = nT;
        }
        
        for(int i = 0; i < timelogs.length; i++){
            for(int j = 0; j < 7; j++){
                //주말
                if((startday + j)%7 == 6 | (startday + j)%7 == 0){
                    continue;
                }
                else{
                    if(t[i] < timelogs[i][j]){
                        gift[i] = 0;
                    }
                }
            }
        }
        
        for(int i = 0; i < gift.length; i++){
            answer += gift[i];
        }  
        
        return answer;
    }
}