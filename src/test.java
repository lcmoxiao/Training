import java.util.HashMap;
import java.util.List;

public class test {

    public static void main(String[] args) {

    }

    public class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public class Solution {
        /*
         * @param nums: a list of integers
         * @return: find a  majority number
         */
        public int majorityNumber(List<Integer> nums) {
            int length = nums.size();
            HashMap<Integer, Integer> hm = new HashMap<>();
            for (Integer num : nums) {
                if (hm.containsKey(num)) {
                    int i = hm.get(num) + 1;
                    if (i > length / 2) return num;
                    hm.put(num, hm.get(num) + 1);
                } else hm.put(num, 1);
            }
            return 0;
        }
    }

}

