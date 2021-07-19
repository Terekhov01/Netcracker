package task2.dice;

import java.security.InvalidParameterException;
import java.util.*;

/*
Реализуйте игру в кости. Играют N игроков (компьютер в списке последний).
Подкидываются одновременно К кубиков. Выигрывает тот, у кого большая
сумма очков. Кто выиграл, тот и кидает первым в следующем кону. Игра идет
до 7 выигрышей. Начинаете игру Вы.
 */

interface DiceInterface{
    void dropCubes(int firstTurn, int N, int K);
    void play();
    boolean gameIsOver();
}

public class Dice implements DiceInterface{
    private int N; //N players and 1 computer
    private int K; //K cubes
    int[] points; //sum of points
    int[] wins; //amount of wins
    Random random = new Random();
    int winner = 0; //winner's index
    int firstTurn = 0;
    int max = 0;
    Dice(int N, int K){
        if (N <= 0 || K <= 0){
            throw new InvalidParameterException();
        }
        this.N = N;
        this.K = K;
        points = new int[N+1];
        wins = new int[N+1];
    }
    public void dropCubes(int firstTurn_, int N_, int K_){
        for(int i=firstTurn_;i<N_+1;i++){
            System.out.print("player #" + i + " drop cubes: ");
            for(int j=0;j<K_;j++){
                int point = random.nextInt(5) + 1;
                points[i] += point;
                System.out.print(point + " ");
            }
            System.out.println("\n" + points[i] + " points!");
            if (points[i] > max){
                max = points[i];
                winner = i;
            }
            points[i] = 0;
        }
        for(int i=0;i<firstTurn_;i++){
            System.out.print("player #" + i + " drop cubes: ");
            for(int j=0;j<K_;j++){
                int point = random.nextInt(5) + 1;
                points[i] += point;
                System.out.print(point + " ");
            }
            System.out.println("\n" + points[i] + " points!");
            if (points[i] > max){
                max = points[i];
                winner = i;
            }
            points[i] = 0;
        }
        max = 0;
        wins[winner]++;
    }
    public boolean gameIsOver(){
        if (wins[winner] == 7){
            System.out.println("Winner of the GAME: player #" + winner + " won!");
            return true;
        }
        return false;
    }
    public void play(){

        while (!gameIsOver()){
            dropCubes(firstTurn, N, K);
            System.out.println("Winner of the round: player #" + winner + " with " + max + " points!\n");
            for (int player: wins) {
                System.out.print(player + " ");
            }
            System.out.println("\n");
            firstTurn = winner; //first try in next round for winner
        }
    }
    public static void main(String[] args) {
        Dice dice = new Dice(3, 3);
        dice.play();
    }
}
