import java.util.Arrays;
class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i = 0, j = 0;
        int nmatches = 0;
        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                nmatches++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return nmatches;
    }
}