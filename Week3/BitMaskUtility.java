import java.util.Scanner;
 
public class BitMaskUtility {
  static boolean isBitSet(int number, int position) {
        return (number & (1 << position)) != 0;
    }
  static boolean isBitSet(int number, int position) {
        return (number & (1 << position)) != 0;
    }
  static int clearBit(int number, int position) {
        return number & ~(1 << position);
    }
  static int toggleBit(int number, int position) {
        return number ^ (1 << position);
    }
  static String toBinary32(int number) {
        StringBuilder sb = new StringBuilder(32);
        for (int i = 31; i >= 0; i--) {
            sb.append(isBitSet(number, i) ? '1' : '0');
        }
        return sb.toString();
    }
  private static boolean isValidPosition(int position) {
        return position >= 0 && position <= 31;
    }
  
}
