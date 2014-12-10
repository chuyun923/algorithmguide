/**
 * Created by pengliang on 14-12-10.
 */
public class Utils {
    public static void printIntArray(int[] array) {
        int count = 0;
        for(int value : array) {
            if(++count > 10) {
                System.out.println();
                count = 1;
            }
            System.out.print("  "+value);
        }
    }
}
