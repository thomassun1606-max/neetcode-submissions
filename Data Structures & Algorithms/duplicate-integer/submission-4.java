class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])==false) {
                map.put(nums[i], 1);
            } else {
                return true;
            }
        }
        return false;
    }
}