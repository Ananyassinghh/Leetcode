class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int cs=0;
        int maxs=INT_MIN;
        for(int vals: nums){
            cs+=vals;
            maxs=max(maxs, cs);
            if(cs<0){
                cs=0;
            }
        }
        return maxs;
    }
    
};