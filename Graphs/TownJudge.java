package ChatGPT_Problems.Graphs;

public class TownJudge {
    public static void main(String[] args) {

        int n = 5;
        int[][] trust = {
                {1,4},
                {2,4},
                {3,4},
                {5,4}
        };
        System.out.println(findJudge(n , trust));
    }
    static int findJudge(int n , int[][] trust ){

        int[] score = new int[n+1];

        for(int[] relation : trust){
            int a = relation[0];
            int b = relation[1];

            score[a]--;
            score[b]++;
        }
        for (int person = 1; person <= n; person++) {
            if(score[person] == n-1){
                return person;
            }
        }
        return -1;
    }
}
