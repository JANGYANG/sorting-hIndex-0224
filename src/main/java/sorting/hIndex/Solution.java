package sorting.hIndex;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution{

    public int solution(int[] citations) {
        int answer = 0;

        List<Integer> cList = Arrays.stream(citations).boxed().collect(Collectors.toList());

        cList.sort(Comparator.naturalOrder());

        System.out.println(cList);


        for(int i = 1; i <= cList.size(); i++){
            int counter = 0;
            for(int j = 0; j < cList.size(); j++){
                if(cList.get(j) >= i){
                    if(++counter >= i){
                        answer = i;
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
        return answer;
    }

}
/* 다른사람의 답안
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int max = 0;
        for(int i = citations.length-1; i > -1; i--){
            int min = (int)Math.min(citations[i], citations.length - i);
            if(max < min) max = min;
        }

        return max;
    }
}
*/