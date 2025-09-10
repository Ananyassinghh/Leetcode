class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int ans=0;
        for(int vals: nums){
            ans=ans^vals;
        }
        return ans;
    }
};