import java.util.*;
class Solution {
    public boolean magneticForce(int position[], int force, int m) {
        int n=position.length;
		int countballs=1;
		int last=position[0];
		for(int i=1;i<n;i++) {
			if(position[i]-last>=force) {
				countballs++;
				last=position[i];
			}
		}
		if(countballs>=m) return true;
		else return false;
	}
    public int maxDistance(int[] position, int m) {
        int n=position.length;
        Arrays.sort(position);
        int low=1;
        int high=position[n-1]-position[0];
        int ans=0;
        while(low<=high) {
            int mid=low+(high-low)/2;
            if(magneticForce(position,mid,m)==true) {
                ans=mid;
                low=mid+1;
            }
            else {
                high=mid-1;
            }
        }
        return ans;
    }
}