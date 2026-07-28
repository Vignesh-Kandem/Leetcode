class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans=new ArrayList<>();
        for(int i=1;i<=9;i++) {
            int num=0;
            for(int j=i;j<=9;j++) {
                num=num*10+j;
                if(num>=low && num<=high) ans.add(num);
            }
        }
        Collections.sort(ans);
        return ans;
    }
} 