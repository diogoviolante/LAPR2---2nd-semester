package app.domain.model;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;

public class BruteForce {
    public BruteForce(){

    }

    public int[] maxSubArray(int[] nums) {
        StopWatch oleole=new StopWatch();
        oleole.start();
        int n = nums.length;
        int sum = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {

            int runningWindowSum = 0;

            for (int j = i; j < n; j++) {
                runningWindowSum += nums[j];

                if (runningWindowSum > sum) {
                    sum = runningWindowSum;
                    start = i;
                    end = j+1;
                }
            }
        }
        oleole.stop();
        System.out.println(oleole.getNanoTime());
        return Arrays.copyOfRange(nums,start, end);
    }
}
