import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = {};
        answer = new int[targets.length];
        for(int i = 0; i < targets.length; i++){
            for(int k=0; k < targets[i].length(); k++){
                for(int j = 0; j < keymap.length; j++){
                    for(int l = 0; l < keymap[j].length(); l++){
                        if(targets[i].charAt(k) == keymap[j].charAt(l)){
                            answer[i] += l+1;
                            break;
                        }
                    }
                }
            }
            if(answer[i] == 0){
                answer[i] = -1;
            }
        }
        return answer;
    }
}