import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int[] nums) {
        int l = nums.length/2;
        
        List<Integer> newnums = new ArrayList<>();
        
        // 중복값 제거
        for(int n : nums) {
            if(!newnums.contains(n)) {
                newnums.add(n);
            }
        }
        
        return Math.min(l, newnums.size());
    }
}