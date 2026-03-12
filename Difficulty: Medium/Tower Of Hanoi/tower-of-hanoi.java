class Solution {
    public int towerOfHanoi(int n, int from, int to, int aux) {
        //Base Condidtion
        if (n == 0) {
            return 0;
        }
        
        int moves = 0;
        
        // move n-1 disks from source to auxiliary
        moves += towerOfHanoi(n - 1, from, aux, to);
        
        // move nth disk from source to destination
        moves += 1;
        
        // move n-1 disks from auxiliary to destination
        moves += towerOfHanoi(n - 1, aux, to, from);
        
        return moves;
    }
}