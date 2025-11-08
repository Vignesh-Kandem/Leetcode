class Solution {
    public List<Integer> majorityElement(int[] arr) {
        int n=arr.length;
        int cnt1=0,cnt2=0;
        int el1=Integer.MIN_VALUE;
        int el2=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            if(cnt1==0 && arr[i]!=el2) {
                cnt1=1;
                el1=arr[i];
            }
            else if(cnt2==0 && arr[i]!=el1) {
                cnt2=1;
                el2=arr[i];
            }
            else if(el1==arr[i]) cnt1++;
            else if(el2==arr[i]) cnt2++;
            else {
                cnt1--;
                cnt2--;
            }
        }
        List<Integer> lst=new ArrayList<>();
        int count1=0, count2=0;
        for(int i=0;i<n;i++) {
            if(arr[i]==el1) count1++;
            if(arr[i]==el2) count2++;
        }
        int mini=(int)(n/3)+1;
        if(count1>=mini) lst.add(el1);
        if(count2>=mini) lst.add(el2);
        return lst;
    }
}