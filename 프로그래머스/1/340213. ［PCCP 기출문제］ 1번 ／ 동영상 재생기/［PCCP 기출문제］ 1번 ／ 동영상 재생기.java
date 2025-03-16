class Solution{
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands){
        String answer = "";

        int POS = timeToInt(pos);
        int OPS = timeToInt(op_start);
        int OPE = timeToInt(op_end);
        int VDL = timeToInt(video_len);

        if(POS <= OPE && POS >= OPS){
            POS = OPE;
        }

        for (int i = 0; i < commands.length; i++){
            if(POS <= OPE && POS >= OPS){
                POS = OPE;
            }
            if(commands[i].equals("next")){
                {
                    POS = next(POS,VDL);
                }
            }
            else if(commands[i].equals("prev")){
                POS = prev(POS,VDL);
            }
        }

        if(POS <= OPE && POS >= OPS){
            POS = OPE;
        }

        answer = intToTime(POS);

        return answer;
    }

    private int next(int pos, int video_len){
        pos += 10;
        if(pos > video_len){
            pos = video_len;
        }
        return pos;
    }
    private int prev(int pos, int video_len){
        pos -= 10;
        if(pos < 0){
            pos = 0;
        }
        return pos;
    }
    private int timeToInt(String time){
        String[] split = time.split(":");
        int intTime = Integer.parseInt(split[0])*60 + Integer.parseInt(split[1]);
        return intTime;
    }
    private String intToTime(int time){
        int m = time/60;
        int s = time%60;

        return String.format("%02d:%02d",m,s);
    }
}