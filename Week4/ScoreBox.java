class ScoreBox {
    private int score;

    
    public ScoreBox(int score) {
        if (score < 0) {
            System.out.println("Error: Score cannot be negative.");
            this.score = 0;
            return;
        }

        this.score = score;
    }

   
    public int getScore() {
        return score;
    }

   
    public void setScore(int score) {
        if (score < 0) {
            System.out.println("Error: Score cannot be negative.");
            return;
        }

        this.score = score;
    }

    
    public String toString() {
        return "ScoreBox{score=" + score + "}";
    }
}


public class ScoreBoxDriver {

    
    static void addBonus(ScoreBox box, int bonus) {

        if (bonus < 0) {
            System.out.println("Error: Bonus cannot be negative.");
            return;
        }

        box.setScore(box.getScore() + bonus);
    }

    
    static void replaceLocally(ScoreBox box) {

        box = new ScoreBox(999);

        System.out.println("Inside replaceLocally(): " + box);
    }

    // Creates and returns a NEW object
    static ScoreBox createScoreBox(int score) {
        return new ScoreBox(score);
    }


    public static void main(String[] args) {


        ScoreBox box1 = new ScoreBox(50);

        ScoreBox alias = box1;

        System.out.println("box1: " + box1);
        System.out.println("alias: " + alias);

        System.out.println("box1 == alias: " + (box1 == alias));

        alias.setScore(80);

        System.out.println("\nAfter changing score through alias:");

        System.out.println("box1: " + box1);
        System.out.println("alias: " + alias);

        ScoreBox box2 = new ScoreBox(30);

        System.out.println("\nSeparate ScoreBox:");

        System.out.println("box1: " + box1);
        System.out.println("box2: " + box2);

        System.out.println("box1 == box2: " + (box1 == box2));
        addBonus(box1, 10);

        System.out.println("\nAfter addBonus(box1, 10):");
        System.out.println("box1: " + box1);


        System.out.println("\nBefore replaceLocally():");
        System.out.println("box1: " + box1);

        replaceLocally(box1);

        System.out.println("\nAfter replaceLocally():");
        System.out.println("box1: " + box1);


        ScoreBox box3 = createScoreBox(200);

        System.out.println("\nNewly created ScoreBox:");
        System.out.println("box3: " + box3);

        System.out.println("\nReference identity comparisons:");

        System.out.println("box1 == alias: " + (box1 == alias));
        System.out.println("box1 == box2: " + (box1 == box2));
        System.out.println("box1 == box3: " + (box1 == box3));
        System.out.println("box2 == box3: " + (box2 == box3));
    }
}
