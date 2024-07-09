class Solution {
    public double averageWaitingTime(int[][] customers) {
        double sum = customers[0][1];
        double cur = customers[0][1] + customers[0][0];

        for(int i=1;i<customers.length;i++){
            if(customers[i][0] <= cur){
                cur+=customers[i][1];
                sum += cur-customers[i][0];
            }
            else{
                sum += customers[i][1];
                cur = customers[i][1] + customers[i][0];
            }
        }
        return sum /= customers.length; 
    }
}
