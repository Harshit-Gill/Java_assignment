public class LinearSearchToolkit {
    static boolean contains(int[] arr, int target){
        for(int i = 0; i <= arr.length ; i++){
            if(arr[i] == target){
                return true;
            }
        }
        return false;
    }
    static int firstIndexOf(int[] values, int target) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] == target) {
                return i;
            }
        }
        return -1;
    }
    static int lastIndexOf(int[] values, int target) {
        for (int i = values.length - 1; i >= 0; i--) {
            if (values[i] == target) {
                return i;
            }
        }
        return -1;
    }
    static int countOccurrences(int[] values, int target) {
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == target) {
                count++;
            }
        }
        return count;
    }
}
