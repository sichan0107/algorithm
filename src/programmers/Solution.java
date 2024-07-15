package programmers;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public static int solution(int[] nums) {
        int answer = 0;
        int max = nums.length / 2;

        Set<Integer> numSet = new HashSet<>();
        for(int i: nums){
            numSet.add(i);
        }

        if(max >= numSet.size() ){
            answer = numSet.size();
        }else{
            answer = max;
        }
        return answer;
    }

    public static int solutionStream(int[] nums) {
        int max = nums.length / 2;
        return Arrays.stream(nums).boxed()
                .collect(Collectors.collectingAndThen(
                        Collectors.toCollection(HashSet::new), phoneketmon -> Integer.min(max, phoneketmon.size())));

    }

    public static void main(String[] args) throws IOException {
        int[] nums1 = {3,1,2,3}; // return=2 123
        int[] nums2 = {3,3,3,2,2,4}; // return=3 234
        int[] nums3 = {3,3,3,2,2,2}; // return=2

        //System.out.println(solution(nums1));
        //System.out.println(solution(nums2));
        //System.out.println(solution(nums3));

        System.out.println(solutionStream(nums1));
        System.out.println(solutionStream(nums2));
        System.out.println(solutionStream(nums3));
    }
}
