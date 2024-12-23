import java.util.Random;

public class PairOfDice {

    private int Dice1;
    private int Dice2;
    private Random rand;

    public PairOfDice(int val1, int val2) {
        this.Dice1 = val1;
        this.Dice2 = val2;
        this.rand = new Random();
    }

    public PairOfDice() {
        this.rand = new Random();
        roll();
    }

    public void roll(){
        this.Dice1 = rand.nextInt(6) + 1;
        this.Dice2 = rand.nextInt(6) + 1;
    }

    public int value() {
        return Dice1 + Dice2;
    }

    public String toString() {
        return Dice1 + " : " + Dice2 + " = " + value();
    }

    public static void simulateCraps() {
        PairOfDice dicePair = new PairOfDice();
        int wins = 0;
        int losses = 0;

        for (int i = 0; i < 100000; i++){
            dicePair.roll();
            int comeOutRoll = dicePair.value();

            if (comeOutRoll == 7 || comeOutRoll ==11) {
                wins++;
            } else if (comeOutRoll == 2 || comeOutRoll == 3 || comeOutRoll == 12){
                losses++;
            } else {
                int point = comeOutRoll;
                boolean pointRolled = false;
                boolean sevenRolled = false;

                while (!pointRolled && !sevenRolled) {
                    dicePair.roll();
                    int rollValue = dicePair.value();
                    if (rollValue == point) {
                        pointRolled = true;
                    } else if (rollValue == 7) {
                        sevenRolled = true;
                    }
                }

                if (pointRolled) {
                    wins++;
                } else {
                    losses++;
                }
            }
            System.out.println("Wins: " + wins);
            System.out.println("Losses:" + losses);
        }
    }
}