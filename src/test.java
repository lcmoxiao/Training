import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;

public class test {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> clazz = Class.forName("java.math.BigInteger");
        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(long.class);
        declaredConstructor.setAccessible(true);
        BigInteger bigInteger = (BigInteger) declaredConstructor.newInstance(1024);
        Method m = clazz.getDeclaredMethod("toString", BigInteger.class, StringBuilder.class, int.class, int.class);
        m.setAccessible(true);
        StringBuilder sb = new StringBuilder();
        System.out.println(m.invoke(null, bigInteger, sb, 2, 32));
        System.out.println(sb.toString());
    }

    public class Solution {
        /**
         * @param s: string S
         * @param t: string T
         * @return: whether S can convert to T
         */
        public boolean canConvert(String s, String t) {
            if (s == null | t == null) return false;
            if (s.length() < t.length()) return false;
            int mark = 0;
            for (int i = 0; i < t.length(); i++) {
                char tmp = t.charAt(i);
                for (; mark < s.length(); mark++) {
                    if (tmp == s.charAt(mark)) {
                        mark++;
                        if (i == t.length() - 1) return true;
                        break;
                    }
                    if (s.length() - mark < t.length() - i) return false;
                }
            }
            return false;
        }

        public int maxNonNegativeSubArray(int[] A) {
            // write your code here
            int result = -1;
            int count = -1;
            for (int value : A) {
                if (value >= 0) {
                    if (count == -1) count = 0;
                    count += value;
                } else {
                    result = Math.max(result, count);
                    count = -1;
                }
            }
            result = Math.max(result, count);
            return result;
        }

    }


}
