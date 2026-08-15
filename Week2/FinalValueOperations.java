public class FinalValueOperations {
    public int finalValueAfterOperations(String[] operations) {
        int X = 0;
        for(String op : operations){
            if(op.equals("++X") || op.equals("X++")){
                X = X + 1;
            }
            else if(op.equals("--X") || op.equals("X--")){
                X = X - 1;
            }
        }
        return X;
    }
}

