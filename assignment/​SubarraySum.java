import java.util.HashMap;

public static int subarraySum(int[] nums, int k) {
    int count = 0;
    int prefixSum = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    
    // Base case: prefix sum of 0 appears once before starting
    map.put(0, 1);
    
    for (int num : nums) {
        prefixSum += num;
        
        if (map.containsKey(prefixSum - k)) {
            count += map.get(prefixSum - k);
        }
        
        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
    }
    
    return count;
}