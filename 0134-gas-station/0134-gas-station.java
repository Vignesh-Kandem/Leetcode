class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int balance=0;
        int defect=0;
        int start=0;
        for(int i=0;i<gas.length;i++) {
            balance=balance+gas[i]-cost[i];
            if(balance<0) {
                defect=defect+balance;
                balance=0;
                start=i+1;
            }
        }
        if((balance+defect)<0) return -1;
        return start;
    }
}